package com.java.fileBoard.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.fileBoard.dao.FileBoardDao;
import com.java.fileBoard.dto.FileBoardDTO;

public class FileBoardServiceImp implements FileBoardService {

	private FileBoardDao fileBoardDao;
	
	public FileBoardServiceImp() {}

	public FileBoardServiceImp(FileBoardDao fileBoardDao) {
		this.fileBoardDao = fileBoardDao;
	}

	public void setFileBoardDao(FileBoardDao fileBoardDao) {
		this.fileBoardDao = fileBoardDao;
	}

	@Override
	public void fileBoardWrite(ModelAndView mav) {
		// root
				int boardNumber=0;		// root 글이면 0번
				int groupNumber=1;		// 그룹 번호
				int sequenceNumber=0;	// 글 순서
				int sequenceLevel=0;	// 글 레벨
				
				Map<String, Object> map = mav.getModelMap();
				HttpServletRequest request =(HttpServletRequest)map.get("request");
				
				// 답글 (boardNumber=부모글 번호) DB 글 번호, 그룹 번호, 글 순서, 글 레벨 가져오기.
				if(request.getParameter("boardNumber")!=null ) {
					boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
					groupNumber=Integer.parseInt(request.getParameter("groupNumber"));
					sequenceNumber=Integer.parseInt(request.getParameter("sequenceNumber"));
					sequenceLevel=Integer.parseInt(request.getParameter("sequenceLevel"));		
				}
				
				mav.addObject("boardNumber",boardNumber);
				mav.addObject("groupNumber",groupNumber);
				mav.addObject("sequenceNumber",sequenceNumber);
				mav.addObject("sequenceLevel",sequenceLevel);
				
				mav.setViewName("fileBoard/write");
		
	}

	@Override
	public void fileBoardWriteOk(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		FileBoardDTO fileBoardDto = (FileBoardDTO)map.get("fileBoardDto");
		MultipartHttpServletRequest request =(MultipartHttpServletRequest)map.get("request");
		
		fileBoardDto.setWriteDate(new Date());
		fileBoardDto.setReadCnt(0);
		
		HAspect.logger.info(HAspect.logMsg + fileBoardDto);
		
		
	}
	
	
	
}
