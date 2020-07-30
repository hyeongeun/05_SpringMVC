<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
	
	<a href="${root}/member/test.do">Spring MVC Start</a>
	
	<c:if test="${memberLevel==null}">
		<a href="${root}/member/register.do">회원가입</a> 
		<a href="${root}/member/login.do">로그인</a>
	</c:if>
	
	<c:if test="${memberLevel!=null}">
		<a href="${root}/member/update.do">회원수정</a>
		<a href="${root}/member/delete.do">회원탈퇴</a> <!-- 세션 종료 -->
		<a href="${root}/member/logout.do">로그아웃</a>
	</c:if>
	<br><br>
	
	<h3>파일게시판</h3>
	<a href="${root}/fileBoard/write.do">파일게시판 쓰기</a><br><br>
	
	<h3>파일게시판</h3>
	<a href="${root}/fileBoard/list.do">파일게시판 목록</a>
	
	
</body>
</html>