package com.java.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.member.dao.memberDao;
import com.java.member.dto.MemberDTO;
import com.java.member.dto.ZipcodeDTO;

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

	@Override
	public void memberZipcode(ModelAndView mav) {
		Map<String, Object> map =  mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String dong = request.getParameter("dong");


		if(dong!=null) {
			List<ZipcodeDTO> zipcodeDto = memberDao.zipcode(dong);
			HAspect.logger.info(HAspect.logMsg+zipcodeDto.size());
			
			mav.addObject("zipcodelist", zipcodeDto);
			
		}
		
		mav.setViewName("member/zipcodeSearch");
	}

	@Override
	public void logInCheck(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HAspect.logger.info(HAspect.logMsg+"id: "+id+"\t password: "+password);
		String memberLevel = memberDao.logIn(id,password);
		
		HAspect.logger.info(HAspect.logMsg+"value: "+memberLevel);
		
		mav.addObject("id", id);
		mav.addObject("memberLevel", memberLevel);
		mav.setViewName("member/loginOk");
		
	}

	@Override
	public void memberUpdate(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
	}


	
}
