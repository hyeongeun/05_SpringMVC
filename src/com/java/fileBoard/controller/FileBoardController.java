package com.java.fileBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.fileBoard.dto.FileBoardDTO;
import com.java.fileBoard.service.FileBoardService;

public class FileBoardController extends MultiActionController{
	private FileBoardService fileBoardService;

	public FileBoardController() {}
	
	public FileBoardController(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}

	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}
	
	public ModelAndView fileBoardWrite(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("okkk");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		
		fileBoardService.fileBoardWrite(mav);
		
		return mav;
	}
	
	public void fileBoardWriteOk(HttpServletRequest request, HttpServletResponse response, FileBoardDTO fileBoardDto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("fileBoardDto", fileBoardDto);
		
		fileBoardService.fileBoardWriteOk(mav);
		
		
	}
	
	
	
}
