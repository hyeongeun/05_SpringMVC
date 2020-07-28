<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
	<c:set var ="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${root}/css/board/readCss.css">
	<script type="text/javascript">
	
	  	function replyFun(root,boardNumber, groupNumber, sequenceNumber, sequenceLevel){
	  		var url= root+"/fileBoard/write.do?boardNumber="+boardNumber;
	  		url += "&groupNumber="+groupNumber +"&sequenceNumber="+sequenceNumber;
	  		url += "&sequenceLevel="+sequenceLevel;
	  		
	  		alert(url);
	  		
	  		location.href = url;
	  	}
	  	
	  	function delFun(root,boardNumber,pageNumber) {

	  		var url=root+"/fileBoard/delete.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
	  		alert(url);
	  		location.href=url;
	  		
// 	  		var value=confirm("삭제하시겠습니까?");
	  		
// 	  		if(value==true) {
// 	  			var url=root+"/board/deleteOk.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
// 	  			location.href = url;
// 	  		}else {
// 	  			alert("취소되었습니다.");
// 	  		}
	  	}
	  	
	  	function updFun(root,boardNumber,pageNumber) {
			var url=root+"/fileBoard/update.do?boardNumber="+boardNumber+"&pageNumber="+pageNumber;
			//alert(url);
			location.href=url;
	  	}
	  	
 	</script>
 </head>
<body>

${boarddto.boardNumber},${boarddto.groupNumber},${boarddto.sequenceNumber},${boarddto.sequenceLevel}
<div id="board">
      <div class="createform">
            <div class="tuple">
               <span class="one">
                  <label class="index">글번호</label>
                 	${boarddto.boardNumber }
               </span>
            </div>
            
                <div class="tuple">
               <span class="one">
                  <label class="index">조회수</label>
                  ${boarddto.readCnt}
               </span>
            </div>
            
                <div class="tuple">
               <span class="one">
                  <label class="index">작성자</label>
                  ${boarddto.writer}
               </span>
            </div>
            
              <div class="tuple">
               <span class="two">
                  <label class="index">작성일</label>
                  <fmt:formatDate value="${boarddto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
               </span>
            </div>

            <div class="tuple">
               <span class="two">
                  <label class="index">제목</label>
                  ${boarddto.subject}
               </span>
            </div>

            <div class="three">
               <label class="index">내용</label>
               ${boarddto.content}
            </div>
            

			<c:if test="${boarddto.fileSize!=0}">
				<div class="three">
	               <label class="index">파일명</label>
	               <a href="${root}/fileBoard/downLoad.do?boardNumber=${boarddto.boardNumber}">${boarddto.fileName}</a>
	            </div>            
			</c:if>
			
            <div class="foot">
            	<input type="button" value="글수정">
            	<!-- input type="button" value="글수정" onclick="updFun('${root}','${boarddto.boardNumber}','${pageNumber}')"/-->
            	<input type="button" value="글삭제" onclick="delFun('${root}','${boarddto.boardNumber}','${pageNumber}')"/>
            	<input type="button" value="답글" onclick="replyFun('${root}','${boarddto.boardNumber}','${boarddto.groupNumber}','${boarddto.sequenceNumber}','${boarddto.sequenceLevel}')"/>
            	<input type="button" value="글목록" onclick="location.href='${root}/fileBoard/list.do?pageNumber=${pageNumber}'"/>
    
            </div>
      </div>
   </div>

</body>
</html>