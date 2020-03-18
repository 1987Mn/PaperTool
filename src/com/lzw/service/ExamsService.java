package com.lzw.service;

import java.util.List;

import com.lzw.domain.Exam;

public interface ExamsService {

	public void insert(Exam obj);
	public void delete(int id);
	public void update(Exam exam);
	
	public Exam query(Exam exam);
	
	public Exam query(String name);
	
	public List<Exam> queryList(Exam obj);
	
	public List<Exam> queryList(String major, String shijuan);
	
}
