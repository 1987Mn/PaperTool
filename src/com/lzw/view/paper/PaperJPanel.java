package com.lzw.view.paper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

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
import com.lzw.view.Main;

public class PaperJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PaperJPanel paperJPanel = new PaperJPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JScrollPane scrollPane;
	
	private PaperService paperService = (PaperServiceImp) SM.getBean(PaperServiceImp.class) ;
	private QuestionService questionService = (QuestionServiceImp)SM.getBean(QuestionServiceImp.class) ;

	/**
	 * Create the panel.
	 */
	public static PaperJPanel getPaperJPanel() {
		paperJPanel.setData(paperJPanel.getPaperService().queryList());
		return paperJPanel;
	}
	private PaperJPanel() {

		textField = new JTextField();
		textField.setColumns(10);
		textField.addFocusListener(new JTextFieldHintListener(textField, "请输入试卷"));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addFocusListener(new JTextFieldHintListener(textField_1, "请输入课程"));
		
		JButton queryJButton = new JButton("查询");
		queryJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Paper paper = new Paper();
				
				String shijuan = textField.getText().trim();
				String kecheng = textField_1.getText().trim();
				

				if (!"".equals(shijuan) && !"请输入试卷标题".equals(shijuan)) {
					paper.setTitle(shijuan);
				}
				
				if (!"".equals(kecheng) && !"请输入课程".equals(kecheng)) {
					paper.setCourse(kecheng);
				}
				
				paperJPanel.setData(paperJPanel.getPaperService().queryList(paper));
				Main.updateUI(paperJPanel);
				
			}
			
		});
		
		JButton addJButton = new JButton("添加试卷");
		addJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(new AddPaperJPanel());
			}
			
		});
		
		scrollPane = new JScrollPane();
		

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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					int row = table.rowAtPoint(e.getPoint());
					
					Integer id = (Integer) table.getValueAt(row, 5);
					
					Paper pa = paperService.query(id);
					
					Main.updateUI(new QuestionJPanel(pa));
					
				}
			}
		});
		

		
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] ids = table.getSelectedRows();
				for (int i = 0; i < ids.length; i++) {
					try {
						paperService.delete(Integer.valueOf(table.getValueAt(ids[i], 5).toString()));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "删除试卷：" + table.getValueAt(ids[i], 0).toString() + "失败",
								"错误！", JOptionPane.ERROR_MESSAGE);
					}
				}
				Main.updateUI(PaperJPanel.getPaperJPanel());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(queryJButton)
							.addGap(31)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addJButton)))
					.addGap(16))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(queryJButton)
						.addComponent(addJButton)
						.addComponent(button)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		setLayout(groupLayout);
		
	}
	
	private void setData(List<Paper> papers) {
		Object[][] data = new Object[papers.size()][6];
		for(int i = 0 ;i<data.length;i++){
			Paper paper = papers.get(i);
			data[i][0]=paper.getTitle();
			data[i][1]=paper.getCourse();
			data[i][2]=paper.getQuestionnum();
			data[i][3]=paper.getSmallquestionnum();
			data[i][4]=paper.getTotalpoints();
			data[i][5]=paper.getId();
		}

		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"试卷","课程", "大题数", "小题数","总分",""
			}
		));
		
		
		//隐藏某一列
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
		
		//添加点击事件，试题

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
	public PaperService getPaperService() {
		return paperService;
	}
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
}
