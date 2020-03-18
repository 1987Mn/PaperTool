package com.lzw.domain;

public class Clbum {
    private Integer id;

    private String clbumname;

    private String major;

    private String nianji;

    private Integer peoplenum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClbumname() {
        return clbumname;
    }

    public void setClbumname(String clbumname) {
        this.clbumname = clbumname == null ? null : clbumname.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getNianji() {
        return nianji;
    }

    public void setNianji(String nianji) {
        this.nianji = nianji == null ? null : nianji.trim();
    }

    public Integer getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(Integer peoplenum) {
        this.peoplenum = peoplenum;
    }

	@Override
	public String toString() {
		return "Clbum [id=" + id + ", clbumname=" + clbumname + ", major=" + major + ", nianji=" + nianji
				+ ", peoplenum=" + peoplenum + "]";
	}
    
    
}