package com.lzw.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzw.dao.ClbumMapper;
import com.lzw.domain.Clbum;
import com.lzw.domain.ClbumExample;
import com.lzw.domain.ClbumExample.Criteria;
import com.lzw.service.ClbumsService;

@Service
public class ClbumsServiceImp implements ClbumsService {
	
	@Autowired
	private ClbumMapper clbumMapper;

	@Override
	public void insert(Clbum clbum) {
		clbumMapper.insert(clbum);
	}

	@Override
	public int delete(int id) {
		return clbumMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Clbum clbum) {
		clbumMapper.updateByPrimaryKey(clbum);
	}

	@Override
	public Clbum query(String name) {
		return null;
	}
	@Override
	public Clbum query(int id) {
		// TODO Auto-generated method stub
		return clbumMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Clbum> queryList(Clbum clbum) {
		ClbumExample clbumE = new ClbumExample();
		Criteria ca = clbumE.createCriteria();
		
		if(clbum.getClbumname()!=null) {
			ca.andClbumnameLike("%"+clbum.getClbumname()+"%");
		}
		
		if(clbum.getMajor()!=null) {
			ca.andMajorLike("%"+clbum.getMajor()+"%");
		}
		
		return clbumMapper.selectByExample(clbumE);
	}

	@Override
	public List<Clbum> queryList() {
		ClbumExample clbumExample = new ClbumExample();
		Criteria criteria = clbumExample.createCriteria();
//		criteria.andClbumnameLike()

		return clbumMapper.selectByExample(clbumExample);
	}

}
