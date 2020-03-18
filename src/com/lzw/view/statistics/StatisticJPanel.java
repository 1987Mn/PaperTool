package com.lzw.view.statistics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lzw.domain.Exam;
import com.lzw.service.ExamsService;
import com.lzw.service.imp.ExamsServiceImp;
import com.lzw.util.GradeUtil;
import com.lzw.util.JTextFieldHintListener;
import com.lzw.util.SM;
import com.lzw.view.Main;
import com.lzw.view.statistics.statisticsB.StatisticQuestionBJPanel;
import com.lzw.view.statistics.statisticsY.StatisticQuestionJPanel;

public class StatisticJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StatisticJPanel statisticJPanel = new StatisticJPanel();
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	JComboBox comboBox;
	private GradeUtil gradeUtil;

	private ExamsService examsService = (ExamsServiceImp) SM.getBean(ExamsServiceImp.class);
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public static StatisticJPanel getStatisticJPanel() {
		statisticJPanel.setData(statisticJPanel.getExamsService().queryList(null, null));
		return statisticJPanel;
	}

	private StatisticJPanel() {

		textField = new JTextField();
		textField.setColumns(10);
		textField.addFocusListener(new JTextFieldHintListener(textField, "请输入专业"));

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addFocusListener(new JTextFieldHintListener(textField_1, "请输入试卷"));

		JButton queryJButton = new JButton("查询");
		queryJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String major = textField.getText().trim();
				String shijuan = textField_1.getText().trim();

				if ("".equals(major) || "请输入专业".equals(major)) {
					major = null;
				}
				if ("".equals(shijuan) || "请输入试卷".equals(shijuan)) {
					shijuan = null;
				}

				statisticJPanel.setData(statisticJPanel.getExamsService().queryList(major, shijuan));
				Main.updateUI(statisticJPanel);
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

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "统计结果" }));
		comboBox.addItem("原始成绩");
		comboBox.addItem("标准化成绩");
		comboBox.addItem("原始成绩统计");
		comboBox.addItem("标准化成绩统计");

		// 添加点击事件，进入统计界面
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.rowAtPoint(e.getPoint());
					Integer id = (Integer) table.getValueAt(row, 5);

					Exam exam = new Exam();
					exam.setId(id);
					exam = examsService.query(exam);
					gradeUtil = new GradeUtil(exam);
					switch (comboBox.getSelectedIndex()) {
					case 1:
						new TableJFrame(gradeUtil, "原始成绩");
						break;
					case 2:
						new TableJFrame(gradeUtil, "标准化成绩");
						break;
					case 3:
						Main.updateUI(new StatisticQuestionJPanel(gradeUtil));
						break;
					case 4:
						Main.updateUIa(new StatisticQuestionBJPanel(gradeUtil));
						break;
					default:
						JOptionPane.showMessageDialog(null, "请选择统计结果", "错误！", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(queryJButton).addGap(31)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(16)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(5)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(queryJButton)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		setLayout(groupLayout);

	}

	private void setData(List<Exam> exams) {
		Object[][] data = new Object[exams.size()][6];
		for (int i = 0; i < data.length; i++) {
			Exam exam = exams.get(i);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
			data[i][0] = sf.format(exam.getTestdate());
			data[i][1] = exam.getClbum().getMajor();
			data[i][2] = exam.getPeoplenum();
			data[i][3] = exam.getClbumroom();
			data[i][4] = exam.getPaper().getTitle();
			data[i][5] = exam.getId();

		}

		table.setModel(new DefaultTableModel(data, new String[] { "考试日期", "专业", "人数", "教室", "试卷", "" }));

		// 隐藏某一列
		TableColumn tc = table.getTableHeader().getColumnModel().getColumn(5);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setWidth(0);
		tc.setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);

//		居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 6; i++) {
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

	public ExamsService getExamsService() {
		return examsService;
	}

	public void setExamsService(ExamsService examsService) {
		this.examsService = examsService;
	}
}
