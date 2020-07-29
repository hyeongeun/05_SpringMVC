package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.InternalResourceView;

import com.java.aop.HAspect;
import com.java.member.dto.MemberDTO;
import com.java.member.service.MemberSerivce;

public class MemberController extends MultiActionController{		//command

	
	private MemberSerivce memberService;

	
	public MemberController() {}
	
	public MemberController(MemberSerivce memberService) {
	this.memberService = memberService;
}

	public void setMemberService(MemberSerivce memberService) {
		this.memberService = memberService;
	}
	
	public ModelAndView testing(HttpServletRequest request, HttpServletResponse response) {
			//service -> Dao & Dto  -> service 
		
		System.out.println("ok");
		
		//최상위 클래스는 View 이다. 
		/*
		 * InternalResourceView view = new InternalResourceView("/WEB-INF/member/test.jsp");
		 * 
		 * ModelAndView mav = new ModelAndView(); 
		 * mav.addObject("msg", "hi");
		 * mav.setView(view);
		 */
		
		ModelAndView mav = new ModelAndView("member/test");
		mav.addObject("msg", "hi");
		
		return mav;
	}
	
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/register");
	}
	
	public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response, MemberDTO memberDto) {
		HAspect.logger.info(HAspect.logMsg+ memberDto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto", memberDto);
		
		memberService.memberRegisterOk(mav);
		
		return mav;
	}
	
	public ModelAndView memberIdCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.memberIdCheck(mav);
		
		return mav;
	}
	
	public ModelAndView memberZipcode(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.memberZipcode(mav);
		
		return mav;
	}
	
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/login");
	}
	
	public ModelAndView logInOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.logInCheck(mav);
		
		return mav;
	}
	
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/main");
	}
	
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		
		if(!session.isNew()) {
			String id=(String)session.getAttribute("id");
			String memberLevel=(String)session.getAttribute("memberLevel");
		}
		
		return new ModelAndView("member/logout");
	}
	
	public ModelAndView memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		mav.addObject("id", id);
		
		//memberService.memberUpdate(mav);
		
		
		return mav;
	}
	
	
}
