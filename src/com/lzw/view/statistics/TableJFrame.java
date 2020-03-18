package com.lzw.view.statistics;

import com.lzw.domain.*;
import com.lzw.util.GradeUtil;
import com.lzw.util.Tool;
import com.lzw.util.table.DTable;
import com.lzw.util.table.GroupHeader;
import com.lzw.util.table.TableContent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;
import java.util.*;


public class TableJFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public TableJFrame(GradeUtil gradeUtil, String title) {

//		设置JFrame
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle(title);
        this.setLocationRelativeTo(null);

//		获取table
        JTable table = null;
        if ("标准化成绩".equals(title)) {
            table = createBTable(gradeUtil);
        } else {
            table = createYTable(gradeUtil);
        }
        // 设置table内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);

        JScrollPane jsp = new JScrollPane(table);
        FitTableColumns(table);

//		将JScrollPane放入窗体
        add(jsp);
    }

    //		原始成绩
    public JTable createYTable(GradeUtil gradeUtil) {
        TableContent tableContent = new TableContent();
        Exam exam = gradeUtil.getExam();

//		学生成绩
        Map<String, Map<Integer, Map<Integer, Grade>>> studentGrade = gradeUtil.getStudentGrade();

//		获取大题
        List<Question> questions = exam.getPaper().getQuestions();

//		获取得分点数		
        int scnum = 0;
        for (Question q03 : questions) {
            for (Smallquestion sq01 : q03.getSmallqs()) {
                scnum += sq01.getScorepointnum();
            }
        }

//		表头
        Object[] dataH = new Object[scnum + 5 + questions.size()];
        List<GroupHeader> list = new ArrayList<GroupHeader>();

//		绘制表头
        dataH[0] = "名次";
        dataH[1] = "班级";
        dataH[2] = "学号";
        dataH[3] = "姓名";
        dataH[4] = "原始总分";

        int start = 5 + questions.size();
        int end = start - 1;
        int qnum = 5;
        for (Question q03 : questions) {
            dataH[qnum] = new String("N" + q03.getContent() + "总分");
            qnum++;
//			大题标题

            GroupHeader qgh = new GroupHeader(q03.getContent1() + "(" + q03.getContent() + ")");

            for (Smallquestion sq02 : q03.getSmallqs()) {
//			小题标题
                end = end + sq02.getScorepointnum();
                GroupHeader sqgh = new GroupHeader(
                        q03.getContent() + "." + sq02.getContent() + "(" + sq02.getScore() + ")分", start,
                        end);
                for (int j = start; j <= end; j++) {
                    dataH[j] = q03.getContent() + "." + sq02.getContent() + "." + (j - start + 1);
                }
                start = end + 1;
                qgh.addSubHeader(sqgh);
            }
            list.add(qgh);
        }


//		设置成绩

//      计算算排名
        Map<String, Integer> stuPaimin = gradeUtil.paimin();
        List<Student> stuList = exam.getStudentList();
//		学生大题成绩序号
        int stunum = 0;
        for (Student stu01 : stuList) {
            tableContent.append(stuPaimin.get(stu01.getSid()));
            tableContent.append(exam.getClbum().getClbumname());
            tableContent.append(stu01.getSid());
            tableContent.append(stu01.getName());
            tableContent.append(gradeUtil.getPgMap().get(stu01.getSid()));

//			获取大题成绩
            Map<Integer, Map<Integer, Grade>> qMap = studentGrade.get(stu01.getSid());
            Set<Integer> qids = qMap.keySet();
//			每个学生的大题成绩	
            for (Integer qid : qids) {
                List<Double> list01 = gradeUtil.getQgMap().get(qid);
                tableContent.append(list01.get(stunum));
            }
//			每道大题对应小题成绩
            qids = qMap.keySet();
            for (Integer qid : qids) {
                Map<Integer, Grade> sqMap = qMap.get(qid);
                Set<Integer> sqids = sqMap.keySet();

                for (Integer sqid : sqids) {
                    Grade grade = sqMap.get(sqid);

                    if (grade.getScorepoint1() != null) {
                        tableContent.append(grade.getScorepoint1());
                    }
                    if (grade.getScorepoint2() != null) {
                        tableContent.append(grade.getScorepoint2());
                    }
                    if (grade.getScorepoint3() != null) {
                        tableContent.append(grade.getScorepoint3());
                    }
                    if (grade.getScorepoint4() != null) {
                        tableContent.append(grade.getScorepoint4());
                    }
                    if (grade.getScorepoint5() != null) {
                        tableContent.append(grade.getScorepoint5());
                    }

                }

            }
            stunum++;
            tableContent.println();

        }

        JTable table = DTable.create(
                tableContent, // 数据
                dataH, // 表头
                list // 表头
        );
        return table;

    }


    //	标准化成绩
    public JTable createBTable(GradeUtil gradeUtil) {
        TableContent tableContent = new TableContent();
        Exam exam = gradeUtil.getExam();

//		学生成绩
        Map<String, Map<Integer, Map<Integer, Grade>>> studentGrade = gradeUtil.getStudentGrade();

//		获取大题
        List<Question> questions = exam.getPaper().getQuestions();

//		获取得分点数		
        int scnum = 0;
        for (Question q03 : questions) {
            for (Smallquestion sq01 : q03.getSmallqs()) {
                scnum += sq01.getScorepointnum();
            }
        }

//		表头
        Object[] dataH = new Object[scnum + 6 + questions.size()];
        List<GroupHeader> list = new ArrayList<GroupHeader>();

//		绘制表头
        dataH[0] = new String("名次");
        dataH[1] = new String("班级");
        dataH[2] = new String("学号");
        dataH[3] = new String("姓名");
        dataH[4] = new String("原始总分");
        dataH[5] = new String("总z分");

        int start = 6 + questions.size();
        int end = start - 1;
        int qnum = 6;
        for (Question q03 : questions) {
            dataH[qnum] = new String("N" + q03.getContent() + "总分");
            qnum++;
//			大题标题
            GroupHeader qgh = new GroupHeader(q03.getContent1() + "(" + q03.getContent() + ")");

            for (Smallquestion sq02 : q03.getSmallqs()) {
//			小题标题
                end = end + sq02.getScorepointnum();
                GroupHeader sqgh = new GroupHeader(
                        q03.getContent() + "." + sq02.getContent() + "(" + sq02.getScore() + ")分", start,
                        end);
                for (int j = start; j <= end; j++) {
                    dataH[j] = q03.getContent() + "." + sq02.getContent() + "." + (j - start + 1);
                }
                start = end + 1;
                qgh.addSubHeader(sqgh);
            }
            list.add(qgh);
        }


//		设置成绩
        List<Student> stuList = exam.getStudentList();
//		学生大题成绩序号
        int stunum = 0;
        for (Student stu01 : stuList) {
//            List<Double> tableContentList = new ArrayList<>();
            tableContent.append(1);
            tableContent.append(exam.getClbum().getClbumname());
            tableContent.append(stu01.getSid());
            tableContent.append(stu01.getName());
            tableContent.append(gradeUtil.getPgMap().get(stu01.getSid()));
            tableContent.append(gradeUtil.getPgMap().get(stu01.getSid()));

//			获取大题成绩
            Map<Integer, Map<Integer, Grade>> qMap = studentGrade.get(stu01.getSid());
            Set<Integer> qids = qMap.keySet();
//			每个学生的大题成绩	
            for (Integer qid : qids) {
                List<Double> list01 = gradeUtil.getQgMap().get(qid);
                Double d = list01.get(stunum);
                tableContent.append(d);
            }
//			每道大题对应小题成绩
            qids = qMap.keySet();
            for (Integer qid : qids) {
                Map<Integer, Grade> sqMap = qMap.get(qid);
                Set<Integer> sqids = sqMap.keySet();

                for (Integer sqid : sqids) {
                    Grade grade = sqMap.get(sqid);

                    if (grade.getScorepoint1() != null) {

                        Double d02 = gradeUtil.getPointBMap().get(qid + "." + sqid + "." + 1);
                        if (d02 > 0.0) {
                            Double d01 = gradeUtil.getPointAVGList().get(qid + "." + sqid + "." + 1);
                            tableContent.append(Tool.fM((grade.getScorepoint1() - d01)/d02));
                        } else {
                            tableContent.append(0.0);
                        }

                    }
                    if (grade.getScorepoint2() != null) {
                        Double d02 = gradeUtil.getPointBMap().get(qid + "." + sqid + "." + 2);
                        if (d02 > 0.0) {
                            Double d01 = gradeUtil.getPointAVGList().get(qid + "." + sqid + "." + 2);
                            tableContent.append(Tool.fM((grade.getScorepoint2()-d01)/d02));
                        } else {
                            tableContent.append(0.0);
                        }
                    }
                    if (grade.getScorepoint3() != null) {
                        Double d02 = gradeUtil.getPointBMap().get(qid + "." + sqid + "." + 3);
                        if (d02 > 0.0) {
                            Double d01 = gradeUtil.getPointAVGList().get(qid + "." + sqid + "." + 3);
                            tableContent.append(Tool.fM((grade.getScorepoint3()-d01)/d02));
                        } else {
                            tableContent.append(0.0);
                        }
                    }
                    if (grade.getScorepoint4() != null) {
                        Double d02 = gradeUtil.getPointBMap().get(qid + "." + sqid + "." + 4);
                        if (d02 > 0.0) {
                            Double d01 = gradeUtil.getPointAVGList().get(qid + "." + sqid + "." + 4);
                            tableContent.append(Tool.fM((grade.getScorepoint4()-d01)/d02));
                        } else {
                            tableContent.append(0.0);
                        }
                    }
                    if (grade.getScorepoint5() != null) {
                        Double d02 = gradeUtil.getPointBMap().get(qid + "." + sqid + "." + 5);
                        if (d02 > 0.0) {
                            Double d01 = gradeUtil.getPointAVGList().get(qid + "." + sqid + "." + 5);
                            tableContent.append(Tool.fM((grade.getScorepoint5()-d01)/d02));
                        } else {
                            tableContent.append(0.0);
                        }
                    }

                }

            }
            stunum++;
            tableContent.println();

        }

        JTable table = DTable.create(
                tableContent, // 数据
                dataH, // 表头
                list // 表头
        );
        return table;

    }


    public void FitTableColumns(JTable myTable) {
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        Enumeration<?> columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(
                    column.getIdentifier());
            int width = (int) myTable
                    .getTableHeader()
                    .getDefaultRenderer()
                    .getTableCellRendererComponent(myTable,
                            column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) myTable
                        .getCellRenderer(row, col)
                        .getTableCellRendererComponent(myTable,
                                myTable.getValueAt(row, col), false, false,
                                row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // 此行很重要
            column.setWidth(width + myTable.getIntercellSpacing().width + 10);
        }
    }

}


