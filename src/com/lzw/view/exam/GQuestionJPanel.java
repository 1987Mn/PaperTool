package com.lzw.view.exam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lzw.domain.Exam;
import com.lzw.domain.Grade;
import com.lzw.domain.Question;
import com.lzw.domain.Smallquestion;
import com.lzw.domain.Student;
import com.lzw.service.ExamsService;
import com.lzw.service.GradeService;
import com.lzw.service.QuestionService;
import com.lzw.service.SmallQuestionService;
import com.lzw.service.StudentService;
import com.lzw.service.imp.ExamsServiceImp;
import com.lzw.service.imp.GradeServiceImp;
import com.lzw.service.imp.QuestionServiceImp;
import com.lzw.service.imp.SmallQuestionServiceImp;
import com.lzw.service.imp.StudentServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class GQuestionJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Map<Integer, Question> questions;
	private List<Grade> glist;
	private Integer qid;
	private Exam exam = null;
	
	
	private JComboBox<String> studentBox;
	HashMap<Integer,Student> studentBoxMap;
	
	
	GradeService gradeService = (GradeServiceImp) SM.getBean(GradeServiceImp.class);
	QuestionService questionService = (QuestionServiceImp) SM.getBean(QuestionServiceImp.class);
	StudentService studentService = (StudentServiceImp) SM.getBean(StudentServiceImp.class);
	SmallQuestionService squestionService = (SmallQuestionServiceImp) SM.getBean(SmallQuestionServiceImp.class);
	ExamsService examService = (ExamsServiceImp) SM.getBean(ExamsServiceImp.class);
	
	

	/**
	 * Create the panel.
	 */
	public GQuestionJPanel(Exam exam) {
		this.setExam(exam) ;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setPreferredSize(new Dimension(100, 100));// 关键代码,设置JPanel的大小

		studentBox = new JComboBox<String>();
		studentBoxMap = new HashMap<>();
		studentBox.setModel(new DefaultComboBoxModel<String>(new String[] {"学生"}));
		Student stu01 = new Student();
		stu01.setClbumid(exam.getClbumid());
		List<Student> stulist =  studentService.queryList(stu01);
		int itemi = 1;
		for (Student stu02 : stulist) {
			studentBoxMap.put(itemi, stu02);
			itemi++;
			studentBox.addItem(stu02.getName());
		}
		panel.add(studentBox);
		
		
		questions = questionsToMap(exam.getPaper().getQuestions());

		Set<Integer> sets = questions.keySet();
		
		int i = 0;
		for (Integer integer : sets) {
			i++;
			JButton button_1 = new JButton("第" + questions.get(integer).getContent() + "题");
			button_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					qid = integer;
					
					List<Smallquestion> list = questions.get(integer).getSmallqs();
					glist = sqToGrade(list);
					if(glist!=null) {
						if (glist.size() == 0) {
							setData(questions.get(qid).getSmallquestionnum(), qid);
						} else {
							setData(glist);
						}
					}
				}
			});
			panel.add(button_1);
		}

		JButton button_3 = new JButton("保存");
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] datag = new Object[8];
				Question question = questions.get(qid);
				
				if(studentBox.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null,"请选择学生", "错误",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				for (int i = 0; i < table.getRowCount(); i++) {
					Integer gid = (Integer) table.getValueAt(i, 6);
					
					for (int j = 0; j < 7; j++) {
						datag[j] = table.getValueAt(i, j);
					}
					
					Grade grade = new Grade();

					boolean flag = false;
					Object obj = null ;
					double total =0;
					double temp = 0;
					
					try {
						if(!isem(datag[1])) {
							flag = true;
							obj = datag[1];
							temp = Double.valueOf(datag[1].toString());
							total +=temp;
							grade.setScorepoint1(temp);
						}
						if(!isem(datag[2])) {
							flag = true;
							obj = datag[2];
							temp = Double.valueOf(datag[2].toString());
							total +=temp;
							grade.setScorepoint2(temp);
							
						}
						if(!isem(datag[3])) {
							flag = true;
							obj = datag[3];
							temp = Double.valueOf(datag[3].toString());
							total +=temp;
							grade.setScorepoint3(temp);
							
						}
						if(!isem(datag[4])) {
							flag = true;
							obj = datag[4];
							temp = Double.valueOf(datag[4].toString());
							total +=temp;
							grade.setScorepoint4(temp);
						}
						if(!isem(datag[5])) {
							flag = true;
							obj = datag[5];
							temp = Double.valueOf(datag[5].toString());
							total +=temp;
							grade.setScorepoint5(temp);
						}
						
						grade.setTotalpoint(total);
						
						if(gid == null) {
							grade.setExamid(exam.getId());
							grade.setStudentid(studentBoxMap.get(studentBox.getSelectedIndex()).getSid());
							grade.setSmallquestionid(question.getSmallqs().get(i).getId());
							gradeService.insert(grade);
						}else {
							if(flag) {
								grade.setId(gid);
								gradeService.update(grade);
							}
						}
					}catch(Exception num_ex) {
						//弹框提示，输入数字
						JOptionPane.showMessageDialog(null,"第"+i+"行,"+obj.toString(), "请输入数字",JOptionPane.ERROR_MESSAGE);
					}

				}
				
				exam.getPaper().setQuestions(examService.query(exam).getPaper().getQuestions());
				questions = questionsToMap(exam.getPaper().getQuestions());
				glist = sqToGrade(questions.get(qid).getSmallqs());
				
				if(glist!=null) {
					setData(glist);
				}

			}

		});
		
		panel.add(button_3);

		JButton button_4 = new JButton("返回");

		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(ExamsJPanel.getExamsJPanel());
			}

		});
		panel.add(button_4);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 804, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 43, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setViewportView(table);

	}

	private void setData(Integer num, Integer qid) {
		Object[][] data;
		data = new Object[num][7];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = questions.get(qid).getContent() + "." + (i + 1);
		}
		
		table.setModel(new DefaultTableModel(data, new String[] { "题号", "得分点", "得分点", "得分点", "得分点", "得分点", "id" }));

		//隐藏某一列
		TableColumn tc = table.getTableHeader().getColumnModel().getColumn(6);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setWidth(0);
		tc.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
		// 设置居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 6; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		
	}

	private void setData(List<Grade> grades) {
		Object[][] data;
		data = new Object[grades.size()][7];
		for (int i = 0; i < data.length; i++) {
			Grade grade = grades.get(i);
			data[i][0] =  questions.get(qid).getContent()+"."+questions.get(qid).getSmallqs().get(i).getContent();
			data[i][1] = grade.getScorepoint1();
			data[i][2] = grade.getScorepoint2();
			data[i][3] = grade.getScorepoint3();
			data[i][4] = grade.getScorepoint4();
			data[i][5] = grade.getScorepoint5();
			data[i][6] = grade.getId();
			
		}
		table.setModel(new DefaultTableModel(data, new String[] { "题号", "得分点", "得分点", "得分点", "得分点", "得分点", "id" }));
		
		//隐藏某一列
		TableColumn tc = table.getTableHeader().getColumnModel().getColumn(6);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setWidth(0);
		tc.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
		
		// 设置居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 6; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		
	}

	private boolean isem(Object obj) {
		if(obj!=null) {
			if(!obj.toString().trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	private List<Grade> sqToGrade(List<Smallquestion> sqs01){
		List<Grade> glist01 = new ArrayList<>();
		
		if(studentBox.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null,"请选择学生", "错误",JOptionPane.ERROR_MESSAGE);
			return null;
		}else {
			for (Smallquestion sq01 : sqs01) {
				Grade gra01 = sq01.getGradeMap().get(studentBoxMap.get(studentBox.getSelectedIndex()).getSid());
				if(gra01!=null) {
					glist01.add(gra01);
				}
			}
		}
		
		return glist01;
	}
	
	private Map<Integer,Question> questionsToMap(List<Question> qsList){
		Map<Integer,Question> qm = new HashMap<>();
		
		for (Question question : qsList) {
			qm.put(question.getId(), question);
		}
		return qm; 
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
