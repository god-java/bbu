package com.bbu.jubu.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbu.jubu.dao.MemberDAO;
import com.bbu.jubu.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO mdao;
	
	@Override
	public List<MemberVO> member_list() {
		// TODO Auto-generated method stub
		return mdao.member_list();
	}

}
