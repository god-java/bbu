package com.bbu.jubu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbu.jubu.dao.CodeDAO;
import com.bbu.jubu.vo.CodeVO;

@Service
public class CodeServiceImpl implements CodeService {

	@Inject
	private CodeDAO cdao;
	
	@Override
	public List<CodeVO> code_list() {
		// TODO Auto-generated method stub
		return cdao.code_list();
	}

	@Override
	public CodeVO code_info(String code) {
		// TODO Auto-generated method stub
		return cdao.code_info(code);
	}

	@Override
	public void code_register_ok(CodeVO cvo) {
		// TODO Auto-generated method stub
		cdao.code_register_ok(cvo);
	}
	
}
