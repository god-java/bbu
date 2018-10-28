package com.bbu.jubu.dao;

import java.util.List;

import com.bbu.jubu.vo.CodeVO;

public interface CodeDAO {

	public List<CodeVO> code_list();
	public CodeVO code_info(String code);
	public void code_register_ok(CodeVO cvo);
}
