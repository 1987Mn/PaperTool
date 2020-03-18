package com.lzw.view.exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lzw.domain.Clbum;
import com.lzw.domain.Exam;
import com.lzw.domain.Paper;
import com.lzw.service.ClbumsService;
import com.lzw.service.ExamsService;
import com.lzw.service.PaperService;
import com.lzw.service.imp.ClbumsServiceImp;
import com.lzw.service.imp.ExamsServiceImp;
import com.lzw.service.imp.PaperServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class AddExamsJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField riqiTF;
	private JTextField classrTF;
	private JComboBox<String> paperBox;
	private Map<Integer,Paper> paperBoxMap;
	private JComboBox<String> clbumBox;
	private Map<Integer,Clbum> clbumBoxMap;
	
	private  PaperService paperService = (PaperServiceImp)SM.getBean(PaperServiceImp.class) ;
	private  ClbumsService clbumsService = (ClbumsServiceImp)SM.getBean(ClbumsServiceImp.class) ;
	private  ExamsService examsService = (ExamsServiceImp)SM.getBean(ExamsServiceImp.class) ;
	

	/**
	 * Create the panel.
	 */
	public AddExamsJPanel() {
		
		JLabel nianjiLB = new JLabel("日期");
		
		JLabel clbumLB = new JLabel("教室");
		
		riqiTF = new JTextField();
		riqiTF.setColumns(10);
		
		classrTF = new JTextField();
		classrTF.setColumns(10);
		
		JLabel label = new JLabel("试卷");
		JLabel label_1 = new JLabel("班级");
		
		
		paperBox = new JComboBox<String>();
		paperBoxMap = new HashMap<>();
		paperBox.setModel(new DefaultComboBoxModel<String>(new String[] {"试卷"}));
		List<Paper> list =  paperService.queryList();
		int itemi = 1;
		for (Paper paper : list) {
			paperBoxMap.put(itemi, paper);
			itemi++;
			paperBox.addItem(paper.getTitle());
		}

		itemi=1;
		
		clbumBox = new JComboBox<String>();
		clbumBoxMap = new HashMap<>();
		clbumBox.setModel(new DefaultComboBoxModel<String>(new String[] {"班级"}));
		List<Clbum> clbumlist =  clbumsService.queryList();
		for (Clbum clbum : clbumlist) {
			clbumBoxMap.put(itemi, clbum);
			itemi++;
			clbumBox.addItem(clbum.getClbumname());
		}
		
		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Exam exam = new Exam();
				try {
					SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
					exam.setTestdate(f.parse(riqiTF.getText()));
					exam.setClbumroom(classrTF.getText());
					if(clbumBox.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "请选择班级", "警告", JOptionPane.ERROR_MESSAGE);						
						return ;
					}else {
						exam.setClbumid(clbumBoxMap.get(clbumBox.getSelectedIndex()).getId());
						exam.setPeoplenum(clbumBoxMap.get(clbumBox.getSelectedIndex()).getPeoplenum());
					}
					if(paperBox.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "请选择试卷", "警告", JOptionPane.ERROR_MESSAGE);						
						return ;
					}else {
						exam.setPaperid(paperBoxMap.get(paperBox.getSelectedIndex()).getId());
					}
					examsService.insert(exam);
					Main.updateUI(ExamsJPanel.getExamsJPanel());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "人数请输入数字", "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(ExamsJPanel.getExamsJPanel());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(284)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(nianjiLB)
								.addComponent(clbumLB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(paperBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(clbumBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(classrTF)
								.addComponent(riqiTF))))
					.addContainerGap(235, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nianjiLB)
						.addComponent(riqiTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(clbumLB)
						.addComponent(classrTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(paperBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(clbumBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
}
