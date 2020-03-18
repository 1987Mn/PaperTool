package com.lzw.view.clbum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.lzw.domain.Clbum;
import com.lzw.domain.Exam;
import com.lzw.domain.Student;
import com.lzw.service.ClbumsService;
import com.lzw.service.ExamsService;
import com.lzw.service.StudentService;
import com.lzw.service.imp.ClbumsServiceImp;
import com.lzw.service.imp.ExamsServiceImp;
import com.lzw.service.imp.StudentServiceImp;
import com.lzw.util.JTextFieldHintListener;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class StudentJPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static StudentJPanel studentJPanel = new StudentJPanel();
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton queryButton;
	private JButton addButton;
	
	//班级id
	private Student student;
	
	private ExamsService examsService = (ExamsServiceImp)SM.getBean(ExamsServiceImp.class) ;
	private ClbumsService clbumsService = (ClbumsServiceImp) SM.getBean(ClbumsServiceImp.class);
	private  StudentService studentService = (StudentServiceImp)SM.getBean(StudentServiceImp.class) ;
	private JButton button;
	private JTextField textField_1;
	private JButton button_1;


	/**
	 * Create the panel.
	 */
	public static StudentJPanel getStudentJPanel(Student student) {
		studentJPanel.student = student;
		studentJPanel.setData(studentJPanel.getStudentService().queryList(student));
		return studentJPanel;
	}
	
	private  StudentJPanel() {

		textField = new JTextField();
		textField.setColumns(7);
		textField.addFocusListener(new JTextFieldHintListener(textField, "请输入学号"));
		
		textField_1 = new JTextField();
		textField_1.setColumns(7);
		textField_1.addFocusListener(new JTextFieldHintListener(textField_1, "请输入姓名"));
		
		button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] ids = table.getSelectedRows();
				for (int i = 0; i < ids.length; i++) {
					try {
						studentService.delete(table.getValueAt(ids[i], 0).toString());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "删除学生：" + table.getValueAt(ids[i], 1).toString() + "失败",
								"错误！", JOptionPane.ERROR_MESSAGE);
					}
				}
				
//				更新班级的人数
				Student obj = new Student();
				obj.setClbumid(student.getClbumid());
				
				Clbum clbum = clbumsService.query(student.getClbumid());
				int peoplenum = studentService.queryList(obj).size();
				clbum.setPeoplenum(peoplenum);
				clbumsService.update(clbum);
				
				Exam exam01 = new Exam();
				exam01.setClbumid(clbum.getId());
				List<Exam> elist =examsService.queryList(exam01);
				for (Exam exam02: elist) {
					exam02.setPeoplenum(peoplenum);
					examsService.update(exam02);
				}
				
				
				Main.updateUI(StudentJPanel.getStudentJPanel(student));
				
				
			}
		});
		
		
		queryButton = new JButton("查询");
		queryButton.addActionListener(this);
		
		addButton = new JButton("添加");
		addButton.addActionListener(this);
		
		scrollPane = new JScrollPane();
		
		button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(ClbumsJPanel.getClbumsJPanel());
			}
		});
		
		
		
		JButton importJButton = new JButton("导入");
		
		JFileChooser fileChooser = new JFileChooser();

		importJButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int i = fileChooser.showOpenDialog(Main.getMainFrame().getContentPane());// 显示文件选择对话框

				// 判断用户单击的是否为“打开”按钮
				if (i == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();// 获得选中的文件对象
					
					InputStream in;
					try {
						in = new FileInputStream(selectedFile);
						POIFSFileSystem fs = new POIFSFileSystem(in);
						HSSFWorkbook workbook = new HSSFWorkbook(fs);
						HSSFSheet sheet = workbook.getSheetAt(0);
						
						List<Student> studentlist = new ArrayList<>();
						boolean flag = false;
						for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) {
							if(flag){
								String xuehao = sheet.getRow(j).getCell(0).getStringCellValue();
								String name   = sheet.getRow(j).getCell(1).getStringCellValue();
								Student student = new Student();
								student.setName(name);
								student.setSid(xuehao);
								student.setClbumid(studentJPanel.student.getClbumid());
								studentlist.add(student);
							}else {
								if(sheet.getRow(j).getCell(0).getStringCellValue().contentEquals("学号")) {
									flag = true;
								}
							}
						}

						for(Student stu: studentlist) { studentService.insert(stu); }
						Main.updateUI(StudentJPanel.getStudentJPanel(student));
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "文件无法打开", "错误", JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						//POIFSFileSystem fs = new POIFSFileSystem(in);
						JOptionPane.showMessageDialog(null, "文件无法打开", "错误", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}

					
				}
			}
			
		});
		

		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(queryButton)
							.addGap(31)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
							.addComponent(importJButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)))
					.addGap(16))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(queryButton)
						.addComponent(button)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addButton)
						.addComponent(button_1)
						.addComponent(importJButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			//表格不允许被编辑
			public boolean isCellEditable(int row, int column){
                   return false;
        	}
        
		}; 
			
		List<Student> students = studentService.queryList();
		setData(students);
		scrollPane.setViewportView(table);
		
		setLayout(groupLayout);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton)e.getSource();
		
		//查询学生
		if(obj==queryButton) {
			Student student01 = new Student();
			
			student01.setClbumid(student.getClbumid());
			String xuehao = textField.getText().trim();
			String xingming = textField_1.getText().trim();

			if (!"".equals(xuehao) && !"请输入学号".equals(xuehao)) {
				student01.setSid(xuehao);
			}
			
			if (!"".equals(xingming) && !"请输入姓名".equals(xingming)) {
				student01.setName(xingming);
			}
			System.out.println(student01);
			studentJPanel.setData(studentService.queryList(student01));
			Main.updateUI(studentJPanel);
//			添加学生
		}else if(obj==addButton) {
			String inputValue = JOptionPane.showInputDialog("请输入添加人数");  //弹框
			if(inputValue!=null) {
				if(!inputValue.trim().equals("")) {
					Main.updateUI(new AddStudentJPanel(Integer.valueOf(inputValue),student));
				}
			}
		}
	}
	
	private void setData(List<Student> students) {
		Object[][] data = new Object[students.size()][2];
		for(int i = 0 ;i<data.length;i++){
			Student stu = students.get(i);
			data[i][0]=stu.getSid();
			data[i][1]=stu.getName();
		}

		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D"
			}
		));
		
//		居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 2; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		
		scrollPane.setViewportView(table);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getQueryButton() {
		return queryButton;
	}

	public void setQueryButton(JButton queryButton) {
		this.queryButton = queryButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
