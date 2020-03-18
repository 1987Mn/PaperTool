package com.lzw.view;

import com.lzw.view.clbum.ClbumsJPanel;
import com.lzw.view.exam.ExamsJPanel;
import com.lzw.view.paper.PaperJPanel;
import com.lzw.view.statistics.StatisticJPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    /**
     *
     */
    public static Main MainFrame = new Main();
    private static final long serialVersionUID = 1L;
    private JPanel MJP;
    private JMenuItem clbumMenuItem;
    private JMenuItem examMenuItem;
    private JMenuItem paperMenuItem;
    private JMenuItem statisticsMenuItem;
    private JMenuItem setMenuItem;

    //
    private ClbumsJPanel clbumsJPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ApplicationContext APPLICATION_CONTEXT3 = new ClassPathXmlApplicationContext(
                            new String[]{"applicationContext-dao.xml", "applicationContext-service.xml", "mybatis-config.xml"});
                    Main frame = getMainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public static Main getMainFrame() {
        return MainFrame;
    }

    private Main() {
        //窗体设置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 700);

        // 设置窗体居中
        this.setLocationRelativeTo(null);


        //画板设置
        MJP = new JPanel();
        MJP.setBorder(new EmptyBorder(5, 5, 5, 5));
        MJP.setLayout(new BorderLayout(0, 0));
        setContentPane(MJP);


        //导航
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        MJP.add(panel, BorderLayout.NORTH);

        //班级
        clbumMenuItem = new JMenuItem("班级管理");
        clbumMenuItem.addActionListener(this);
        panel.add(clbumMenuItem);
        //班级

        //试卷
        paperMenuItem = new JMenuItem("试卷管理");
        paperMenuItem.addActionListener(this);
        panel.add(paperMenuItem);
        //试卷

        //考试
        examMenuItem = new JMenuItem("考试管理");
        examMenuItem.addActionListener(this);
        panel.add(examMenuItem);
        //考试

        //统计
        statisticsMenuItem = new JMenuItem("统计管理");
        statisticsMenuItem.addActionListener(this);
        panel.add(statisticsMenuItem);
        //统计

        //设置
        setMenuItem = new JMenuItem("设置");
        setMenuItem.addActionListener(this);
        panel.add(setMenuItem);
        //设置

        //导航

        clbumsJPanel = ClbumsJPanel.getClbumsJPanel();
        MJP.add(clbumsJPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem ji = (JMenuItem) e.getSource();
        //班级管理
        if (ji == clbumMenuItem) {
//			JPanel jp = new JPanel();
//			jp.setLayout(new BorderLayout());
//			jp.add(new TestMain().createTable(),BorderLayout.CENTER);
//			MJP.add(jp);
//			SwingUtilities.updateComponentTreeUI(Main.getMainFrame());
            Main.updateUI(ClbumsJPanel.getClbumsJPanel());

            //考试管理
        } else if (ji == examMenuItem) {
            updateUI(ExamsJPanel.getExamsJPanel());

            //试卷管理
        } else if (ji == paperMenuItem) {
            updateUI(PaperJPanel.getPaperJPanel());

            //统计管理
        } else if (ji == statisticsMenuItem) {
            updateUI(StatisticJPanel.getStatisticJPanel());

            //设置
        } else if (ji == setMenuItem) {
            System.out.println("5");

        }
    }

    public static void updateUI(Component comp) {
        Main.getMainFrame().getMJP().remove(1);
        Main.getMainFrame().getMJP().add(comp);
        SwingUtilities.updateComponentTreeUI(Main.getMainFrame());
    }

    public static void updateUIa(JPanel comp) {
        Main.getMainFrame().getMJP().remove(1);
        Main.getMainFrame().getMJP().add(comp);
        SwingUtilities.updateComponentTreeUI(Main.getMainFrame());
    }

    public JPanel getMJP() {
        return MJP;
    }

    public void setMJP(JPanel mJP) {
        MJP = mJP;
    }

    public JMenuItem getClbumMenuItem() {
        return clbumMenuItem;
    }

    public void setClbumMenuItem(JMenuItem clbumMenuItem) {
        this.clbumMenuItem = clbumMenuItem;
    }

    public JMenuItem getExamMenuItem() {
        return examMenuItem;
    }

    public void setExamMenuItem(JMenuItem examMenuItem) {
        this.examMenuItem = examMenuItem;
    }

    public JMenuItem getPaperMenuItem() {
        return paperMenuItem;
    }

    public void setPaperMenuItem(JMenuItem paperMenuItem) {
        this.paperMenuItem = paperMenuItem;
    }

    public JMenuItem getStatisticsMenuItem() {
        return statisticsMenuItem;
    }

    public void setStatisticsMenuItem(JMenuItem statisticsMenuItem) {
        this.statisticsMenuItem = statisticsMenuItem;
    }

    public JMenuItem getSetMenuItem() {
        return setMenuItem;
    }

    public void setSetMenuItem(JMenuItem setMenuItem) {
        this.setMenuItem = setMenuItem;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public static void setMainFrame(Main mainFrame) {
        MainFrame = mainFrame;
    }

}
