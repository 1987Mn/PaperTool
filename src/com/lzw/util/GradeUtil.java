package com.lzw.util;

import com.lzw.domain.*;

import java.util.*;

/**
 * 计算成绩大题总分和试卷总分的频度、频数、累积频度；
 * 学生总分：List，Map
 * 学生成绩：studentGrade，根据学号，大题id，小题id获取成绩
 * 大题总分：List，Map
 * 小题成绩：Map
 *
 * 标准化：
 *
 */
public class GradeUtil {
    private Exam exam;

// 原始数据
    //	每到大题的成绩
    private Map<Integer, List<Double>> qgMap;
    //	每到小题的成绩
    private Map<Integer, List<Double>> sqgMap;
    //	每个学生各题的成绩
    private Map<String, Map<Integer, Map<Integer, Grade>>> studentGrade;
    //	每个学生的总分
    private Map<String, Double> pgMap;
    //	学生总分集合
    private List<Double> pgList;
    //	每道题的统计结果，添加顺序为频数、频度、累积频度，Map<Double, Double>key是分数段中值点
    private Map<Integer, List<Map<Double, Double>>> qStatisticsMap;
    //	总分统计：总分的频数、频度、累积频度，Map<Double, Double>key是分数段中值点
    private List<Map<Double, Double>> zStatisticsList;

//  标准化
    //	标准化每到大题的成绩
    private Map<Integer, List<Double>> qgBMap;
    //	标准化学生总分集合
    private List<Double> pgBList;
    //	标准化每道题的统计结果，添加顺序为频数、频度、累积频度，Map<Double, Double>key是分数段中值点
    private Map<Integer, List<Map<Double, Double>>> qStatisticsBMap;
    //	标准化总分统计：总分的频数、频度、累积频度，Map<Double, Double>key是分数段中值点
    private List<Map<Double, Double>> zStatisticsBList;

//    得分点
    //    每个得分点的标准差，key为大题id.小题id+得分点序号
    private Map<String, Double> pointBMap;
    // 每个得分点的平均值
    private Map<String, Double> pointAVGList;

    public GradeUtil() {
    }

    public GradeUtil(Exam exam) {
        this.exam = exam;
        Student stu = new Student();
        stu.setClbumid(exam.getClbumid());
        List<Student> stuList = exam.getStudentList();

        List<Question> qlist = exam.getPaper().getQuestions();

//		每道小题的成绩
        sqgMap = new LinkedHashMap<>();

//		每道大题的成绩
        qgMap = new LinkedHashMap<>();

//		取出每个学生的成绩
        studentGrade = new LinkedHashMap<>();

//		每个学生试卷总分,根据学生id获取值
        pgMap = new LinkedHashMap<>();

//		每个学生试卷总分
        pgList = new ArrayList<>();


//		每个学生的成绩
        for (Student stu01 : stuList) {
            Double total = 0.0;
            Map<Integer, Map<Integer, Grade>> qMap = new LinkedHashMap<>();
            for (Question question2 : qlist) {
                Map<Integer, Grade> sqMap = new LinkedHashMap<>();
                for (Smallquestion sq01 : question2.getSmallqs()) {
                    Grade gra01 = sq01.getGradeMap().get(stu01.getSid());
                    sqMap.put(sq01.getId(), gra01);
                    total += gra01.getTotalpoint();
                }
                qMap.put(question2.getId(), sqMap);
            }
            pgList.add(total);
            pgMap.put(stu01.getSid(), total);
            studentGrade.put(stu01.getSid(), qMap);
        }
//		每道小题成绩
        for (Question question2 : qlist) {
            for (Smallquestion sq01 : question2.getSmallqs()) {
                List<Double> glist = new ArrayList<>();
                for (Grade grade : sq01.getGrades()) {
                    glist.add(grade.getTotalpoint());
                }
                sqgMap.put(sq01.getId(), glist);
            }
        }

//		每道大题总分
        for (Question question2 : qlist) {
            List<Double> list01 = new ArrayList<>();
            for (Student stu02 : stuList) {
                Double total = 0.0;
                for (Smallquestion sq01 : question2.getSmallqs()) {
                    Grade gra01 = sq01.getGradeMap().get(stu02.getSid());
                    total += gra01.getTotalpoint();
                }
                list01.add(total);
            }
            qgMap.put(question2.getId(), list01);
        }
        Set<Integer> set = qgMap.keySet();
        qStatisticsMap = new LinkedHashMap<>();
        for (Integer id : set) {
            setPin(qgMap.get(id), 2, 40, id);
        }
        setPin(pgList, 5, 100, -1);

//        计算标准化
        stdevAndAvg();

//      计算标准化频数、频度、累积频度
        Set<Integer> bset = qgBMap.keySet();
        qStatisticsBMap = new LinkedHashMap<>();
        for (Integer id : set) {
            setBPin(qgBMap.get(id), 5, 50, id);
        }
        setBPin(pgBList, 10, 100, -1);
    }

