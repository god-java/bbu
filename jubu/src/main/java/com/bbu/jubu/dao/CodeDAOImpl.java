package com.bbu.jubu.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bbu.jubu.vo.CodeVO;

@Repository
public class CodeDAOImpl implements CodeDAO {

	@Inject
	private SqlSessionTemplate sst;
	
	private static final String NAMESPACE = "com.bbu.jubu.dao.CodeDAO";
	
	@Override
	public List<CodeVO> code_list() {
		// TODO Auto-generated method stub
		return sst.selectList(NAMESPACE+".code_list");
	}

	@Override
	public CodeVO code_info(String code) {
		// TODO Auto-generated method stub
		return sst.selectOne(NAMESPACE+".code_info",code);
	}

	@Override
	public void code_register_ok(CodeVO cvo) {
		// TODO Auto-generated method stub
		sst.insert(NAMESPACE+".code_register_ok",cvo);
	}

}
