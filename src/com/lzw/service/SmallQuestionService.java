package com.lzw.service;

import java.util.List;

import com.lzw.domain.Paper;
import com.lzw.domain.Smallquestion;

public interface SmallQuestionService {

	public void insert(Smallquestion obj);
	public void delete(int id);
	public void update(Smallquestion obj);
	
	public Smallquestion query(String name);
	public Smallquestion query(int id);
	
	public List<Smallquestion> queryList(Smallquestion obj);
	
	public List<Smallquestion> queryList();
	
}
