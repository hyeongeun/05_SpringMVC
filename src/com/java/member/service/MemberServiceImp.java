package com.java.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.member.dao.memberDao;
import com.java.member.dto.MemberDTO;
import com.java.member.dto.ZipcodeDTO;

@Component
public class MemberServiceImp implements MemberSerivce {
	@Autowired
	private memberDao memberDao;

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
		HttpSession session = (HttpSession)map.get("session");
		
		String id = (String)session.getAttribute("id");
		HAspect.logger.info(HAspect.logMsg+"id: "+id);
		MemberDTO memberDto = memberDao.MemberSelect(id);
		
		mav.addObject("id", id);
		mav.addObject("memberdto", memberDto);
		
		mav.setViewName("member/update");
	}
	
	@Override
	public void memberUpdateOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		MemberDTO memberDto = (MemberDTO)map.get("memberDto");
		
		int check = memberDao.memberUpdate(memberDto);
		mav.addObject("check", check);
		
		mav.setViewName("member/updateOk");
	}

	@Override
	public void memberDeleteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HAspect.logger.info(HAspect.logMsg+"id: "+id+" , password: "+password);
		
		int check = memberDao.memberDeleteOk(id,password);
		
		mav.addObject("check", check);
		mav.setViewName("member/deleteOk");
	}




	
}
