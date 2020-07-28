<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>	

	<c:set var="root" value="${pageContext.request.contextPath}"/>

	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${root}/css/member/zipStyle.css">
		<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
	</head>
	
	<body>

		<form action="${root}/member/zipcode.do" method="post">
			<div align="center">
				<table>
					<tr>
						<td id="title">우편번호를 검색하세요.</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="dong">
							<input type="submit" value="검색">
						</td>
					</tr>
				</table>
			</div>
		</form>
		<br><br>
		
		<div align="center">
			<table>
			
				<c:choose>
					<c:when test="${zipcodelist.size()==0}">
						<tr>
							<td>검색된 결과가 없습니다.</td>
						</tr>
					</c:when>
					
					<c:when test="${zipcodelist.size()>0}">
						<tr>
							<td id="listHeader">아래 우편번호를 클릭하세요.<br></td>
						</tr>
						
						<c:forEach var="zipdto" items="${zipcodelist}">
							<tr>
								<td id="list">
									<a href="javascript:sendAddress('${zipdto.zipcode}', '${zipdto.sido}', '${zipdto.gugun}', '${zipdto.dong}', '${zipdto.ri}', '${zipdto.bunji}')">
									${zipdto.zipcode}
									${zipdto.sido}
									${zipdto.gugun}
									${zipdto.dong}
									${zipdto.ri}
									${zipdto.bunji}
									</a>
								</td>							
							</tr>
						</c:forEach>
					</c:when>
				</c:choose> 
			</table>
		</div>
	</body>
</html>