<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${root}/css/member/JoinStyle.css">
		<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
		<script type="text/javascript" src="${root}/javascript/jquery-3.5.1.js"></script>
	</head>
	<body>
		
		<div id="joinForm">
		
			<form name="createForm" action="${root}/member/registerOk.do" method="get" onsubmit="return createFormCheck(this)">
				<div id="title">
					회원가입(*는 필수입력사항)
				</div>
				
				<div id="content" style="height: 290px;">
				
					<!-- 아이디 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px;">
							<label>아이디</label>
						</span>
						
						<span class="userInfo">
							*<input type="text" size="18" name="id">
							<button type="button" onclick="idCheck('${root}')">아이디 중복확인</button>
						</span>
					</div>
					
					<!-- 비밀번호/비밀번호 확인 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>비밀번호</label>
						</span>
						
						<span class="userInfo">
							*<input type="password" size="18" name="password">
						</span>
					</div>
					
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>비밀번호 확인</label>
						</span>
						
						<span class="userInfo">
							*<input type="password" size="18" name="passwordCheck">
						</span>
					</div>
					
					<!-- 이름 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>이름</label>
						</span>
						
						<span class="userInfo">
							*<input type="text" size="18" name="name">
						</span>
					</div>
					
					<!-- 주민번호 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>주민번호</label>
						</span>
						
						<span class="userInfo">
							*<input type="text" size="12" name="jumin1">
							-<input type="text" size="12" name="jumin2">
						</span>
					</div>
					
					<!-- 이메일 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>이메일</label>
						</span>
						
						<span class="userInfo">
							&nbsp;<input type="text" size="30" name="email">
						</span>
					</div>
					
					<!-- 우편번호 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>우편번호</label>
						</span>
						
						<span class="userInfo">
							&nbsp;<input type="text" size="18" name="zipcode">
							<button type="button" onclick="zipcodeSearch('${root}')">우편번호 검색</button>
						</span>
					</div>
					
					<!-- 주소 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>주소</label>
						</span>
						
						<span class="userInfo">
							&nbsp;<input type="text" size="30" name="address">
						</span>
					</div>
					
					<!-- 직업 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>직업</label>
						</span>
						
						<span class="userInfo">
							&nbsp;
							<select name="job" id="job">
								<option value="defalut"></option>
								<option value="개발">개발</option>
								<option value="학생">학생</option>
								<option value="무직">무직</option>
							</select>
							
						</span>
					</div>
					
					
					<!-- 메일 수신 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px">
							<label>메일 수신 여부</label>
						</span>
						
						<span class="userInfo">
							
							<input type="radio" name="mailing" value="yes">Yes
							<input type="radio" name="mailing" value="no">No
						</span>
					</div>
					
					<!-- 관심분야 -->
					<div class="category">		
						<span class="index" style="border-right-width: 0px;border-bottom-width: 1px;">
							<label>관심 분야</label>
						</span>
						
						<span class="userInfo" style="border-bottom-width: 1px;">
							
							<input type="checkbox" value="경제" name="interest">경제
							<input type="checkbox" value="IT" name="interest">IT
							<input type="checkbox" value="음악" name="interest">음악
							<input type="checkbox" value="미술" name="interest">미술
							<input type="checkbox" value="역사" name="interest">역사
							<input type="hidden" name="resultInterest">
						</span>
					</div>
				</div>
	
				<!-- 버튼 -->
				<div id="functions" style="width: 540px;">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
				</div>
	
			</form>
		
		</div>
		
		
	</body>
</html>