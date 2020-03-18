package com.lzw.service;

import java.util.List;

import com.lzw.domain.Clbum;

public interface ClbumsService {

	public void insert(Clbum clbum);
	public int delete(int id);
	public void update(Clbum clbum);
	
	public Clbum query(String name);
	
	public Clbum query(int id);
	
	public List<Clbum> queryList(Clbum clbum);
	
	public List<Clbum> queryList();
	
}
