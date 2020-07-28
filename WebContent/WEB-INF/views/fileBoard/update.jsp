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
</head>
<body>

	<div id="board">

		<div class="createform">

			<form action="${root}/fileBoard/updateOk.do" method="post">
			
				<input type="hidden" name="pageNumber" value="${pageNumber}">
				<input type="hidden" name="boardNumber" value="${boarddto.boardNumber}">
				
				<div class="tuple">
					<span class="one"> 
						<label class="index">작성자</label> 
						<input class="content" type="text" name="writer" value="${boarddto.writer}" />
					</span>
				</div>

				<div class="tuple">
					<span class="two"> 
						<label class="index">제목</label> 
						<input class="content" type="text" name="subject" value="${boarddto.subject}"/>
					</span>
				</div>

				<div class="tuple">
					<span class="two"> <label class="index">이메일</label> 
					<input class="content" type="text" name="email" value="${boarddto.email}"/>
					</span>
				</div>

				<div class="three">
					<label class="index">내용</label>
					<textarea class="content" name="content">${boarddto.content}</textarea>
				</div>
				
				<div class="tuple">
					<span class="one"> 
						<label class="index">파일명</label> 
						<input class="content" type="file" name="file" value="${boarddto.fileName}" />
					</span>
				</div>

				<div class="tuple">
					<span class="one"> <label class="index">비밀번호</label> <input
						class="content" type="password" name="password"/>
					</span>
				</div>

				<div class="foot">
					<input type="submit" value="수정하기"/>
					<input type="button" value="목록보기" onclick="location.href='${root}/fileBoard/list.do?pageNumber=${pageNumber}'" />
				</div>
			</form>
		</div>
	</div>


</body>
</html>