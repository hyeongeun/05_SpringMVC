<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	
	<c:set var="root" value="${pageContext.request.contextPath}"/>

	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${root}/javascript/member/util.js"></script>
	</head>
	
	<body>
		<jsp:include page="../../../index.jsp"></jsp:include><br><br>
		<div align="center">
			<form action="${root}/member/loginOk.do" method="post" onsubmit="return idCheckFunc(this)">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="로그인">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>
			
			</form>
		</div>
		
	</body>
</html>