package com.lzw.service.imp;

import java.util.List;

import com.lzw.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.PaperMapper;
import com.lzw.domain.Paper;
import com.lzw.domain.PaperExample;
import com.lzw.domain.PaperExample.Criteria;

@Service
public class PaperServiceImp implements PaperService {

	@Autowired
	private PaperMapper paperMapper ;

	@Override
	public void insert(Paper obj) {
		paperMapper.insert(obj);
	}

	@Override
	public void delete(int id) {
		paperMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Paper obj) {
		paperMapper.updateByPrimaryKeySelective(obj);
	}

	@Override
	public Paper query(String name) {
		return null;
	}

	@Override
	public List<Paper> queryList(Paper obj) {
		
		PaperExample paperE = new PaperExample();
		
		Criteria criteria = paperE.createCriteria();
		
		if(obj.getTitle()!=null) {
			criteria.andTitleLike("%"+obj.getTitle()+"%");
		}
		
		if(obj.getCourse()!=null) {
			criteria.andCourseLike("%"+obj.getCourse()+"%");
		}
		
		paperMapper.selectByExample(paperE);
		
		return 	paperMapper.selectByExample(paperE);
	}

	@Override
	public List<Paper> queryList() {
		return	paperMapper.selectByExample(new PaperExample());
	}

	@Override
	public Paper query(Integer id) {
		return paperMapper.selectByPrimaryKey(id);
	}

}
