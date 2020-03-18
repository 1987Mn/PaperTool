package com.lzw.domain;

import java.util.List;

public class Question {
    private Integer id;

    private Integer paperid;

    private String content;

    private String content1;

    private Double score;

    private Integer smallquestionnum;
    
    private List<Smallquestion> smallqs;

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
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

    public Integer getSmallquestionnum() {
        return smallquestionnum;
    }

    public void setSmallquestionnum(Integer smallquestionnum) {
        this.smallquestionnum = smallquestionnum;
    }

	public List<Smallquestion> getSmallqs() {
		return smallqs;
	}

	public void setSmallqs(List<Smallquestion> smallqs) {
		this.smallqs = smallqs;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", paperid=" + paperid + ", content=" + content + ", content1=" + content1
				+ ", score=" + score + ", smallquestionnum=" + smallquestionnum + ", smallqs=" + smallqs + "]";
	}


}