/**
 * ���������ڡ�Java���ļ�����
 *
 * @author Administrator
 */
class GBC extends GridBagConstraints {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a GBC with a given gridx and gridy position and all other grid bag
     * constraint values set to the default.
     *
     * @param gridx the gridx position
     * @param gridy the gridy position
     */
    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * Constructs a GBC with given gridx, gridy, gridwidth, gridheight and all other
     * grid bag constraint values set to the default.
     *
     * @param gridx      the gridx position
     * @param gridy      the gridy position
     * @param gridwidth  the cell span in x-direction
     * @param gridheight the cell span in y-direction
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    /**
     * Sets the anchor.
     *
     * @param anchor the anchor value
     * @return this object for further modification
     */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Sets the fill direction.
     *
     * @param fill the fill direction
     * @return this object for further modification
     */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Sets the cell weights.
     *
     * @param weightx the cell weight in x-direction
     * @param weighty the cell weight in y-direction
     * @return this object for further modification
     */
    public GBC setWeight(double weightx, double weighty) {
        // super.w
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * Sets the insets of this cell.
     *
     * @param distance the spacing to use in all directions
     * @return this object for further modification
     */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * Sets the insets of this cell.
     *
     * @param top    the spacing to use on top
     * @param left   the spacing to use to the left
     * @param bottom the spacing to use on the bottom
     * @param right  the spacing to use to the right
     * @return this object for further modification
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Sets the internal padding
     *
     * @param ipadx the internal padding in x-direction
     * @param ipady the internal padding in y-direction
     * @return this object for further modification
     */
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
