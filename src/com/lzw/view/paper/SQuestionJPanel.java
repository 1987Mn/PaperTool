package com.lzw.view.paper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lzw.domain.Paper;
import com.lzw.domain.Question;
import com.lzw.domain.Smallquestion;
import com.lzw.service.PaperService;
import com.lzw.service.QuestionService;
import com.lzw.service.SmallQuestionService;
import com.lzw.service.imp.PaperServiceImp;
import com.lzw.service.imp.QuestionServiceImp;
import com.lzw.service.imp.SmallQuestionServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class SQuestionJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Map<Integer, Question> questions;

	private Integer qid;

	private Paper paper;
	
	private SQuestionJPanel squestionJPanel;
	
	private Map<Integer,Integer> sqNum;
	
	private PaperService paperService = (PaperServiceImp) SM.getBean(PaperServiceImp.class);
	private QuestionService questionService = (QuestionServiceImp) SM.getBean(QuestionServiceImp.class);
	private SmallQuestionService squestionService = (SmallQuestionServiceImp) SM.getBean(SmallQuestionServiceImp.class);
	

	/**
	 * Create the panel.
	 */
	public SQuestionJPanel(Paper paper) {
		
		this.paper = paper;
		this.squestionJPanel= this;
		sqNum = new HashMap<>();
		
//		设置窗体
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setPreferredSize(new Dimension(100, 100));// 关键代码,设置JPanel的大小

		Question question = new Question();
		question.setPaperid(paper.getId());
		questions = questionService.queryList(question);

		Set<Integer> sets = questions.keySet();
		

		
		for (Integer integer : sets) {
			JButton button_1 = new JButton("第" + questions.get(integer).getContent() + "题");
			qid = integer;
			button_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					qid = integer;
					List<Smallquestion> list = questions.get(qid).getSmallqs();
					setData(list,sqNum.get(qid));
				}
			});
			panel.add(button_1);
			
			List<Smallquestion> list = questions.get(integer).getSmallqs();
			if (list.size() == 0) {
				sqNum.put(integer, questions.get(integer).getSmallquestionnum());
			} else {
				sqNum.put(integer, 0);
			}
			
		}

		JButton button_3 = new JButton("保  存");
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] datag = new Object[7];
				Question question = new Question();
				question.setPaperid(paper.getId());
//				记录插入成功数量
				int num01 = 0;
//				记录每道大题分值
				Double qScore = 0.0;
				for (int i = 0; i < table.getRowCount(); i++) {
					Integer sid = (Integer) table.getValueAt(i, 7);
					
					for (int j = 0; j < 7; j++) {
						datag[j] = table.getValueAt(i, j);
					}
					
					Smallquestion smallQuestion = new Smallquestion();
					boolean flag = false;
					Object obj = null ;
					try {
						Double scnum = 0.0;
						int scnum01 = 0;
						
						if(!isem(datag[2])) {
							flag = true;
							obj = datag[2];
							scnum +=Double.valueOf(datag[2].toString());
							if(Double.valueOf(datag[2].toString())!=0.0) {
								scnum01++;
							}
							smallQuestion.setScorepoint1(Double.valueOf(datag[2].toString()));
						}
						if(!isem(datag[3])) {
							flag = true;
							obj = datag[3];
							scnum +=Double.valueOf(datag[3].toString());
							if(Double.valueOf(datag[3].toString())!=0.0) {
								scnum01++;
							}
							smallQuestion.setScorepoint2(Double.valueOf(datag[3].toString()));
						}
						if(!isem(datag[4])) {
							flag = true;
							obj = datag[4];
							scnum +=Double.valueOf(datag[4].toString());
							if(Double.valueOf(datag[4].toString())!=0.0) {
								scnum01++;
							}
							smallQuestion.setScorepoint3(Double.valueOf(datag[4].toString()));
						}
						if(!isem(datag[5])) {
							flag = true;
							obj = datag[5];
							scnum +=Double.valueOf(datag[5].toString());
							if(Double.valueOf(datag[5].toString())!=0.0) {
								scnum01++;
							}
							smallQuestion.setScorepoint4(Double.valueOf(datag[5].toString()));
						}
						if(!isem(datag[6])) {
							flag = true;
							obj = datag[6];
							scnum +=Double.valueOf(datag[6].toString());
							if(Double.valueOf(datag[4].toString())!=0.0) {
								scnum01++;
							}
							smallQuestion.setScorepoint5(Double.valueOf(datag[6].toString()));
						}
						smallQuestion.setScorepointnum(scnum01);
						
						qScore +=  scnum;
						if(sid == null) {
							if(flag) {
								smallQuestion.setContent((i + 1) + "");
								smallQuestion.setQuestionid(qid);
								smallQuestion.setScore(scnum);
								squestionService.insert(smallQuestion);
								num01++;
							}
						}else {
							if(flag) {
								smallQuestion.setScore(scnum);
								smallQuestion.setId(sid);
								squestionService.update(smallQuestion);
							}
						}
					}catch(Exception num_ex) {
						//弹框提示，输入数字
						JOptionPane.showMessageDialog(null,"第"+(i+1)+"行,"+obj.toString(), "请输入数字",JOptionPane.ERROR_MESSAGE);
					}

				}
				questions.get(qid).setSmallqs(questionService.queryList(question).get(qid).getSmallqs());
				
