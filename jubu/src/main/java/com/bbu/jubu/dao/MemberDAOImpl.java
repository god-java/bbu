package com.bbu.jubu.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bbu.jubu.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSessionTemplate sst;
	
	private static final String NAMESPACE = "com.bbu.jubu.dao.MemberDAO";
	
	@Override
	public List<MemberVO> member_list() {
		// TODO Auto-generated method stub
		return sst.selectList(NAMESPACE+".member_list");
	}

}
