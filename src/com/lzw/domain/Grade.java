package com.lzw.domain;

public class Grade {
    private Integer id;

    private Integer smallquestionid;

    private Integer examid;

    private String studentid;

    private Double totalpoint;

    private Double scorepoint1;

    private Double scorepoint2;

    private Double scorepoint3;

    private Double scorepoint4;

    private Double scorepoint5;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallquestionid() {
        return smallquestionid;
    }

    public void setSmallquestionid(Integer smallquestionid) {
        this.smallquestionid = smallquestionid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public Double getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(Double totalpoint) {
        this.totalpoint = totalpoint;
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
		return "Grade [id=" + id + ", smallquestionid=" + smallquestionid + ", examid=" + examid + ", studentid="
				+ studentid + ", totalpoint=" + totalpoint + ", scorepoint1=" + scorepoint1 + ", scorepoint2="
				+ scorepoint2 + ", scorepoint3=" + scorepoint3 + ", scorepoint4=" + scorepoint4 + ", scorepoint5="
				+ scorepoint5 + "]";
	}
    
}