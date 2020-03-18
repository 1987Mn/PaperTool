package com.lzw.service.imp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.QuestionMapper;
import com.lzw.dao.SmallquestionMapper;
import com.lzw.domain.Paper;
import com.lzw.domain.Question;
import com.lzw.domain.QuestionExample;
import com.lzw.domain.QuestionExample.Criteria;
import com.lzw.domain.SmallquestionExample;
import com.lzw.service.QuestionService;
import com.lzw.util.Tool;

@Service
public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionMapper questionMapper;

	@Autowired
	SmallquestionMapper smallquestionMapper;

	@Override
	public void insert(Question obj) {
		questionMapper.insert(obj);

	}

	@Override
	public void delete(int id) {
		questionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Question obj) {
		questionMapper.updateByPrimaryKey(obj);
	}

	@Override
	public Question query(String name) {
		return null;
	}
	
	@Override
	public Question query(Integer id) {
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<Integer, Question> queryList(Question obj) {

		Map<Integer, Question> map = new LinkedHashMap<>();

		QuestionExample questionExample = new QuestionExample();

		Criteria criteria = questionExample.createCriteria();
		criteria.andPaperidEqualTo(obj.getPaperid());

		List<Question> questions = questionMapper.selectByExample(questionExample);

		for (Question question : questions) {
			SmallquestionExample smallquestionExample = new SmallquestionExample();
			SmallquestionExample.Criteria sqcriteria = smallquestionExample.createCriteria();
			sqcriteria.andQuestionidEqualTo(question.getId());
			question.setSmallqs(smallquestionMapper.selectByExample(smallquestionExample));

			map.put(question.getId(), question);

		}

		return map;

	}

	@Override
	public List<Question> list(Question question) {
		QuestionExample questionE = new QuestionExample();
		Criteria criteria = questionE.createCriteria();
		
		criteria.andPaperidEqualTo((question.getPaperid()));
		
		if(question.getContent1()!= null) {
			criteria.andContent1Like("%"+question.getContent1()+"%");
		}
		
		return questionMapper.selectByExample(questionE);
	}

}
