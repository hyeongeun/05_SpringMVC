package com.java.member.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberSerivce {
	
	public void memberRegisterOk(ModelAndView mav);
	
	public void memberIdCheck(ModelAndView mav);

}
