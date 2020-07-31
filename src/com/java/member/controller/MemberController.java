package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.InternalResourceView;

import com.java.aop.HAspect;
import com.java.member.dto.MemberDTO;
import com.java.member.service.MemberSerivce;

@Controller
public class MemberController {		
	@Autowired
	private MemberSerivce memberService;

	@RequestMapping(value="/member/test.do", method=RequestMethod.GET)
	public ModelAndView testing(HttpServletRequest request, HttpServletResponse response) {
			//service -> Dao & Dto  -> service 
		//System.out.println("ok");
		
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
	@RequestMapping(value="/member/register.do", method = RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/register");
	}
	@RequestMapping(value="/member/registerOk.do", method = RequestMethod.GET)
	public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response, MemberDTO memberDto) {
		HAspect.logger.info(HAspect.logMsg+ memberDto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto", memberDto);
		
		memberService.memberRegisterOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/idCheck.do", method = RequestMethod.GET)
	public ModelAndView memberIdCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.memberIdCheck(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/zipcode.do", method = RequestMethod.POST)
	public ModelAndView memberZipcode(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.memberZipcode(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/login.do", method = RequestMethod.GET)
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/login");
	}
	
	@RequestMapping(value="/member/loginOk.do", method = RequestMethod.POST)
	public ModelAndView logInOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		memberService.logInCheck(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/main.do", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/main");
	}
	
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		
		if(!session.isNew()) {
			String id=(String)session.getAttribute("id");
			String memberLevel=(String)session.getAttribute("memberLevel");
		}
		
		return new ModelAndView("member/logout");
	}
	
	@RequestMapping(value="/member/update.do", method = RequestMethod.GET)
	public ModelAndView memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		
		mav.addObject("session", session);
		memberService.memberUpdate(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/updateOk.do", method = RequestMethod.GET)
	public ModelAndView memberUpdateOk(HttpServletRequest request, HttpServletResponse response, MemberDTO memberDto) {
		HAspect.logger.info(HAspect.logMsg+memberDto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto", memberDto);
		memberService.memberUpdateOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/member/delete.do", method = RequestMethod.GET)
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/delete");
	}
	
	@RequestMapping(value="/member/deleteOk.do", method = RequestMethod.POST)
	public ModelAndView memberDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("request", request);
		memberService.memberDeleteOk(mav);
		
		return mav;
	}
	
	
	

	
	
}
