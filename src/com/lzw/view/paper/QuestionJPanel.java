package com.lzw.view.paper;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.lzw.domain.Paper;
import com.lzw.domain.Question;
import com.lzw.service.PaperService;
import com.lzw.service.QuestionService;
import com.lzw.service.imp.PaperServiceImp;
import com.lzw.service.imp.QuestionServiceImp;
import com.lzw.util.JTextFieldHintListener;
import com.lzw.util.SM;
import com.lzw.util.Tool;
import com.lzw.view.Main;

public class QuestionJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 452794330997907265L;
	private QuestionJPanel questionJPanel;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private Paper paper;
	
	private PaperService paperService = (PaperServiceImp) SM.getBean(PaperServiceImp.class) ;
	private QuestionService questionService = (QuestionServiceImp)SM.getBean(QuestionServiceImp.class) ;

	/**
	 * Create the panel.
	 */
	
	public QuestionJPanel(Paper paper) {
		this.paper = paper;
		this.questionJPanel = this;
		
//      查询
		textField = new JTextField();
		textField.setColumns(10);
		textField.addFocusListener(new JTextFieldHintListener(textField, "请输入题目"));
		
		JButton queryJButton = new JButton("查询");
		queryJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Question quetion01 = new Question();
				quetion01.setPaperid(paper.getId());
				String timu = textField.getText().trim();
				
				if (!"".equals(timu) && !"请输入题目".equals(timu)) {
					quetion01.setContent1(timu);
				}
				
				setData(questionService.list(quetion01),0);
				Main.updateUI(questionJPanel);
				
			}
			
		});
		
		
//		添加
		JButton addJButton = new JButton("添加");
		addJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("数量");  
				if(inputValue==null) {
					return;
				}
				int num =0;
				try {
					num = Integer.valueOf(inputValue.trim());
					Question quetion01 = new Question();
					quetion01.setPaperid(paper.getId());
					setData(questionService.list(quetion01),num);
					Main.updateUI(questionJPanel);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "请输入数字",
							"错误！", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		scrollPane = new JScrollPane();
		table = new JTable(); 
		
		Question q02 = new Question();
		q02.setPaperid(paper.getId());
		setData(questionService.list(q02), 0);
		
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] ids = table.getSelectedRows();
				for (int i = 0; i < ids.length; i++) {
					try {
						questionService.delete(Integer.valueOf(table.getValueAt(ids[i], 4).toString()));
						Question q02 = new Question();
						q02.setPaperid(paper.getId());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "删除试卷：" + table.getValueAt(ids[i], 0).toString() + "失败",
								"错误！", JOptionPane.ERROR_MESSAGE);
					}
				}
				setData(questionService.list(q02),0);
				Main.updateUI(questionJPanel);
			}
		});
		
		JButton button_1 = new JButton("保存");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				每道大题分值的和
				Double qScore = 0.0;
				for (int i = 0; i < table.getRowCount(); i++) {
					Integer id =(Integer)table.getValueAt(i, 4);
					
					Question q = new Question();
					q.setPaperid(paper.getId());
					int num = 0;

					if(!Tool.isEmpty(table.getValueAt(i, 0))){
						q.setContent(table.getValueAt(i, 0).toString());
						num++;
					}
					if(!Tool.isEmpty(table.getValueAt(i, 1))){
						q.setContent1(table.getValueAt(i, 1).toString());
						num++;
					}
					if(!Tool.isEmpty(table.getValueAt(i, 2))){
						q.setSmallquestionnum(Integer.valueOf(table.getValueAt(i, 2).toString()));
						num++;
					}
					if(!Tool.isEmpty(table.getValueAt(i, 3))){
						q.setScore((Double.valueOf(table.getValueAt(i, 3).toString())));
						num++;
					}
					
					if(id==null) {
						if(num==4) {
							questionService.insert(q);
						}else {
							JOptionPane.showMessageDialog(null, "第"+i+"行请输入完整信息",
								"错误！", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						q.setId(id);
						questionService.update(q);
					}
				}
				
				Paper pa01 = paperService.query(paper.getId());
				Question q01 = new Question();
				q01.setPaperid(paper.getId());
				pa01.setQuestionnum(questionService.list(q01).size());
				paperService.update(pa01);
			}
		});
		
		JButton button_2 = new JButton("小题");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(new SQuestionJPanel(paper));
			}
		});
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(PaperJPanel.getPaperJPanel());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(queryJButton)
							.addGap(31)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
							.addComponent(button_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addJButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(queryJButton)
						.addComponent(button_3)
						.addComponent(addJButton)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		setLayout(groupLayout);
		
	}
	
	private void setData(List<Question> question,int num) {
		Object[][] data = new Object[question.size()+num][5];
		for(int i = 0 ;i<data.length;i++){
			
			if(question.size()>i) {
				data[i][0]=question.get(i).getContent();
				data[i][1]=question.get(i).getContent1();
				data[i][2]=question.get(i).getSmallquestionnum();
				data[i][3]=question.get(i).getScore();
				data[i][4]=question.get(i).getId();
			}else {
				data[i][0]=i+1;
			}
			
		}

		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"题号","题目内容", "小题数量", "分值","id"
			}
		));
		
		
		//隐藏某一列
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
	public QuestionJPanel getQuestionJPanel() {
		return questionJPanel;
	}
	public void setQuestionJPanel(QuestionJPanel questionJPanel) {
		this.questionJPanel = questionJPanel;
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
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public PaperService getPaperService() {
		return paperService;
	}
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	
}
