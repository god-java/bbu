package com.bbu.jubu;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbu.jubu.service.MemberService;
import com.bbu.jubu.vo.MemberVO;

@Controller
public class MemberController {

	@Inject
	MemberService ms;
	
	@RequestMapping(value="/member_list")
	public String member_list() {
		List<MemberVO> mlist = ms.member_list();
		return "main";
	}
}
