package com.bbu.jubu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbu.jubu.dao.CodeDAO;
import com.bbu.jubu.vo.CodeVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CodeController {

	@Inject
	private CodeDAO cdao;
	
	public String json(Map<String,Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		String json="";
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/code_register")
	public String code_register(Model m) {
		List<CodeVO> clist = cdao.code_list();
		m.addAttribute("clist",clist);
		m.addAttribute("center","code_register.jsp");
		return "main";
	}
	@RequestMapping(value="/code_info", produces="application/text; charset=utf-8")
	@ResponseBody
	public String code_info(String code) {
		CodeVO cvo = cdao.code_info(code);
		cvo.setCode_level(cvo.getCode_level()+1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cvo", cvo);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	@RequestMapping(value="/code_register_ok",produces="application/text; charset=utf-8")
	@ResponseBody
	public String code_register_ok(CodeVO cvo) {
		System.out.println(cvo.getCode_level());
		System.out.println(cvo.getCode_name());
		System.out.println(cvo.getUp_code());
		cdao.code_register_ok(cvo);
		List<CodeVO> clist = cdao.code_list();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("clist", clist);
		return json(map);
	}
	@RequestMapping(value="/code_list",produces="application/text; charset=utf-8")
	@ResponseBody
	public String code_list() {
		List<CodeVO> clist = cdao.code_list();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("clist", clist);
		return json(map);
	}
}
