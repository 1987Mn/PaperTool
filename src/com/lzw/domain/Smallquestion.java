package com.lzw.domain;

import java.util.List;
import java.util.Map;

public class Smallquestion {
    private Integer id;

    private Integer questionid;

    private String content;

    private Double score;

    private Integer scorepointnum;

    private Double scorepoint1;

    private Double scorepoint2;

    private Double scorepoint3;

    private Double scorepoint4;

    private Double scorepoint5;
    
    private List<Grade> grades;
    
    private Map<String,Grade> gradeMap;
    
	public Map<String, Grade> getGradeMap() {
		return gradeMap;
	}

	public void setGradeMap(Map<String, Grade> gradeMap) {
		this.gradeMap = gradeMap;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getScorepointnum() {
        return scorepointnum;
    }

    public void setScorepointnum(Integer scorepointnum) {
        this.scorepointnum = scorepointnum;
    }

    public Double getScorepoint1() {
        return scorepoint1;
    }

    public void setScorepoint1(Double scorepoint1) {
        this.scorepoint1 = scorepoint1;
    }

    public Double getScorepoint2() {
        return scorepoint2;
    }

    public void setScorepoint2(Double scorepoint2) {
        this.scorepoint2 = scorepoint2;
    }

    public Double getScorepoint3() {
        return scorepoint3;
    }

    public void setScorepoint3(Double scorepoint3) {
        this.scorepoint3 = scorepoint3;
    }

    public Double getScorepoint4() {
        return scorepoint4;
    }

    public void setScorepoint4(Double scorepoint4) {
        this.scorepoint4 = scorepoint4;
    }

    public Double getScorepoint5() {
        return scorepoint5;
    }

    public void setScorepoint5(Double scorepoint5) {
        this.scorepoint5 = scorepoint5;
    }

	@Override
	public String toString() {
		return "Smallquestion [id=" + id + ", questionid=" + questionid + ", content=" + content + ", score=" + score
				+ ", scorepointnum=" + scorepointnum + ", scorepoint1=" + scorepoint1 + ", scorepoint2=" + scorepoint2
				+ ", scorepoint3=" + scorepoint3 + ", scorepoint4=" + scorepoint4 + ", scorepoint5=" + scorepoint5
				+ ", grades=" + grades + ", gradeMap=" + gradeMap + "]";
	}
    
}