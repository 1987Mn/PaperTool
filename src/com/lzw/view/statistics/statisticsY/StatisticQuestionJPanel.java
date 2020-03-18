package com.lzw.view.statistics.statisticsY;

import com.lzw.domain.Exam;
import com.lzw.domain.Question;
import com.lzw.util.GradeUtil;
import com.lzw.view.Main;
import com.lzw.view.statistics.StatisticJPanel;
import com.lzw.view.statistics.pictureFrame.BarChart;
import com.lzw.view.statistics.pictureFrame.LineChart;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticQuestionJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Map<Integer, Question> questions;
	private Integer qid = -1;
	private GradeUtil gradeUtil;
	private Exam exam;
	private JComboBox<String> picBox;

	/**
	 * Create the panel.
	 */
	public StatisticQuestionJPanel(GradeUtil gradeUtil) {
		this.gradeUtil = gradeUtil;
		this.exam = gradeUtil.getExam();
		
		
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setPreferredSize(new Dimension(100, 100));// 关键代码,设置JPanel的大小

//		选择图表
		picBox = new JComboBox<String>();
		picBox.setModel(new DefaultComboBoxModel<String>(new String[] { "统计图" }));
		picBox.addItem("折线图");
		picBox.addItem("直方图");
		panel.add(picBox);

//		添加每道大题按钮
		questions = exam.getPaper().questionsToMap(exam.getPaper().getQuestions());

		Set<Integer> sets = questions.keySet();

		int i = 0;
		for (Integer integer : sets) {
			i++;
			JButton button_1 = new JButton("第" + questions.get(integer).getContent() + "题");
			button_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					qid = integer;
					List<Double> qgradeList = gradeUtil.getQgMap().get(qid);
					setData(qgradeList, 2, 40, false);
				}
			});
			panel.add(button_1);
		}


//		点击按钮显示总成绩统计结果
		JButton button_1 = new JButton("总  分");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qid = -1;
				setData(gradeUtil.getPgList(), 5d, 100, true);
			}
		});
		panel.add(button_1);

//		创建表格
//		JPanel panel_1 = new JPanel();
//		add(panel_1, BorderLayout.NORTH);
//		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
//		gl_panel_1
//				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 804, Short.MAX_VALUE));
//		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 43, Short.MAX_VALUE));
//		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table = new JTable() {
			private static final long serialVersionUID = 1L;
			// 表格不允许被编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
//		设置默认显示总成绩的统计结果
		setData(gradeUtil.getPgList(),5d,100,true);

		scrollPane.setViewportView(table);

		// 添加点击事件，进入添加成绩界面
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					int col = 0;
					col = table.columnAtPoint(e.getPoint());
					switch (col) {
					case 2:
						if (qid == -1) {
							switch (picBox.getSelectedIndex()) {
							case 1:
								new LineChart("频数", "人数", gradeUtil.getzStatisticsList());
								break;
							case 2:
								new BarChart("频数", "人数", gradeUtil.getzStatisticsList().get(0));
								break;
							default:
								new LineChart("频数", "人数", gradeUtil.getzStatisticsList());
								break;
							}
						} else {
							switch (picBox.getSelectedIndex()) {
							case 1:
//								qid为null则显示所有大题的图
								new LineChart("频数", "人数", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							case 2:
								new BarChart("频数", "人数", gradeUtil.getqStatisticsMap().get(qid).get(0));
								break;
							default:
								new LineChart("频数", "人数", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							}
						}
						break;
					case 3:
						if (qid == -1) {
							switch (picBox.getSelectedIndex()) {
							case 1:
								new LineChart("频度", "频度%", gradeUtil.getzStatisticsList());
								break;
							case 2:
								new BarChart("频度", "频度%", gradeUtil.getzStatisticsList().get(1));
								break;
							default:
								new LineChart("频度", "频度%", gradeUtil.getzStatisticsList());
								break;
							}
						} else {
							switch (picBox.getSelectedIndex()) {
							case 1:
								new LineChart("频度", "频度%", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							case 2:
								new BarChart("频度", "频度%", gradeUtil.getqStatisticsMap().get(qid).get(1));
								break;
							default:
								new LineChart("频度", "频度%", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							}
						}
						break;
					case 4:
						if (qid == -1) {
							switch (picBox.getSelectedIndex()) {
							case 1:
								new LineChart("累积频度", "累积频度%", gradeUtil.getzStatisticsList());
								break;
							case 2:
								new BarChart("累积频度", "累积频度%", gradeUtil.getzStatisticsList().get(2));
								break;
							default:
								new LineChart("累积频度", "累积频度%", gradeUtil.getzStatisticsList());
								break;
							}
						} else {
							switch (picBox.getSelectedIndex()) {
							case 1:
								new LineChart("累积频度", "累积频度%", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							case 2:
								new BarChart("累积频度", "累积频度%", gradeUtil.getqStatisticsMap().get(qid).get(2));
								break;
							default:
								new LineChart("累积频度", "累积频度%", gradeUtil.getqStatisticsMap(), questions, qid);
								break;
							}
						}
						break;
					}
				}
			}
		});

//		返回
		JButton button_4 = new JButton("返回");
		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(StatisticJPanel.getStatisticJPanel());
			}

		});
		panel.add(button_4);

	}

