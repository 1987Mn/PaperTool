package com.lzw.service;

import java.util.List;
import java.util.Map;

import com.lzw.domain.Paper;
import com.lzw.domain.Question;

public interface QuestionService {

	public void insert(Question obj);
	public void delete(int id);
	public void update(Question obj);
	
	public Question query(String name);
	
	public Question query(Integer id);
	
	public Map<Integer,Question> queryList(Question obj);
	
	public List<Question> list(Question obj);
	
}
