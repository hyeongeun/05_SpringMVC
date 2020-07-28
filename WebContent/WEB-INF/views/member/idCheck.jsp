<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${root}/css/member/idCheckStyle.css">
	</head>
	
	<body>

		
		<c:if test="${check!=0}">
			<div id="impossible" align="center">
				<span>이미 사용중인 아이디입니다.</span><br><br>
				<form action="${root}/member/idCheck.do" method="get">
					<input type="text" name="id">
					<input type="submit" value="확인">
				</form>
			</div>
		</c:if>
		
		<c:if test="${check==0}">
			<div id="possible" align="center">
			<span>사용 가능한 아이디입니다.</span></div>
			
			<script type="text/javascript">
				opener.createForm.id.value="${id}";
			</script>
		</c:if>
		<br>
		
		<div id="closeBtn">
			<a href="javascript:self.close()">닫기</a>
		</div>
		
	</body>
</html>