package com.java.fileBoard.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.fileBoard.dao.FileBoardDao;
import com.java.fileBoard.dto.FileBoardDTO;

@Component
public class FileBoardServiceImp implements FileBoardService {

	@Autowired
	private FileBoardDao fileBoardDao;

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

		writeNumber(fileBoardDto);

		fileBoardDto.setWriteDate(new Date());
		fileBoardDto.setReadCnt(0);
		HAspect.logger.info(HAspect.logMsg + fileBoardDto);

		MultipartFile upFile = request.getFile("file");
		if(upFile.getSize() != 0) {
			//저장경로, 파일명, 사이즈
			String fileName = Long.toString(System.currentTimeMillis())+"_"+upFile.getOriginalFilename();
			long fileSize = upFile.getSize();

			File path = new File("C:\\pds\\");
			path.mkdir();

			if(path.exists() && path.isDirectory()) {
				File file = new File(path, fileName);

				try {
					upFile.transferTo(file);

					fileBoardDto.setPath(file.getAbsolutePath());
					fileBoardDto.setFileName(fileName);
					fileBoardDto.setFileSize(fileSize);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		HAspect.logger.info(HAspect.logMsg + fileBoardDto);
		int check=fileBoardDao.fileBoardWrite(fileBoardDto);
		HAspect.logger.info(HAspect.logMsg+check);
		mav.addObject("check", check);
		mav.setViewName("fileBoard/writeOk");
	}


	public void writeNumber(FileBoardDTO fileBoarddto) {
		// 그룹번호(ROOT), 글순서(자식), 글레벨(자식)

		int boardNumber=fileBoarddto.getBoardNumber();
		int sequenceNumber=fileBoarddto.getSequenceNumber();
		int sequenceLevel=fileBoarddto.getSequenceLevel();
		int groupNumber = fileBoarddto.getGroupNumber();

		if(boardNumber == 0) {
			int max = fileBoardDao.fileBoardGroupNumberMax();
			if(max != 0)fileBoarddto.setGroupNumber(max+1);

		}else {
			HashMap<String, Integer> hMap = new HashMap<String, Integer>();
			hMap.put("groupNumber",groupNumber);
			hMap.put("sequenceNumber",sequenceNumber);

			int check = fileBoardDao.fileBoardWriteNumber(hMap);
			HAspect.logger.info(HAspect.logMsg +check);
			fileBoarddto.setSequenceNumber(++sequenceNumber);
			fileBoarddto.setSequenceLevel(++sequenceLevel);

			fileBoarddto.setSequenceNumber(sequenceNumber);
			fileBoarddto.setSequenceLevel(sequenceLevel);
		}
	}

	@Override
	public void fileBoardList(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) {
			pageNumber="1";
		}
		
		int currentPage=Integer.parseInt(pageNumber);
		
		int boardSize=10; // [1] start : 1, end : 10 [2] start : 11, end : 20, ...
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		
		int count=fileBoardDao.fileBoardCount();
		
		HAspect.logger.info(HAspect.logMsg +count);
		
		List<FileBoardDTO> boardlist=null;
		
		if(count>0) {
			// startRow, endRow
			boardlist=fileBoardDao.fileBoardList(startRow,endRow);
			HAspect.logger.info(HAspect.logMsg +boardlist.size());
		}
		
		mav.addObject("boardlist", boardlist);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);
		mav.addObject("count", count);
		
		mav.setViewName("fileBoard/list");
	}

	@Override
	public void fileBoardRead(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		HAspect.logger.info(HAspect.logMsg +boardNumber+"\t"+pageNumber);
		
		FileBoardDTO fileBoardDto = fileBoardDao.fileBoardRead(boardNumber);
		HAspect.logger.info(HAspect.logMsg +fileBoardDto);
		
		if(fileBoardDto.getFileName()!=null) {
			int index = fileBoardDto.getFileName().indexOf("_")+1;
			fileBoardDto.setFileName(fileBoardDto.getFileName().substring(index));
		}
		
		mav.addObject("boarddto", fileBoardDto);
		mav.addObject("pageNumber", pageNumber);
		
		mav.setViewName("fileBoard/read");
	}

	@Override
	public void fileBoardDownLoad(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		//HAspect.logger.info(HAspect.logMsg +boardNumber);
		
		FileBoardDTO fileBoardDto = fileBoardDao.fileBoardSelect(boardNumber);
		HAspect.logger.info(HAspect.logMsg +fileBoardDto);
		
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try {
			int index=fileBoardDto.getFileName().indexOf("_")+1;
			String fName=fileBoardDto.getFileName().substring(index);
			String fileName=new String(fName.getBytes("utf-8"),"ISO-8859-1");
			
			long fileSize=fileBoardDto.getFileSize();
			String path=fileBoardDto.getPath();
			
			response.setHeader("Content-Disposition","attachment;filename="+fileName);
			response.setContentType("application/octet-stream");
			response.setContentLengthLong(fileSize);
		
			bis=new BufferedInputStream(new FileInputStream(path),1024);
			bos=new BufferedOutputStream(response.getOutputStream(),1024);
			
			while(true) {
				int data=bis.read();
				if(data==-1) break;
				
				bos.write(data);
			}
			bos.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis!=null) bis.close();
				if(bos!=null) bos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void fileBoardDelete(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		mav.addObject("boardNumber", boardNumber);
		mav.addObject("pageNumber", pageNumber);
		
		mav.setViewName("fileBoard/delete");
		
	}

	@Override
	public void fileBoardDeleteOk(ModelAndView mav) {
		Map<String, Object>map = mav.getModelMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		String password = request.getParameter("password");
		
		//HAspect.logger.info(HAspect.logMsg+"password: "+password+"\t pageNumber: "+pageNumber+"\t boardNumber: "+boardNumber);
		
		mav.addObject("pageNumber", pageNumber);
		int check = fileBoardDao.fileBoardDelete(password,boardNumber);
		//HAspect.logger.info(HAspect.logMsg+"check: " +check);
		mav.addObject("check", check);
		
		mav.setViewName("fileBoard/deleteOk");
		
	}
	
	
	
	
	
	
	
	
}

