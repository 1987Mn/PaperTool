package com.lzw.domain;

public class Student {
    private String sid;

    private Integer clbumid;

    private String name;
    
    public Student () {}
    
    public Student(String sid, String name, Integer clbumid) {
		this.sid = sid;
		this.clbumid = clbumid;
		this.name = name;
	}

	public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Integer getClbumid() {
        return clbumid;
    }

    public void setClbumid(Integer clbumid) {
        this.clbumid = clbumid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", clbumid=" + clbumid + ", name=" + name + "]";
	}
    
}