    //	标准化计算频度、频数、累积频度
    private void setBPin(List<Double> qgradeList, double zuju, int s, int id) {

//		频数
        Map<Double, Double> pinShuMap = new LinkedHashMap<Double, Double>();
//		频率
        Map<Double, Double> pinDuMap = new LinkedHashMap<Double, Double>();
//		累积频率
        Map<Double, Double> lPinDuMap = new LinkedHashMap<Double, Double>();

        double leiji = 0;
        double tem = 0;

        for (int i = 0; i < 21; i++) {
            Double data0 = s - i * zuju;

            double bottom = 0;
            double top = 0;
            Double num = 0d;

            if (i == 0) {
                top = s;
                bottom = s - zuju / 2;
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 <= top && double1 > bottom) {
                        num++;
                    }
                }
            } else if (i == 20) {
                bottom = s-i * zuju;
                top = s-i * zuju + zuju / 2;
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 <= top && double1 > bottom) {
                        num++;
                    }
                }
            } else {
                bottom = s-i * zuju - zuju / 2;
                top = s-i * zuju + zuju / 2;
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 <= top && double1 > bottom) {
                        num++;
                    }
                }
            }

            pinShuMap.put(data0, num);

            tem = num / qgradeList.size();
            pinDuMap.put(data0, tem);

            leiji = leiji + tem;
            lPinDuMap.put(data0, leiji);

        }

        if (id == -1) {
            zStatisticsBList = new ArrayList<>();
            zStatisticsBList.add(pinShuMap);
            zStatisticsBList.add(pinDuMap);
            zStatisticsBList.add(lPinDuMap);
        } else {
//			每道题的頻數、頻度、累積頻度
            List<Map<Double, Double>> qStatisticsList = new ArrayList<>();
            qStatisticsList.add(pinShuMap);
            qStatisticsList.add(pinDuMap);
            qStatisticsList.add(lPinDuMap);
            qStatisticsBMap.put(id, qStatisticsList);
        }

    }



    //	计算频度、频数、累积频度
    private void setPin(List<Double> qgradeList, double zuju, int s, int id) {


//		频数
        Map<Double, Double> pinShuMap = new LinkedHashMap<Double, Double>();
//		频率
        Map<Double, Double> pinDuMap = new LinkedHashMap<Double, Double>();
//		累积频率
        Map<Double, Double> lPinDuMap = new LinkedHashMap<Double, Double>();

        double leiji = 0;
        double tem = 0;

        for (int i = 0; i < 21; i++) {
            Double data0 = i * zuju;

            double bottom = 0;
            double top = 0;
            Double num = 0d;

            if (i == 0) {
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 == 0) {
                        num++;
                    }
                }
            } else if (i == 1) {
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 <= (i * zuju + zuju / 2) && double1 > 0) {
                        num++;
                    }
                }
            } else {
                bottom = i * zuju - zuju / 2;
                if (i * zuju + 1 > s) {
                    top = s;
                } else {
                    top = i * zuju + zuju / 2;
                }
                num = 0d;
                for (Double double1 : qgradeList) {
                    if (double1 <= top && double1 > bottom) {
                        num++;
                    }
                }
            }

            pinShuMap.put(data0, num);

            tem = num / qgradeList.size();
            pinDuMap.put(data0, tem);

            leiji = leiji + tem;
            lPinDuMap.put(data0, leiji);

        }

        if (id == -1) {
            zStatisticsList = new ArrayList<>();
            zStatisticsList.add(pinShuMap);
            zStatisticsList.add(pinDuMap);
            zStatisticsList.add(lPinDuMap);
        } else {
//			每道题的頻數、頻度、累積頻度
            List<Map<Double, Double>> qStatisticsList = new ArrayList<>();
            qStatisticsList.add(pinShuMap);
            qStatisticsList.add(pinDuMap);
            qStatisticsList.add(lPinDuMap);
            qStatisticsMap.put(id, qStatisticsList);
        }

    }

    //	计算名次
    public Map<String, Integer> paimin() {
        Set<Map.Entry<String, Double>> entries = pgMap.entrySet();
        List<Map.Entry<String, Double>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getKey(), i + 1);
        }
        return map;
    }

    //	标准化计算
    public void stdevAndAvg() {
        List<Student> stuList = exam.getStudentList();
//       大题Map
        Map<Integer, Question> questionMap = exam.getPaper().questionsToMap(exam.getPaper().getQuestions());

//        每个得分点的总分
        Map<String, List<Double>> map01 = new LinkedHashMap<>();

//      每道大题的总分
        Map<Integer, List<Double>> qMap01 = new LinkedHashMap<>();
//        每个学生的总成绩
        List<Double> stuList01 = new ArrayList<>();

        for (Student stu01 : stuList) {
//            每个学生的总成绩
            Double stuBT = 0.0;

//			获取大题成绩
            Map<Integer, Map<Integer, Grade>> qMap = studentGrade.get(stu01.getSid());

//			每道大题对应小题成绩
            Set<Integer> qids = qMap.keySet();
            for (Integer qid : qids) {
//                每道大题总z分
                List<Double> list1 = qMap01.get(qid);
                if (list1 == null) {
                    list1 = new ArrayList<>();
                    qMap01.put(qid, list1);
                }
                //每个学生每道大题的总分
                Double total01 = 0.0;
                //  每道小题的成绩
                Map<Integer, Grade> sqMap = qMap.get(qid);
                Set<Integer> sqids = sqMap.keySet();
                for (Integer sqid : sqids) {
                    Grade grade = sqMap.get(sqid);
                    if (grade.getScorepoint1() != null) {
                        total01 += grade.getScorepoint1();
                        List<Double> d01 = map01.get(qid + "." + sqid + "." + 1);
                        if (d01 != null) {
                            d01.add(grade.getScorepoint1());
                        } else {
                            List<Double> list01 = new ArrayList<Double>();
                            list01.add(grade.getScorepoint1());
                            map01.put(qid + "." + sqid + "." + 1, list01);
                        }
                    }
                    if (grade.getScorepoint2() != null) {
                        total01 += grade.getScorepoint2();
                        List<Double> d01 = map01.get(qid + "." + sqid + "." + 2);
                        if (d01 != null) {
                            d01.add(grade.getScorepoint2());
                        } else {
                            List<Double> list01 = new ArrayList<Double>();
                            list01.add(grade.getScorepoint2());
                            map01.put(qid + "." + sqid + "." + 2, list01);
                        }
                    }
                    if (grade.getScorepoint3() != null) {
                        total01 += grade.getScorepoint3();
                        List<Double> d01 = map01.get(qid + "." + sqid + "." + 3);
                        if (d01 != null) {
                            d01.add(grade.getScorepoint3());
                        } else {
                            List<Double> list01 = new ArrayList<Double>();
                            list01.add(grade.getScorepoint3());
                            map01.put(qid + "." + sqid + "." + 3, list01);
                        }
                    }
                    if (grade.getScorepoint4() != null) {
                        total01 += grade.getScorepoint4();
                        List<Double> d01 = map01.get(qid + "." + sqid + "." + 4);
                        if (d01 != null) {
                            d01.add(grade.getScorepoint4());
                        } else {
                            List<Double> list01 = new ArrayList<Double>();
                            list01.add(grade.getScorepoint4());
                            map01.put(qid + "." + sqid + "." + 4, list01);
                        }
                    }
                    if (grade.getScorepoint5() != null) {
                        total01 += grade.getScorepoint5();
                        List<Double> d01 = map01.get(qid + "." + sqid + "." + 5);
                        if (d01 != null) {
                            d01.add(grade.getScorepoint5());
                        } else {
                            List<Double> list01 = new ArrayList<Double>();
                            list01.add(grade.getScorepoint5());
                            map01.put(qid + "." + sqid + "." + 5, list01);
                        }
                    }
                }
                stuBT += total01;
                qMap01.get(qid).add(total01);
            }
            stuList01.add(stuBT);

        }


//      每个得分点的平均值
        Map<String, Double> map03 = new LinkedHashMap<>();

//      每个得分点标准差
        Map<String, Double> map02 = new LinkedHashMap<>();

//        计算标准差和平均值
        Set<String> keySet = map01.keySet();
        for (String s01 : keySet) {
            List<Double> list03 = map01.get(s01);
            map03.put(s01, avg(list03));
            map02.put(s01, stdev(list03));
        }
        this.pointBMap = map02;
        this.pointAVGList = map03;

//      大题标准化成绩
        this.qgBMap = qMap01;
        this.pgBList = stuList01;

    }

    //    平均数
    public static double avg(List<Double> list) {
        Double dt = 0.0;
        for (Double d : list) {
            dt += d;
        }
        return list.size() == 0 ? 0 : dt / list.size();
    }

    //    标准差
    public static double stdev(List<Double> list) {
        int m = list.size();
        double sum = 0;
        //求和
        for (int i = 0; i < m; i++) {
            sum += list.get(i);
        }
        //求平均值
        double dAve = sum / m;
        double dVar = 0;
        //求方差
        for (int i = 0; i < m; i++) {
            dVar += (list.get(i) - dAve) * (list.get(i) - dAve);
        }
        //reture Math.sqrt(dVar/(m-1));
        return Math.sqrt(dVar / m);
    }


    public List<Map<Double, Double>> getzStatisticsList() {
        return zStatisticsList;
    }

    public void setzStatisticsList(List<Map<Double, Double>> zStatisticsList) {
        this.zStatisticsList = zStatisticsList;
    }

    public Map<Integer, List<Map<Double, Double>>> getqStatisticsMap() {
        return qStatisticsMap;
    }

    public void setqStatisticsMap(Map<Integer, List<Map<Double, Double>>> qStatisticsMap) {
        this.qStatisticsMap = qStatisticsMap;
    }

    public Map<Integer, List<Double>> getQgMap() {
        return qgMap;
    }

    public void setQgMap(Map<Integer, List<Double>> qgMap) {
        this.qgMap = qgMap;
    }

    public Map<Integer, List<Double>> getSqgMap() {
        return sqgMap;
    }

    public void setSqgMap(Map<Integer, List<Double>> sqgMap) {
        this.sqgMap = sqgMap;
    }

    public Map<String, Double> getPgMap() {
        return pgMap;
    }

    public void setPgMap(Map<String, Double> pgMap) {
        this.pgMap = pgMap;
    }

    public List<Double> getPgList() {
        return pgList;
    }

    public void setPgList(List<Double> pgList) {
        this.pgList = pgList;
    }

    public Map<String, Map<Integer, Map<Integer, Grade>>> getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Map<String, Map<Integer, Map<Integer, Grade>>> studentGrade) {
        this.studentGrade = studentGrade;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Map<String, Double> getPointBMap() {
        return pointBMap;
    }

    public void setPointBMap(Map<String, Double> pointBMap) {
        this.pointBMap = pointBMap;
    }

    public Map<String, Double> getPointAVGList() {
        return pointAVGList;
    }

    public void setPointAVGList(Map<String, Double> pointAVGList) {
        this.pointAVGList = pointAVGList;
    }

    public Map<Integer, List<Double>> getQgBMap() {
        return qgBMap;
    }

    public void setQgBMap(Map<Integer, List<Double>> qgBMap) {
        this.qgBMap = qgBMap;
    }

    public List<Double> getPgBList() {
        return pgBList;
    }

    public void setPgBList(List<Double> pgBList) {
        this.pgBList = pgBList;
    }

    public Map<Integer, List<Map<Double, Double>>> getqStatisticsBMap() {
        return qStatisticsBMap;
    }

    public void setqStatisticsBMap(Map<Integer, List<Map<Double, Double>>> qStatisticsBMap) {
        this.qStatisticsBMap = qStatisticsBMap;
    }

    public List<Map<Double, Double>> getzStatisticsBList() {
        return zStatisticsBList;
    }

    public void setzStatisticsBList(List<Map<Double, Double>> zStatisticsBList) {
        this.zStatisticsBList = zStatisticsBList;
    }

	@Override
	public String toString() {
		return "GradeUtil [exam=" + exam + ", qgMap=" + qgMap + ", sqgMap=" + sqgMap + ", studentGrade=" + studentGrade
				+ ", pgMap=" + pgMap + ", pgList=" + pgList + ", qStatisticsMap=" + qStatisticsMap
				+ ", zStatisticsList=" + zStatisticsList + ", qgBMap=" + qgBMap + ", pgBList=" + pgBList
				+ ", qStatisticsBMap=" + qStatisticsBMap + ", zStatisticsBList=" + zStatisticsBList + ", pointBMap="
				+ pointBMap + ", pointAVGList=" + pointAVGList + "]";
	}
    
    
}
