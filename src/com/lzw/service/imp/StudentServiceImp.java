package com.lzw.service.imp;

import java.util.List;

import com.lzw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.StudentMapper;
import com.lzw.domain.Student;
import com.lzw.domain.StudentExample;
import com.lzw.domain.StudentExample.Criteria;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	@Override
	public void insert(Student obj) {
		studentMapper.insert(obj);
	}

	@Override
	public void delete(String id) {
		studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Student obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student query(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student query(Integer sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> queryList(Student student) {
		StudentExample studentE = new StudentExample();
		Criteria criteria = studentE.createCriteria();
		criteria.andClbumidEqualTo(student.getClbumid());
		
		if(student.getName()!=null) {
			criteria.andNameLike("%"+student.getName()+"%");
		}
		if(student.getSid()!=null) {
			criteria.andSidLike("%"+student.getSid()+"%");
		}
		return studentMapper.selectByExample(studentE);
	}
	
	@Override
	public List<Student> queryList() {
		return studentMapper.selectByExample(new StudentExample());
	}
	


}
