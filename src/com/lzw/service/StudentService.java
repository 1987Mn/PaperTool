package com.lzw.service;

import java.util.List;

import com.lzw.domain.Student;

public interface StudentService {

	public void insert(Student obj);
	public void delete(String id);
	public void update(Student obj);
	
	public Student query(String name);
	
	public Student query(Integer sid);
	
	public List<Student> queryList(Student obj);
	
	public List<Student> queryList();
	
}
