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
	
	<div align="center">
		<form method="post" action="${root}/fileBoard/deleteOk.do">
		
			<input type="hidden" name="boardNumber" value="${boardNumber}">
			<input type="hidden" name="pageNumber" value="${pageNumber}">
			
			
			<div>비밀번호를 입력해주세요.</div><br>
			<div>
				<input type="password" name="password">
			</div><br>
			
			<div>
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onclick="location.href='${root}/fileBoard/list.do?pageNumber=${pageNumber}'">
			</div>
		</form>
	</div>	
	
</body>
</html>