package com.java.fileBoard.service;

import org.springframework.web.servlet.ModelAndView;

public interface FileBoardService {
	
	public void fileBoardWrite(ModelAndView mav);

	public void fileBoardWriteOk(ModelAndView mav);

	public void fileBoardList(ModelAndView mav);

	public void fileBoardRead(ModelAndView mav);

	public void fileBoardDownLoad(ModelAndView mav);

	public void fileBoardDelete(ModelAndView mav);

	public void fileBoardDeleteOk(ModelAndView mav);

}
