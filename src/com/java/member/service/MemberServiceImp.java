package com.java.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.member.dao.memberDao;
import com.java.member.dto.MemberDTO;

public class MemberServiceImp implements MemberSerivce {

	private memberDao memberDao;
	
	public MemberServiceImp() {}

	public MemberServiceImp(com.java.member.dao.memberDao memberDao) {
		this.memberDao = memberDao;
	}


	public void setMemberDao(memberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void memberRegisterOk(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		
		MemberDTO memberDto = (MemberDTO)map.get("memberDto");
		
		memberDto.setMemberLevel("BA");
		
		int check = memberDao.memberInsert(memberDto);
		
		HAspect.logger.info(HAspect.logMsg+check);
		
		mav.addObject("check", check);
		mav.setViewName("member/registerOk");
		
	}

	@Override
	public void memberIdCheck(ModelAndView mav) {
		Map<String,Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		HAspect.logger.info(HAspect.logMsg+id);
		
		int check = memberDao.memberIdCheck(id);
		HAspect.logger.info(HAspect.logMsg+check);
		
		mav.addObject("check", check);
		mav.addObject("id", id);
		mav.setViewName("member/idCheck");
	}
	
}
