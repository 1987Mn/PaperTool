package com.lzw.view.clbum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lzw.domain.Clbum;
import com.lzw.domain.Student;
import com.lzw.service.ClbumsService;
import com.lzw.service.imp.ClbumsServiceImp;
import com.lzw.util.JTextFieldHintListener;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class ClbumsJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ClbumsJPanel clbumsJPanel = new ClbumsJPanel();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JScrollPane scrollPane;

	private ClbumsService clbumsService = (ClbumsServiceImp) SM.getBean(ClbumsServiceImp.class);

	/**
	 * Create the panel.
	 */
	public static ClbumsJPanel getClbumsJPanel() {
		clbumsJPanel.setData(clbumsJPanel.getClbumsService().queryList());
		return clbumsJPanel;
	}

	private ClbumsJPanel() {

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addFocusListener(new JTextFieldHintListener(textField_1, "请输入班级"));

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.addFocusListener(new JTextFieldHintListener(textField_2, "请输入专业"));

		JButton queryJButton = new JButton("查询");
		queryJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Clbum cb = new Clbum();
				String banji = textField_1.getText().trim();
				String zhuanye = textField_2.getText().trim();

				if (!"".equals(banji) && !"请输入班级".equals(banji)) {
					cb.setClbumname(banji);
				}
				
				if (!"".equals(zhuanye) && !"请输入专业".equals(zhuanye)) {
					cb.setMajor(zhuanye);
				}
				clbumsJPanel.setData(clbumsJPanel.getClbumsService().queryList(cb));
				Main.updateUI(clbumsJPanel);
			}

		});

		JButton addJButton = new JButton("添加班级");
		addJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(new AddClbumJPanel());
			}

		});

		scrollPane = new JScrollPane();

		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			// 表格不允许被编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		// 添加点击事件，进入班级
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.rowAtPoint(e.getPoint());
					Integer id = (Integer) table.getValueAt(row, 4);

					Student student = new Student();
					student.setClbumid(id);

					Main.updateUI(StudentJPanel.getStudentJPanel(student));
				}
			}
		});

		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] ids = table.getSelectedRows();
				for (int i = 0; i < ids.length; i++) {
					try {
						clbumsService.delete(Integer.valueOf(table.getValueAt(ids[i], 4).toString()));
						Main.updateUI(ClbumsJPanel.getClbumsJPanel());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "删除班级" + table.getValueAt(ids[i], 1).toString() + "失败",
								"错误！", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(queryJButton).addGap(31)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE).addComponent(button)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(addJButton)))
				.addGap(16)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(queryJButton).addComponent(addJButton)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		setLayout(groupLayout);

	}

	private void setData(List<Clbum> clbums) {
		Object[][] data = new Object[clbums.size()][5];
		for (int i = 0; i < data.length; i++) {
			Clbum clb = clbums.get(i);
			data[i][0] = clb.getNianji();
			data[i][1] = clb.getClbumname();
			data[i][2] = clb.getMajor();
			data[i][3] = clb.getPeoplenum();
			data[i][4] = clb.getId();
		}

		table.setModel(new DefaultTableModel(data, new String[] { "年级", "班级", "专业", "人数", "" }));

		// 隐藏某一列
		TableColumn tc = table.getTableHeader().getColumnModel().getColumn(4);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setWidth(0);
		tc.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

//		居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 5; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}

		scrollPane.setViewportView(table);
	}

	public JTextField getTextField() {
		return textField_1;
	}

	public void setTextField(JTextField textField) {
		this.textField_1 = textField;
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

	public ClbumsService getClbumsService() {
		return clbumsService;
	}

	public void setClbumsService(ClbumsService clbumsService) {
		this.clbumsService = clbumsService;
	}
}
