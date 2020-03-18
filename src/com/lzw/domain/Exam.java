package com.lzw.domain;

import java.util.Date;
import java.util.List;

public class Exam {
    private Integer id;

    private Integer paperid;

    private Integer clbumid;

    private Date testdate;

    private String clbumroom;

    private Integer peoplenum;
    
    private Clbum clbum;
    
    private List<Student> studentList;
    
    private Paper paper;
    
    public Integer getId() {
        return id;
    }
    
    public Clbum getClbum() {
		return clbum;
	}

	public void setClbum(Clbum clbum) {
		this.clbum = clbum;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
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

    public Integer getClbumid() {
        return clbumid;
    }

    public void setClbumid(Integer clbumid) {
        this.clbumid = clbumid;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }

    public String getClbumroom() {
        return clbumroom;
    }

    public void setClbumroom(String clbumroom) {
        this.clbumroom = clbumroom == null ? null : clbumroom.trim();
    }

    public Integer getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(Integer peoplenum) {
        this.peoplenum = peoplenum;
    }

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", paperid=" + paperid + ", clbumid=" + clbumid + ", testdate=" + testdate
				+ ", clbumroom=" + clbumroom + ", peoplenum=" + peoplenum + ", clbum=" + clbum + ", studentList="
				+ studentList + ", paper=" + paper + "]";
	}

}