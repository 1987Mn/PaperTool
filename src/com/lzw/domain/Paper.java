package com.lzw.domain;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Paper {
    private Integer id;

    private String title;

    private String course;

    private String coursenum;

    private String college;

    private String teacher;

    private String classamajor;

    private String testnum;

    private Date testtime;

    private String testway;

    private Integer questionnum;

    private Integer smallquestionnum;

    private Double totalpoints;
    
    private List<Question> questions;
    
    
	public Map<Integer,Question> questionsToMap(List<Question> qsList){
		Map<Integer,Question> qm = new LinkedHashMap<>();
		for (Question question : qsList) {
			qm.put(question.getId(), question);
		}
		return qm; 
	}
	public Map<Integer,Smallquestion> squestionsToMap(List<Smallquestion> qsList){
		Map<Integer,Smallquestion> qm = new LinkedHashMap<>();
		for (Smallquestion squestion : qsList) {
			qm.put(squestion.getId(), squestion);
		}
		return qm;
	}

    public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public String getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(String coursenum) {
        this.coursenum = coursenum == null ? null : coursenum.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getClassamajor() {
        return classamajor;
    }

    public void setClassamajor(String classamajor) {
        this.classamajor = classamajor == null ? null : classamajor.trim();
    }

    public String getTestnum() {
        return testnum;
    }

    public void setTestnum(String testnum) {
        this.testnum = testnum == null ? null : testnum.trim();
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public String getTestway() {
        return testway;
    }

    public void setTestway(String testway) {
        this.testway = testway == null ? null : testway.trim();
    }

    public Integer getQuestionnum() {
        return questionnum;
    }

    public void setQuestionnum(Integer questionnum) {
        this.questionnum = questionnum;
    }

    public Integer getSmallquestionnum() {
        return smallquestionnum;
    }

    public void setSmallquestionnum(Integer smallquestionnum) {
        this.smallquestionnum = smallquestionnum;
    }

    public Double getTotalpoints() {
        return totalpoints;
    }

    public void setTotalpoints(Double totalpoints) {
        this.totalpoints = totalpoints;
    }

	@Override
	public String toString() {
		return "Paper [id=" + id + ", title=" + title + ", course=" + course + ", coursenum=" + coursenum + ", college="
				+ college + ", teacher=" + teacher + ", classamajor=" + classamajor + ", testnum=" + testnum
				+ ", testtime=" + testtime + ", testway=" + testway + ", questionnum=" + questionnum
				+ ", smallquestionnum=" + smallquestionnum + ", totalpoints=" + totalpoints + ", questions=" + questions
				+ "]";
	}
	
	
    
}