//				大题更新小题数量
				Question obj = questionService.query(qid);
				obj.setSmallquestionnum(questions.get(qid).getSmallqs().size());
				obj.setScore(qScore);
				questionService.update(obj);
				
				questions = questionService.queryList(question);
				Double tem01 = 0.0;
				Integer tem02 = 0;
				for(Integer q01id:questions.keySet()) {
					tem01 += questions.get(q01id).getScore();
					tem02 +=questions.get(q01id).getSmallquestionnum();
				}
				
//				试卷更新小题数量
				Paper paper01 = paperService.query(paper.getId());
				paper01.setSmallquestionnum(tem02);
				paper01.setTotalpoints(tem01);
				paperService.update(paper01);
				
				setData(questions.get(qid).getSmallqs(),putSqNum(sqNum,qid,-num01));
				Main.updateUI(squestionJPanel);
			}

		});
		panel.add(button_3);

		JButton button_4 = new JButton("删  除");
		
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] ids = table.getSelectedRows();
				Double tem01 = 0.0;
				for (int i = 0; i < ids.length; i++) {
					try {
						Smallquestion smallquestion01 = squestionService.query(Integer.valueOf(table.getValueAt(ids[i], 7).toString()));
						tem01 += smallquestion01.getScore();
						squestionService.delete(Integer.valueOf(table.getValueAt(ids[i], 7).toString()));
					} catch (Exception e2) {
						putSqNum(sqNum,qid,-1);
					}
				}
				
				
				questions=questionService.queryList(question);
				
				Question obj = questionService.query(qid);
				obj.setSmallquestionnum(questions.get(qid).getSmallqs().size());
				obj.setScore(obj.getScore()-tem01);
				questionService.update(obj);
				
				questions=questionService.queryList(question);
				Integer tem02 = 0;
				Double tem03 = 0.0;
				for(Integer q01id:questions.keySet()) {
					tem03 += questions.get(q01id).getScore();
					tem02 +=questions.get(q01id).getSmallquestionnum();
				}
				
//				试卷更新小题数量
				Paper paper01 = paperService.query(paper.getId());
				paper01.setSmallquestionnum(tem02);
				paper01.setTotalpoints(tem03);
				paperService.update(paper01);
				
				setData(questions.get(qid).getSmallqs(),sqNum.get(qid));
				Main.updateUI(squestionJPanel);
			}
			
		});
		panel.add(button_4);
		
		
		JButton button_5 = new JButton("添  加");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("数量");  
				if(inputValue==null) {
					return;
				}
				int num =0;
				try {
					num = Integer.valueOf(inputValue.trim());
					setData(questions.get(qid).getSmallqs(),putSqNum(sqNum,qid,num));
					Main.updateUI(squestionJPanel);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "请输入数字",
							"错误！", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		panel.add(button_5);
		
		
		JButton button_6 = new JButton("返  回");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(new QuestionJPanel(paper));
			}

		});
		panel.add(button_6);

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


	private void setData(List<Smallquestion> squestions,int num) {
		Object[][] data;

		data = new Object[squestions.size()+num][8];
		int num01 = 0;
		for (int i = 0; i < data.length; i++) {
			
			if(i<squestions.size()) {
				Smallquestion squestion = squestions.get(i);
				data[i][0] =  questions.get(qid).getContent()+"."+squestion.getContent();
				data[i][1] = squestion.getScore();
				data[i][2] = squestion.getScorepoint1();
				data[i][3] = squestion.getScorepoint2();
				data[i][4] = squestion.getScorepoint3();
				data[i][5] = squestion.getScorepoint4();
				data[i][6] = squestion.getScorepoint5();
				data[i][7] = squestion.getId();
			}else {
				data[i][0] =  questions.get(qid).getContent()+"."+(i+1);
			}

		}
		table.setModel(new DefaultTableModel(data, new String[] { "题号", "分值", "得分点", "得分点", "得分点", "得分点", "得分点", "id" }));

		//隐藏某一列
		TableColumn tc = table.getTableHeader().getColumnModel().getColumn(7);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setWidth(0);
		tc.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
		

		// 设置居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 7; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		

	}
	
	private Integer putSqNum(Map<Integer,Integer>sqNum01,Integer qid,Integer num02) {
		Integer num03 =sqNum01.get(qid);
		num03 = num03+num02;
		sqNum01.put(qid, num03);
		return num03;
	}

	private boolean isem(Object obj) {
		if(obj!=null) {
			if(!obj.toString().trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
}
