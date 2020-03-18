package com.lzw.view.paper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lzw.domain.Paper;
import com.lzw.service.PaperService;
import com.lzw.service.imp.PaperServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class AddPaperJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField courseTF;
	private JTextField titleTF;
	private JTextField collegeTF;

	private PaperService paperService = (PaperServiceImp) SM.getBean(PaperServiceImp.class) ;
	/**
	 * Create the panel.
	 */
	public AddPaperJPanel() {

		JLabel titleLB = new JLabel("试卷标题");
		
		JLabel courseLB = new JLabel("课程");
		
		courseTF = new JTextField();
		courseTF.setColumns(10);
		
		titleTF = new JTextField();
		titleTF.setColumns(10);
		
		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Paper paper = new Paper();
				
				paper.setCollege(collegeTF.getText());
				paper.setTitle(titleTF.getText());
				paper.setCourse(courseTF.getText());
				
				paperService.insert(paper);
				Main.updateUI(PaperJPanel.getPaperJPanel());
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(PaperJPanel.getPaperJPanel());
			}
		});
		
		collegeTF = new JTextField();
		collegeTF.setColumns(10);
		
		JLabel collegeBT = new JLabel("学院");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(159)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(courseLB)
								.addComponent(collegeBT)
								.addComponent(titleLB))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(titleTF, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
								.addComponent(courseTF, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
								.addComponent(collegeTF, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(284)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addGap(210))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(188)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLB)
						.addComponent(titleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(courseTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseLB))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(collegeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(collegeBT))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
