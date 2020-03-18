package com.lzw.dao;

import com.lzw.domain.Exam;
import com.lzw.domain.ExamExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExamMapper {
    int countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);
    
    List<Exam> selectExamAndClbum(@Param("major") String major, @Param("shijuan") String shijuan);

    Exam selectByPrimaryKey(Integer id);

    Exam selectById(Exam exam);
    
    Exam selectExam(Exam exam);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}