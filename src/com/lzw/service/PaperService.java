package com.lzw.service;

import java.util.List;

import com.lzw.domain.Paper;

public interface PaperService {

	public void insert(Paper obj);
	public void delete(int id);
	public void update(Paper obj);
	
	public Paper query(String name);
	
	public Paper query(Integer id);
	
	public List<Paper> queryList(Paper obj);
	
	public List<Paper> queryList();
	
}
