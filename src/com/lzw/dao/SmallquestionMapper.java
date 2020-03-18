package com.lzw.dao;

import com.lzw.domain.Smallquestion;
import com.lzw.domain.SmallquestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallquestionMapper {
    int countByExample(SmallquestionExample example);

    int deleteByExample(SmallquestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Smallquestion record);

    int insertSelective(Smallquestion record);

    List<Smallquestion> selectByExample(SmallquestionExample example);

    Smallquestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Smallquestion record, @Param("example") SmallquestionExample example);

    int updateByExample(@Param("record") Smallquestion record, @Param("example") SmallquestionExample example);

    int updateByPrimaryKeySelective(Smallquestion record);

    int updateByPrimaryKey(Smallquestion record);
}