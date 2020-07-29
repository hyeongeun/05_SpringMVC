/**
 * 
 */


function createFormCheck(obj) {

//	/* 아이디 */
//	if(obj.id.value=="") {
//		alert("아이디를 반드시 입력하세요.");
//		obj.id.focus();
//		return false;
//	}
//	
//	/* 비밀번호 */
//	if(obj.password.value=="") {
//		alert("비밀번호를 반드시 입력하세요.");
//		obj.password.focus();
//		return false;
//	}
//	
//	if(obj.password.value.length<7) {
//		alert("비밀번호를 7자 이상 입력하세요.");
//		obj.password.focus();
//		return false;
//	}
//	
//	/* 비밀번호 확인 */
//	if(obj.password.value!=obj.passwordCheck.value) {
//		alert("두 비밀번호가 다릅니다.");
//		obj.passwordCheck.focus();
//		return false;
//	}
//	
//	/* 이름 */
//	if(obj.name.value.length<2 || obj.name.value.length>7) {
//		alert("이름을 확인하세요.");
//		obj.name.focus();
//		return false;
//	}
//	
//	/* 주민번호 */
//	if(obj.jumin1.value.length!=6) {
//		alert("주민번호 앞자리를 확인하세요.");
//		obj.jumin1.focus();
//		return false;
//	}
//	
//	if(obj.jumin2.value.length!=7) {
//		alert("주민번호 뒷자리를 확인하세요.");
//		obj.jumin2.focus();
//		return false;
//	}
//	
//	/* 이메일 */
//	if(obj.email.value=="") {
//		alert("이메일을 입력하세요.");
//		obj.email.focus();
//		return false;
//	}
//	
//	if(obj.email.value.indexOf('@')==-1) {
//		alert("이메일 형식을 확인하세요.");
//		obj.email.focus();
//		return false;
//	}
//	
//	/* 우편번호, 주소 */
//	if(obj.zipcode.value=="") {
//		alert("우편번호를 검색하세요.");
//		obj.zipcode.focus();
//		return false;
//	}
//	
//	if(obj.address.value=="") {
//		alert("주소를 입력하세요.");
//		obj.address.focus();
//		return false;
//	}
//	
//	/* 직업 */
//	if(obj.job.value=="default") {
//		alert("직업을 선택하세요.");
//		return false;
//	}
//	
//	/* 메일 수신 여부 */
//	var check=false;
//	for(var i=0;i<obj.mailing.length;i++){
//		if(obj.mailing[i].checked==true) check=true;
//	}
//	if(check==false){
//		alert("메일 수신 여부 선택하세요.");
//		return false;
//	}
//	
//	/* 관심분야 */
	check=false;
	var str="";
	for(var i=0;i<obj.interest.length;i++) {
		if(obj.interest[i].checked==true) {
			str += obj.interest[i].value+",";
			check=true;
		}
	}
	//alert(str);
	obj.resultInterest.value=str;

	if(check==false){
		alert("관심사를 하나 이상 선택하세요.");
		return false;
	}
}

function idCheck(root) {	// this를 받으면 안된다. this는 button
	//alert(root);
	if($("input[name='id']").val()==""){
		alert("아이디를 입력하세요");
		
		$("input[name='id']").focus();
		
		return false;
	}
	
	var url = root + "/member/idCheck.do?id="+$("input[name='id']").val();
	//alert(url);
	
	window.open(url,"","width=250, height=150");
	
	

}

function zipcodeSearch(root) {
	var url=root+"/member/zipcode.do";
	//alert(url);
	window.open(url,"","width=550, height=600, scrollbars=yes");
}


function sendAddress(zipcode,sido,gugun,dong,ri,bunji) {
	
	var address=sido+" "+gugun+" "+dong+" "+ri+" "+bunji;
	// alert(zipcode+"\n"+address);

	//opener.createForm.zipcode.value=zipcode;
	//opener.createForm.address.value=address;
	
	$(opener.document).find("input[name='zipcode']").val(zipcode);
	$(opener.document).find("input[name='address']").val(address);
	
	self.close();
}














