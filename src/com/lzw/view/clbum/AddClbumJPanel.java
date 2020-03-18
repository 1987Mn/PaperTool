package com.lzw.view.clbum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lzw.domain.Clbum;
import com.lzw.service.ClbumsService;
import com.lzw.service.imp.ClbumsServiceImp;
import com.lzw.util.SM;
import com.lzw.view.Main;

public class AddClbumJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField majorTF;
	private JTextField nianjiTF;
	private JTextField clbumTF;
	private JTextField peopleTF;
	

	private  ClbumsService clbumsService = (ClbumsServiceImp)SM.getBean(ClbumsServiceImp.class) ;

	/**
	 * Create the panel.
	 */
	public AddClbumJPanel() {

		JLabel nianjiLB = new JLabel("年级");
		
		JLabel majorLB = new JLabel("专业");
		
		JLabel clbumLB = new JLabel("班级");
		
		JLabel peopelLB = new JLabel("人数");
		
		majorTF = new JTextField();
		majorTF.setColumns(10);
		
		nianjiTF = new JTextField();
		nianjiTF.setColumns(10);
		
		clbumTF = new JTextField();
		clbumTF.setColumns(10);
		
		peopleTF = new JTextField();
		peopleTF.setColumns(10);
		
		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pe = peopleTF.getText().trim();
				
				Clbum clbum = new Clbum();
				clbum.setClbumname(clbumTF.getText());
				clbum.setMajor(majorTF.getText());
				
				try {
					clbum.setNianji(nianjiTF.getText());
					clbum.setPeoplenum(Integer.valueOf(pe));
					clbumsService.insert(clbum);
					Main.updateUI(ClbumsJPanel.getClbumsJPanel());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "人数和年级请输入数字", "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.updateUI(ClbumsJPanel.getClbumsJPanel());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(majorLB)
								.addComponent(nianjiLB)
								.addComponent(clbumLB)
								.addComponent(peopelLB))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(peopleTF)
								.addComponent(clbumTF)
								.addComponent(majorTF)
								.addComponent(nianjiTF, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(284)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nianjiTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nianjiLB))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(majorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(majorLB))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(clbumTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(clbumLB))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(peopleTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(peopelLB))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
