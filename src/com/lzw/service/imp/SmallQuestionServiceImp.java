package com.lzw.service.imp;

import java.util.List;

import com.lzw.service.SmallQuestionService;
import com.lzw.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.SmallquestionMapper;
import com.lzw.domain.Paper;
import com.lzw.domain.Smallquestion;
import com.lzw.domain.SmallquestionExample;
import com.lzw.domain.SmallquestionExample.Criteria;

@Service
public class SmallQuestionServiceImp implements SmallQuestionService {
	
	@Autowired
	private SmallquestionMapper smallquestionMapper;

	@Override
	public void insert(Smallquestion obj) {
		smallquestionMapper.insert(obj);
	}

	@Override
	public void delete(int id) {
		smallquestionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Smallquestion obj) {
		smallquestionMapper.updateByPrimaryKeySelective(obj);		
	}

	@Override
	public Smallquestion query(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Smallquestion query(int id) {
		
		return smallquestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Smallquestion> queryList(Smallquestion obj) {
		
		SmallquestionExample smallquestionExample = new SmallquestionExample();
		
		Criteria criteria = smallquestionExample.createCriteria();
		if(Tool.isEmpty(obj.getContent())) {
			criteria.andContentLike(obj.getContent());
		}
		
		return smallquestionMapper.selectByExample(new SmallquestionExample());
	}

	@Override
	public List<Smallquestion> queryList() {
		return smallquestionMapper.selectByExample(new SmallquestionExample());
	}

	

}
