package com.lzw.service.imp;

import java.util.List;

import com.lzw.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.GradeMapper;
import com.lzw.domain.Grade;
import com.lzw.domain.GradeExample;
import com.lzw.domain.GradeExample.Criteria;

@Service
public class GradeServiceImp implements GradeService {

	@Autowired
	GradeMapper gradeMapper;
	
	@Override
	public void insert(Grade obj) {
		gradeMapper.insert(obj);
	}

	@Override
	public void delete(int examid) {
		gradeMapper.deleteByExamId(examid);
	}

	@Override
	public void update(Grade grade) {
		gradeMapper.updateByPrimaryKeySelective(grade);
	}

	@Override
	public Grade query(Grade exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> queryList(Grade obj) {
		GradeExample gradeE = new GradeExample();
		Criteria criteria = gradeE.createCriteria();
		criteria.andExamidEqualTo(obj.getExamid());
		criteria.andSmallquestionidEqualTo(obj.getSmallquestionid());
		return gradeMapper.selectByExample(gradeE);
	}

	@Override
	public List<Grade> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

}
