package com.lzw.view.clbum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import com.lzw.domain.Clbum;
import com.lzw.domain.Exam;
import com.lzw.domain.Student;
import com.lzw.service.ClbumsService;
import com.lzw.service.ExamsService;
import com.lzw.service.StudentService;
import com.lzw.service.imp.ClbumsServiceImp;
import com.lzw.service.imp.ExamsServiceImp;
import com.lzw.service.imp.StudentServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class AddStudentJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable table;

	private ExamsService examsService = (ExamsServiceImp)SM.getBean(ExamsServiceImp.class) ;
	private StudentService studentService = (StudentServiceImp) SM.getBean(StudentServiceImp.class);
	private ClbumsService clbumsService = (ClbumsServiceImp) SM.getBean(ClbumsServiceImp.class);

	/**
	 * Create the panel.
	 */
	public AddStudentJPanel(Integer num, Student student) {
		setLayout(new BorderLayout(0, 0));

		// 添加表格
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			// 单击编辑
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
				super.changeSelection(rowIndex, columnIndex, toggle, extend);
				super.editCellAt(rowIndex, columnIndex, null);
			}
		};
		Object[][] data = new Object[num][2];
		table.setModel(new DefaultTableModel(data, new String[] { "\u5B66\u53F7", "\u59D3\u540D" }));
		scrollPane.setViewportView(table);
		
//		居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 2; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}

		// 添加保存按钮
		JButton saveJButton = new JButton("保存");

		saveJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				for (int row = 0; row < table.getRowCount(); row++) {
					String id = (String) table.getValueAt(row, 0);
					String name = (String) table.getValueAt(row, 1);

					if (id != null && name != null) {
						if (!"".equals(id.trim()) && !"".equals(name.trim())) {
							Student stu = new Student(id, name, student.getClbumid());
							try {
								studentService.insert(stu);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null,
										"学号：" + id + "姓名：" + name + "添加失败!",
										"错误！",
										JOptionPane.ERROR_MESSAGE);
								Main.updateUI(StudentJPanel.getStudentJPanel(student));
							}
						}
					}else {
						JOptionPane.showMessageDialog(null,
								"学号：" + id + "姓名：" + name==null?"空！":name + "添加失败!",
								"错误！",
								JOptionPane.ERROR_MESSAGE);
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

		// 取消
		JButton backJButton = new JButton("取消");
		backJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(StudentJPanel.getStudentJPanel(student));
			}

		});

		JPanel south = new JPanel();

		add(south, BorderLayout.SOUTH);
		GroupLayout gl_south = new GroupLayout(south);
		gl_south.setHorizontalGroup(
				gl_south.createParallelGroup(Alignment.LEADING).addGroup(gl_south.createSequentialGroup().addGap(278)
						.addComponent(saveJButton).addGap(51).addComponent(backJButton).addGap(345)));
		gl_south.setVerticalGroup(gl_south.createParallelGroup(Alignment.LEADING).addGroup(
				gl_south.createParallelGroup(Alignment.BASELINE).addComponent(saveJButton).addComponent(backJButton)));
		south.setLayout(gl_south);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
