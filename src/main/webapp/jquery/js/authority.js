/* 신규 권한 */
// userGroupId : 사용자의 권한 아이디
// secuGroupId : 신규버튼의 권한 값
// imgName : 신규버튼이미지의 아이디
function privNew(userGroupId, secuGroupId, imgName){
	if(secuGroupId == userGroupId){
		document.getElementById(imgName).style.display = "block";
	}else{
		document.getElementById(imgName).style.display = "none";
	}
}


/* 저장 권한 */
// userGroupId : 사용자의 권한 아이디
// secuGroupId : 저장버튼의 권한 값
// imgName : 저장버튼이미지의 아이디
function privSave(userGroupId, secuGroupId, imgName){
	if(secuGroupId == userGroupId){
		document.getElementById(imgName).style.display = "block";
	}else{
		document.getElementById(imgName).style.display = "none";
	}
}


/* 수정 권한 */
// userGroupId : 사용자의 권한 아이디
// secuGroupId : 수정버튼의 권한 값
// imgName : 수정버튼이미지의 아이디
function privModify(userGroupId, secuGroupId, imgName){
	if(secuGroupId == userGroupId){
		document.getElementById(imgName).style.display = "block";
	}else{
		document.getElementById(imgName).style.display = "none";
	}
}


/* 조직선택 권한 */
// userGroupName : 사용자의 그룹명
// userGroupId : 사용자의 그룹 아이디
// privName : 조직선택의 권한 값
// imgName : 조직선택 검색버튼 이미지의 아이디 
// strGroupName : 페이지 검색조건의 input 박스 아이디(그룹명)
// strGroupId : 페이지 검색조건의 input 박스 아이디(그룹아이디)
function privSelGroup(userGroupName, userGroupId, privName, imgName, strGroupName, strGroupId){
	if(privName == "group"){
		document.getElementById(imgName).value = "group";
	}else if(privName == "all"){
		document.getElementById(imgName).value = "all";
	}else{                                               //own
		document.getElementById(imgName).value = "own";
		document.getElementById(strGroupName).value = userGroupName;		
		document.getElementById(strGroupId).value = userGroupId;
		document.getElementById(strGroupName).readOnly = true;
		document.getElementById(strGroupId).readOnly = true;
		document.getElementById(strGroupName).className= "search_text_gray";
		document.getElementById(strGroupId).className= "search_text_gray";
		document.getElementById(strGroupName).setAttribute("onkeyup",function() {});	
		document.getElementById(strGroupId).setAttribute("onkeyup",function() {});
	}
}


/* 조직도 권한 */
// privName : 조직도의 권한 값
// imgName : 조직선택 검색버튼 이미지의 아이디 
function privGroupPop(privName, imgName){
	if(privName == "group"){
		document.getElementById(imgName).value = "group";
	}else if(privName == "all"){
		document.getElementById(imgName).value = "all";
	}else{                                                  //own
		document.getElementById(imgName).value = "own";
	}		
}


/* 사용자선택 권한 */
// userName : 사용자의 이름
// userLoginString : 사용자의 로그인스트링
// privName : 사용자선택의 권한 값
// imgName : 사용자선택 검색버튼 이미지의 아이디 
// strUserName : 페이지 검색조건의 input 박스 아이디(사용자명)
// strUserLoginString : 페이지 검색조건의 input 박스 아이디(사용자 로그인스트링)
function privSelUser(userName, userLoginString, privName, imgName, strUserName, strUserLoginString){
	if(privName == "group"){
		document.getElementById(imgName).value = "group";	
	}else if(privName == "all"){
		document.getElementById(imgName).value = "all";
	}else{                                                    //own
		document.getElementById(imgName).value = "own";
		document.getElementById(strUserName).value = userName;		
		document.getElementById(strUserLoginString).value = userLoginString;
		document.getElementById(strUserName).readOnly = true;
		document.getElementById(strUserLoginString).readOnly = true;
		document.getElementById(strUserName).className= "search_text_gray";
		document.getElementById(strUserLoginString).className= "search_text_gray";
		document.getElementById(strUserName).setAttribute("onkeyup",function() {});	
		document.getElementById(strUserLoginString).setAttribute("onkeyup",function() {});
	}	
}


/* 감청 권한 */
// userGroupId : 사용자의 권한 아이디
// secuGroupId : 비밀번호 초기화 버튼의 권한 값
// divId : 비밀번호 초기화 버튼의 DIV 아이디
function privListen(userGroupId, secuGroupId, divId){
	if(secuGroupId == userGroupId){
		document.getElementById(divId).style.display = "block";
	}else{
		document.getElementById(divId).style.display = "none";
	}	
}


/* 감청 권한 */
// userGroupId : 사용자의 권한 아이디
// secuGroupId : 감청버튼의 권한 값
// divId : 감청버튼의 DIV 아이디
function privListen(userGroupId, secuGroupId, divId){
	if(document.getElementById(divId) != null){
		if(secuGroupId == userGroupId){
			document.getElementById(divId).style.display = "block";
		}else{
			document.getElementById(divId).style.display = "none";
		}
	}
}


/* 녹취다운(선택), 녹취다운(전체), EXCEL(선택), EXCEL(전체) 권한 */
// userId : 사용자의 권한 아이디
// privButtonId : 버튼의 권한 값
// imgName : 이미지의 아이디
function privTopButton(userId, privButtonId, imgName){
	if(document.getElementById(imgName) != null){
		if(userId == privButtonId){
			// 익스플로러 높은 버전에서는 동작하지 않아서 jquery 로 변경 2014.06.12 김정원
			//document.getElementById(imgName).style.display = "block";
			$("#"+imgName).show();
		}else{
			//document.getElementById(imgName).style.display = "none";
			$("#"+imgName).hide();
		}
	}
}


/* 굿콜지정 권한 */
// id : 권한의 설정 여부
// name : 굿콜 체크박스의 name
function privChooseGoodCall(id,name){
	// 굿콜지정 권한이 ALL, GROUP, OWN 이 설정 되지 않다면 모든 체크박스를 disabled
	if(id == ""){
		for(var i=0; i<document.getElementsByName(name).length; i++){
			document.getElementsByName(name)[i].disabled = true;
		}
	}
}