//	总览

//	表格填入值
	protected List<Double> setData(List<Double> qgradeList, double zuju, int s, boolean f) {

		Collections.sort(qgradeList);
		table.setModel(new DefaultTableModel(createData(qgradeList, zuju, s, f),
				new String[] { "分组中值点", "分数段", "频数", "频度", "积累频度" }));

		// 设置居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // set column align center
		renderer.setHorizontalAlignment(JTextField.CENTER);
		for (int i = 0; i < 5; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
		return qgradeList;
	}

//	qgradeList：传入的成绩，zuju：组距，s：成绩上限，f：判断是否传入总成绩
	private Object[][] createData(List<Double> qgradeList, double zuju, int s, boolean f) {
		Object[][] data = null;
		if(f){
			data = new Object[26][5];
			data[25][2] = "人数=" + qgradeList.size();
		}else{
			data = new Object[25][5];
		}

		Map<Double, Double> pinShuMap = null;
		Map<Double, Double> pinDuMap = null;
		Map<Double, Double> lPinDuMap = null;

		if (f) {
			pinShuMap = gradeUtil.getzStatisticsList().get(0);
			pinDuMap = gradeUtil.getzStatisticsList().get(1);
			lPinDuMap = gradeUtil.getzStatisticsList().get(2);

		} else {
			pinShuMap = gradeUtil.getqStatisticsMap().get(qid).get(0);
			pinDuMap = gradeUtil.getqStatisticsMap().get(qid).get(1);
			lPinDuMap = gradeUtil.getqStatisticsMap().get(qid).get(2);
		}

		double quanju = 0;
		double zushu = 0;

		quanju = qgradeList.get(qgradeList.size() - 1) - qgradeList.get(0);
		zushu = Math.ceil(quanju / zuju);

		data[22][2] = "全距=" + quanju;
		data[23][2] = "组距=" + zuju;
		data[24][2] = "组数=" + zushu;

		for (int i = 0; i < 21; i++) {
			Double data0 = i * zuju;
			String data1 = null;

			double bottom = 0;
			double top = 0;

			if (i == 0) {
				data1 = 0 + "";
			} else if (i == 1) {
				data1 = ">0" + "-" + (zuju + zuju / 2);
			} else {
				bottom = i * zuju - zuju / 2;
				if (i * zuju + 1 > s) {
					top = s;
				} else {
					top = i * zuju + zuju / 2;
				}
				data1 = bottom + "-" + top;
			}

			data[i][0] = data0.intValue();
			data[i][1] = data1;

			Double pinshu = pinShuMap.get(data0);
			Double pindu = pinDuMap.get(data0);
			Double lpindu = lPinDuMap.get(data0);

			if (pinshu != 0) {
				data[i][2] = pinshu.intValue();
			}

			if (pindu != 0) {
				data[i][3] = fM(pindu);
			}

			if (lpindu != 0) {
				data[i][4] = fM(lpindu);
			}

		}
		return data;
	}

	private String fM(Double d) {
		return String.format("%.2f", d);
	}

}

