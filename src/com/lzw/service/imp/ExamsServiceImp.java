package com.lzw.service.imp;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.ExamMapper;
import com.lzw.domain.Exam;
import com.lzw.domain.ExamExample;
import com.lzw.domain.ExamExample.Criteria;
import com.lzw.domain.Grade;
import com.lzw.domain.Question;
import com.lzw.domain.Smallquestion;
import com.lzw.domain.Student;
import com.lzw.service.ExamsService;
import com.lzw.service.GradeService;
import com.lzw.service.StudentService;

@Service
public class ExamsServiceImp implements ExamsService {
	
	@Autowired
	private ExamMapper examMapper;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private StudentService studentService;

	@Override
	public void insert(Exam obj) {
		examMapper.insert(obj);
	}

	@Override
	public void delete(int id) {
		examMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Exam exam) {
		examMapper.updateByPrimaryKey(exam);
	}

	@Override
	public Exam query(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exam> queryList(Exam obj) {
		ExamExample examE = new ExamExample();
		Criteria criteria = examE.createCriteria();
		
		if(obj.getClbumid()!=null) {
			criteria.andClbumidEqualTo(obj.getClbumid());
		}
		if(obj.getTestdate()!=null) {
			criteria.andTestdateEqualTo(obj.getTestdate());
		}

		return examMapper.selectByExample(examE);
	}

	@Override
	public List<Exam> queryList(String major,String shijuan) {
		List<Exam> exams =  examMapper.selectExamAndClbum(major,shijuan);
		
		for (Exam exam : exams) {
			for (Question question : exam.getPaper().getQuestions()) {
				for(Smallquestion squestion : question.getSmallqs()) {
					Grade grade = new Grade();
					grade.setExamid(exam.getId());
					grade.setSmallquestionid(squestion.getId());
					
					List<Grade> list = gradeService.queryList(grade);
					squestion.setGrades(list);
					
					Map<String,Grade> gradeMap = new LinkedHashMap<>();
					
					for (Grade grade01 : list) {
						gradeMap.put(grade01.getStudentid(),grade01);
					}
					squestion.setGradeMap(gradeMap);
				}
			}
		}
		return exams;
	}

	@Override
	public Exam query(Exam exam) {
		exam = examMapper.selectExam(exam);
		
		Student stu = new Student();
		stu.setClbumid(exam.getClbumid());
		exam.setStudentList(studentService.queryList(stu));
		
		for (Question question : exam.getPaper().getQuestions()) {
			for(Smallquestion squestion : question.getSmallqs()) {
				Grade grade = new Grade();
				grade.setExamid(exam.getId());
				grade.setSmallquestionid(squestion.getId());
				
				List<Grade> list = gradeService.queryList(grade);
				squestion.setGrades(list);
				
				Map<String,Grade> gradeMap = new LinkedHashMap<>();
				
				for (Grade grade01 : list) {
					gradeMap.put(grade01.getStudentid(),grade01);
				}
				squestion.setGradeMap(gradeMap);
			}
		}
		return exam;
	}

}
