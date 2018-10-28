package com.bbu.jubu.service;

import java.util.List;

import com.bbu.jubu.vo.CodeVO;

public interface CodeService {
	public List<CodeVO> code_list();
	public CodeVO code_info(String code);
	public void code_register_ok(CodeVO cvo);

}
