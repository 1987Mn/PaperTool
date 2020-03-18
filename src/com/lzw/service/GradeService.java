package com.lzw.service;

import java.util.List;

import com.lzw.domain.Grade;

public interface GradeService {
	
	public void insert(Grade obj);
	public void delete(int examid);
	public void update(Grade grade);
	
	public Grade query(Grade exam);
	
	public List<Grade> queryList(Grade obj);
	
	public List<Grade> queryList();
	

}
