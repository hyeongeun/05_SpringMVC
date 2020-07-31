package com.java.fileBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.fileBoard.dto.FileBoardDTO;
import com.java.fileBoard.service.FileBoardService;

@Controller
public class FileBoardController{
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value="/fileBoard/write.do", method=RequestMethod.GET)
	public ModelAndView fileBoardWrite(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("okkk");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		fileBoardService.fileBoardWrite(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/fileBoard/writeOk.do", method=RequestMethod.POST)
	public ModelAndView fileBoardWriteOk(HttpServletRequest request, HttpServletResponse response, FileBoardDTO fileBoardDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("fileBoardDto", fileBoardDto);
		
		fileBoardService.fileBoardWriteOk(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/fileBoard/list.do", method=RequestMethod.GET)
	public ModelAndView fileBoardList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		fileBoardService.fileBoardList(mav);
		
		return mav;
		
	}
	
	@RequestMapping(value="/fileBoard/read.do", method=RequestMethod.GET)
	public ModelAndView fileBoardRead(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		fileBoardService.fileBoardRead(mav);
		return mav;
		
	}
	@RequestMapping(value="/fileBoard/downLoad.do", method=RequestMethod.GET)
	public void fileBoardDownLoad(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("response", response);
		
		fileBoardService.fileBoardDownLoad(mav);
		
	}
	
	@RequestMapping(value="/fileBoard/delete.do", method=RequestMethod.GET)
	public ModelAndView fileBoardDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		fileBoardService.fileBoardDelete(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/fileBoard/deleteOk.do", method=RequestMethod.POST)
	public ModelAndView fileBoardDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request",request);
		
		fileBoardService.fileBoardDeleteOk(mav);
		
		return mav;
	}
	
}
