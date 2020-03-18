package com.lzw.dao;

import com.lzw.domain.Clbum;
import com.lzw.domain.ClbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClbumMapper {
    int countByExample(ClbumExample example);

    int deleteByExample(ClbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Clbum record);

    int insertSelective(Clbum record);

    List<Clbum> selectByExample(ClbumExample example);

    Clbum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Clbum record, @Param("example") ClbumExample example);

    int updateByExample(@Param("record") Clbum record, @Param("example") ClbumExample example);

    int updateByPrimaryKeySelective(Clbum record);

    int updateByPrimaryKey(Clbum record);
}