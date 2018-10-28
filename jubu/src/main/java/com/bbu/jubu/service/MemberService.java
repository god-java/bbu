package com.bbu.jubu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bbu.jubu.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> member_list();
}
