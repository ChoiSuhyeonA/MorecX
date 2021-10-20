
//로그아웃 처리
//flag :  button -> 로그아웃버튼 클릭
//        sessionclose -> 세션체크
//        close -> onunload(창닫힘)
function logoutInit(flag) {
	var logout_clicked;
	//var userId=top.topFrame.document.getElementById("hidUserId").value;
	//alert(top.topFrame.document.getElementById("hidUserId").value);
	if(flag == 'button') {
	//	var ans = confirm("로그아웃 하시겠습니까?");
		
		if(ans == 1) {
			logout_clicked = true;
			top.location.href="./logout.action";
		} else { return; }	
	} else if(flag == 'sessionClose') {
		logout_clicked = false;
		//top.location.href="/logout.action?strUserID="+userId;
		//top.self.close();
		//top.location.href = "../initLogin.action";
		top.location.href = "../";
	}else if(flag == 'close' && logout_clicked != true) {
		//alert("로그아웃 합니다.");
		logout_clicked = false;
		
		var logoutPop="./logout_ok.jsp?strUserID="+userId;
		var popLogout = window.open(logoutPop,'','top=0, left=0, width=250px, height=83px, menubar=no, toolbar=no, location=no, status=yes, scrollbars=no');
	} else if(flag == 'sessionCloseCommon') {
		logout_clicked = false;		
		//top.location.href = "./initLogin.action";
		top.location.href = "./";
	}
	
}

// 세션 확인 - 세션이 존재하지 않으면 로그아웃(common용 경로문제로 인해)
// strSession : user_id
// logout_js : 일정한 시간동안 사용하지 않아 로그아웃 합니다. 라는 메시지
// logout_js_retry : 다시 로그인 해주세요. 라는 메시지
function checkSessionCommon(strSession, logout_js, logout_js_retry) {
	if(top.topFrame!="[object]"){
		location.href="./loginCheck.jsp";
		return;
	}
	if(strSession==""){
		//alert("일정한 시간동안 사용하지 않아 로그아웃 합니다.  \n\n             다시 로그인 해주세요.");
		alert(logout_js + "  \n\n             " + logout_js_retry);
		//alert('<s:text name="message.sessionTimeOut"/>');
		logoutInit('sessionCloseCommon');
		return;
	}
}

// 세션 확인 - 세션이 존재하지 않으면 로그아웃
// strSession : user_id
// logout_js : 일정한 시간동안 사용하지 않아 로그아웃 합니다. 라는 메시지
// logout_js_retry : 다시 로그인 해주세요. 라는 메시지
function checkSession(strSession, logout_js, logout_js_retry) {
	/*
	if(top.topFrame!="[object]"){
		location.href="../loginCheck.jsp";
		return;
	}
	*/
	if(strSession==""){
		//alert("일정한 시간동안 사용하지 않아 로그아웃 합니다.  \n\n             다시 로그인 해주세요.");
		alert(logout_js + "  \n\n             " + logout_js_retry);
		//alert('<s:text name="message.sessionTimeOut"/>');
		logoutInit('sessionClose');
		return;
	}
}

/* 페이징 시 표시하는 데이터 카운트 정보 표시 */ 
/* tgtObj : 표시할 타겟 오브젝트 */ 
/* curPage : 현재 페이지 넘버 */ 
/* totalPage : 전체 페이지 갯수 */
/* dataCnt : 전체 데이터 카운트 */ 
/* totalUnit : 0 / 0 (전체 0 건) 이란 메시지*/
/* total : 전체 라는 메시지*/
/* unit : 건 이라는 메시지*/
function displayPageCount(tgtObj, curPage, totalPage, dataCnt, totalUnit, total, unit){
	if (dataCnt == 0) {
		tgtObj.innerHTML = totalUnit;
	} else {
		tgtObj.innerHTML = commercialComma(curPage) + " / " + commercialComma(totalPage) + " (" + total +" " + commercialComma(dataCnt) + unit + ")";
	}
}

/* 초 정보를 HH:MM:SS 로 표시 */ 
/* inTime : 초 */ 
function convertDuration(inTime)
{
	var returnTime ="00:00:00";
	if (inTime != "")
	{
		if (parseInt(inTime)!= 0)
		{
			var hour = parseInt(inTime / 3600);
			var minute = parseInt(inTime % 3600 / 60);
			var second = parseInt(inTime % 60);
			
			if (hour < 10){
				hour = "0" + hour.toString();
			}
			if (minute < 10){
				minute = "0" + minute.toString();
			}
			if (second < 10){
				second = "0" + second.toString();
			}
			returnTime = hour+":"+minute+":"+second;

		}else{
			returnTime = "00:00:00";
		}
	}
	return returnTime;
}

/* 일시 정보를 자리수 맞춤 */ 
/* inTime : timestamp */ 
function convertTimeStamp(inTime)
{
	var returnTime ="";
	if (inTime != "")
	{
		if (inTime.length > 20) 
		{
			returnTime = inTime.substr(0,19);
		}
	}
	return returnTime;
}

/* 센터 콤보를 선택하면 팀 콤보가 바뀌는 공통모듈 */ 
function getComboTeamName(selectComboName){
	var strUrl = "strSelectCenterName="+document.getElementById(selectComboName).value;
	var strReturnValue = getXMLHttpRequestXML("../getComboTeamName.action",strUrl);	
	document.getElementById(selectComboName).options.length = 0;
	var strResult = strReturnValue.getElementsByTagName("Result")[0];		
	var arrSize = strResult.getElementsByTagName("arrSize")[0].firstChild.nodeValue;		
	for (var i=0; i<arrSize; i++){
		document.getElementById(selectComboName).options.add(new Option(strResult.getElementsByTagName("combo"+i)[0].childNodes[1].firstChild.nodeValue, strResult.getElementsByTagName("combo"+i)[0].childNodes[0].firstChild.nodeValue));
	}
	/*
	if(document.getElementById("hidUserGrade").value != ""){
		document.getElementById(selectComboName).value = document.getElementById("hidUserGrade").value;
	}
	*/	
}	

/* 팝업창을 가운데에 띄우는 모듈 */ 
function centerPop(width, height){
	var arrValue = [];	
	arrValue[0] = (screen.height - height) / 2 ; //TOP
	arrValue[1] = (screen.width - width) / 2 ;   //LEFT	
	return arrValue;
}





/* 권한조직 검색 공통모듈 */ 
function searchAccesspolicy(code, type, strGroupName, strGroupId){
	if(code == "13"){
		if(eval("document.getElementById('" + strGroupName +"')").value != "" && eval("document.getElementById('" + strGroupId +"')").value != ""){
			if(!document.getElementById("btn_search").disabled){
				search();
			}
				return;
		}
	}
	
	if(code == "0"){
		var obj1 = eval("document.getElementById('" + strGroupName +"')");
		var obj2 = eval("document.getElementById('" + strGroupId +"')");
		var searchType = "";
		var searchText = "";	
		var objParam= new Object();
		objParam.OPENER = window;
		objParam.strSearchText = searchText;        //검색 텍스트
		objParam.strSearchType = searchType;        //그룹명검색인지 그룹아이디 검색인지
		objParam.strGroupName = "";  				//검색 그룹 이름
		objParam.strGroupId = "";    				//검색 그룹 아이디
		objParam.strGroupNameParam = strGroupName;  //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
		objParam.strGroupIdParam = strGroupId;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
		
		var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
		var winSearchBranch = window.showModalDialog("../searchAccesspolicyPop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
	
	}else if(code == "13" || code == ""){
		var obj1 = eval("document.getElementById('" + strGroupName +"')");
		var obj2 = eval("document.getElementById('" + strGroupId +"')");
		var searchType = "";
		var searchText = "";	
	
		if (obj1.value != "" && obj2.value != ""){
			searchType = "strGroupName";
			searchText = "";
		}
		else if (obj1.value != ""){
			searchType = "strGroupName";
			searchText = obj1.value;
		}
		else if (obj2.value != ""){
			searchType = "strGroupId";
			searchText = obj2.value;
		} else {
			searchType = "strGroupName";
			searchText = obj1.value;
		}
	
		var strUrl = "strSearchText=" + searchText 
				+ "&strSearchType=" + searchType; 
	
		var strReturnValue = getXMLHttpRequestXML("../searchAccesspolicy.action",strUrl);		
		var strResult = strReturnValue.getElementsByTagName("Result")[0];		
		var resultVal = strResult.getElementsByTagName("resultVal")[0].firstChild.nodeValue;
		
		if(resultVal == -1){
			var errorVal = strResult.getElementsByTagName("idVal")[0].firstChild.nodeValue;
			alert(errorVal);
		}
		else if(resultVal != 1){
			var objParam= new Object();
			objParam.OPENER = window;
			objParam.strSearchText = searchText;        //검색 텍스트
			objParam.strSearchType = searchType;        //그룹명검색인지 그룹아이디 검색인지
			objParam.strGroupName = obj1;  				//검색 그룹 이름
			objParam.strGroupId = obj2;    				//검색 그룹 아이디
			objParam.strGroupNameParam = strGroupName;  //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
			objParam.strGroupIdParam = strGroupId;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
			
			var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
			var winSearchBranch = window.showModalDialog("../searchAccesspolicyPop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
			
		}else {
			var strGroupIdTag = strResult.getElementsByTagName("arr0")[0].firstChild.nodeValue;
			var strGroupNameTag = strResult.getElementsByTagName("arr1")[0].firstChild.nodeValue;		
			
			eval("document.getElementById('" + strGroupName +"')").value = strGroupNameTag;
			eval("document.getElementById('" + strGroupId +"')").value = strGroupIdTag;
		
		}
	}else if (code != "229"){
		if(type == strGroupName) {document.all(strGroupId).value = ""; }
			else {document.all(strGroupName).value = ""; }
	}
}

/* 사용인 선택 검색 공통모듈 */ 
function selSearchUser(strUserName, strUserId){
	
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strUserNameParam = strUserName;    //팝업창 화면에서 선택한 사용자명을 어디 변수로 넣을지
	objParam.strUserIdParam = strUserId;        //팝업창 화면에서 선택한 로그인스트링을 어디 변수로 넣을지
	
	var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
	var winSearchBranch = window.showModalDialog("../selSearchUserPop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');

}

/* 메모 팝 공통모듈 */ 
function popMemo(recId){
	var url = "?strRecId=" + recId;
	var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
	var memoPopSize = parseInt(top.topFrame.document.getElementById("explorerVer").value) + 45;
	var winSearchBranch = window.showModalDialog("../selectMemoPop.action" + url, '', ' dialogWidth:480px; dialogHeight:'+memoPopSize+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
}

/* 마스터코드 검색 공통모듈 */ 
function searchMasterCode(code, type, strCodeName, strCodeId){
	if(code == "13"){
		if(eval("document.getElementById('" + strCodeName +"')").value != "" && eval("document.getElementById('" + strCodeId +"')").value != ""){
			if(!document.getElementById("btn_search").disabled){
				code_left_main.search();
			}
			return;
		}
	}
	
	if(code == "0"){
		var obj1 = eval("document.getElementById('" + strCodeName +"')");
		var obj2 = eval("document.getElementById('" + strCodeId +"')");
		var searchType = "";
		var searchText = "";	
		var objParam= new Object();
		objParam.OPENER = window;
		objParam.strSearchText = searchText;        //검색 텍스트
		objParam.strSearchType = searchType;        //마스터코드명검색인지 마스터코드아이디 검색인지
		objParam.strCodeName = "";  				//검색 마스터코드명
		objParam.strCodeId = "";    				//검색 마스터코드아이디
		objParam.strCodeNameParam = strCodeName;    //팝업창 화면에서 선택한 마스터코드명을 어디 변수로 넣을지
		objParam.strCodeIdParam = strCodeId;        //팝업창 화면에서 선택한 마스터코드아이디를 어디 변수로 넣을지
		
		var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
		var winSearchBranch = window.showModalDialog("../searchMasterCodePop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
		
	}else if(code == "13" || code == ""){	
		var obj1 = eval("document.getElementById('" + strCodeName +"')");
		var obj2 = eval("document.getElementById('" + strCodeId +"')");
		var searchType = "";
		var searchText = "";	
	
		if (obj1.value != "" && obj2.value != ""){
			searchType = strCodeName;
			searchText = "";
		}
		else if (obj1.value != ""){
			searchType = "strCodeName";
			searchText = obj1.value;
		}
		else if (obj2.value != ""){
			searchType = "strCodeId";
			searchText = obj2.value;
		} else {
			searchType = "strCodeName";
			searchText = obj1.value;
		}
	
		var strUrl = "strSearchText=" + searchText
				+ "&strSearchType=" + searchType; 
	
		var strReturnValue = getXMLHttpRequestXML("../searchMasterCode.action",strUrl);		
		var strResult = strReturnValue.getElementsByTagName("Result")[0];		
		var resultVal = strResult.getElementsByTagName("resultVal")[0].firstChild.nodeValue;
		
		if(resultVal == -1){
			var errorVal = strResult.getElementsByTagName("idVal")[0].firstChild.nodeValue;
			alert(errorVal);
		}
		else if(resultVal != 1){
			var objParam= new Object();
			objParam.OPENER = window;
			objParam.strSearchText = searchText;        //검색 텍스트
			objParam.strSearchType = searchType;        //마스터코드명검색인지 마스터코드아이디 검색인지
			objParam.strCodeName = obj1;  				//검색 마스터코드명
			objParam.strCodeId = obj2;    				//검색 마스터코드아이디
			objParam.strCodeNameParam = strCodeName;    //팝업창 화면에서 선택한 마스터코드명을 어디 변수로 넣을지
			objParam.strCodeIdParam = strCodeId;        //팝업창 화면에서 선택한 마스터코드아이디를 어디 변수로 넣을지
			
			var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
			var winSearchBranch = window.showModalDialog("../searchMasterCodePop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
			
		}else {
			var strCodeIdTag = strResult.getElementsByTagName("arr0")[0].firstChild.nodeValue;
			var strCodeNameTag = strResult.getElementsByTagName("arr1")[0].firstChild.nodeValue;		
			
			eval("document.getElementById('" + strCodeName +"')").value = strCodeNameTag;
			eval("document.getElementById('" + strCodeId +"')").value = strCodeIdTag;	
			}
	}else if (code != "229"){
		if(type == strCodeName) {document.all(strCodeId).value = ""; }
			else {document.all(strCodeName).value = ""; }
	}
	
}

function groupTree(groupName, groupSeq, depth, systemPath, pageType){
	var objParam= new Object();
	objParam = window;
	objParam.strGroupNameParam = groupName;    //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
	objParam.strGroupSeqParam = groupSeq;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
	objParam.strDepthParam = depth;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
	objParam.strPageType = pageType;
    
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);  
	 
	if(br_info_num >= 8){			
		var arrValue = centerPop("400", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"groupTreePopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("400", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"groupTreePopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}

function groupUserTree(groupName, groupSeq, depth, systemPath){
	var objParam= new Object();
	objParam = window;
	objParam.strGroupNameParam = groupName;    //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
	objParam.strGroupSeqParam = groupSeq;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
	objParam.strDepthParam = depth;      //팝업창 화면에서 선택한 그룹아이디를 어디 변수로 넣을지
    	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);  
	 
	if(br_info_num >= 8){			
		var arrValue = centerPop("400", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"groupUserTreePopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("400", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"groupUserTreePopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}

function getSum(value1, value2){
	var returnValue = 0;
	if (value1 != "" && value2 != "") {
		var returnValue = parseInt(value1) +  parseInt(value2);
	}
	return returnValue;
}

//숫자만 입력했는지 검사하는 함수
function chkOnlynumber(instring) 
{
	var ic;
	var result = true;
	var charpnum = null;
	
		for (ic=0; ic<instring.length; ic++)
		{
			charpnum = instring.substr(ic,1);
			if (charpnum.charCodeAt(0) < 48 || charpnum.charCodeAt(0) > 57) 
			{
				return false;
			}
		}
		return true;
}


// 클릭시에 Line 색상 변경
var old_tr_id = "";
var old_tr_bgcolor = "";
var sel_tr_id = "";
function mouseOverLine(tr_id) 
{	
	if(document.getElementById("tr_"+tr_id).style.backgroundColor != "#ffffff") {
		old_tr_bgcolor = document.getElementById("tr_" + tr_id).style.backgroundColor;
		//document.getElementById("tr_" + tr_id).style.backgroundColor = "#74a5b3";
		document.getElementById("tr_" + tr_id).style.backgroundColor = "#EEF7FA";
		old_tr_id = tr_id;
	}
	
} // Ends the "changeLine" function

function mouseOutLine(tr_id) 
{	
	if(document.getElementById("tr_"+tr_id).style.backgroundColor != "#E0F5F5") {
	//if(document.getElementById("tr_"+tr_id).style.backgroundColor != "#ffffff") {
		document.getElementById("tr_" + tr_id).style.backgroundColor = old_tr_bgcolor;
		old_tr_id = tr_id;
	}
} 

//라인선택
function selectLine(tr_id){		
	if (sel_tr_id != ""){
		document.all["tr_" + sel_tr_id].style.backgroundColor =old_tr_bgcolor;
	}
	//document.all["tr_" + tr_id].style.backgroundColor ="#ffffff";
	document.all["tr_" + tr_id].style.backgroundColor ="#E0F5F5";
	sel_tr_id = tr_id;

}

//클릭시에 Line 색상 변경(통계페이지 - 리스트가 두개의 테이블로 이루어진 경우 호출함)
//tr 의 id 는 왼쪽테이블은 tr_1L, 오른쪽 테이블은 tr_1R 형태로 함
//사용예 - changeLine2('true', '1L');
var old_tr_id2 = "";
var old_tr_bgcolor2 = "";
function selectLine2(tr_id) 
{
		tr_id = tr_id.substring(0, tr_id.length - 1);	//마지막 L/R 제거
		
		if(old_tr_id2 != "") {
			document.getElementById("tr_" + old_tr_id2 + "L").style.backgroundColor = "#ffffff";
			document.getElementById("tr_" + old_tr_id2 + "R").style.backgroundColor = "#ffffff";
		}
		
		old_tr_bgcolor2 = document.getElementById("tr_" + tr_id + "L").style.backgroundColor;
		old_tr_bgcolor2 = document.getElementById("tr_" + tr_id + "R").style.backgroundColor;
		document.getElementById("tr_" + tr_id + "L").style.backgroundColor = "#fef1de";
		document.getElementById("tr_" + tr_id + "R").style.backgroundColor = "#fef1de";
		old_tr_id2 = tr_id;
}

// 클릭시에 Line 색상 변경(가로 스크롤 고정)
function mouseOverLineFix(tr_id) 
{	
	if(document.getElementById("tr1_"+tr_id).style.backgroundColor != "#ffffff") {
		old_tr_bgcolor = document.getElementById("tr1_" + tr_id).style.backgroundColor;
		//document.getElementById("tr_" + tr_id).style.backgroundColor = "#74a5b3";
		document.getElementById("tr1_" + tr_id).style.backgroundColor = "#cad9dd";
		document.getElementById("tr2_" + tr_id).style.backgroundColor = "#cad9dd";
		old_tr_id = tr_id;
	}
	
} // Ends the "changeLine" function

function mouseOutLineFix(tr_id) //(가로 스크롤 고정)
{	
	if(document.getElementById("tr1_"+tr_id).style.backgroundColor != "#74a5b3") {
	//if(document.getElementById("tr_"+tr_id).style.backgroundColor != "#ffffff") {
		document.getElementById("tr1_" + tr_id).style.backgroundColor = old_tr_bgcolor;
		document.getElementById("tr2_" + tr_id).style.backgroundColor = old_tr_bgcolor;
		old_tr_id = tr_id;
	}
} 

//라인선택(가로 스크롤 고정)
function selectLineFix(tr_id){		
	if (sel_tr_id != ""){
		document.all["tr1_" + sel_tr_id].style.backgroundColor =old_tr_bgcolor;
		document.all["tr2_" + sel_tr_id].style.backgroundColor =old_tr_bgcolor;
	}
	//document.all["tr_" + tr_id].style.backgroundColor ="#ffffff";
	document.all["tr1_" + tr_id].style.backgroundColor ="#74a5b3";
	document.all["tr2_" + tr_id].style.backgroundColor ="#74a5b3";
	sel_tr_id = tr_id;
}

function tableScrolling() {
 	document.getElementById('nonScrollTable').scrollTop = document.getElementById('scrollTable').scrollTop;
 	document.getElementById('topTable').scrollLeft = document.getElementById('scrollTable').scrollLeft;
}


//상세정보의 신규, 저장, 수정의 이미지 변화
function btnSet(value){
	//alert(top.topFrame.document.getElementById("hidBtnSave").value.substr(1,top.topFrame.document.getElementById("hidBtnSave").value.length));
	if(value == 1){																	//처음 페이지 로딩시, 조회, 저장, 수정
		document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSaveDisabled").value;
		document.getElementById("ImgSave").style.cursor = "default";
		document.getElementById("ImgSave").disabled = true;
		document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModifyDisabled").value;
		document.getElementById("ImgModify").style.cursor = "default";
		document.getElementById("ImgModify").disabled = true;	
	}else if(value == 2){															//신규버튼 눌렀을 때
		document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSave").value;
		document.getElementById("ImgSave").style.cursor = "hand";
		document.getElementById("ImgSave").disabled = false;
		document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModifyDisabled").value;
		document.getElementById("ImgModify").style.cursor = "default";
		document.getElementById("ImgModify").disabled = true;	
	}else if(value == 3){                                       					//리스트를 클릭했을 때
		parent.document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSaveDisabled").value;
		parent.document.getElementById("ImgSave").style.cursor = "default";
		parent.document.getElementById("ImgSave").disabled = true;
		parent.document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModify").value;
		parent.document.getElementById("ImgModify").style.cursor = "hand";
		parent.document.getElementById("ImgModify").disabled = false;	
	}

}

//상세정보의 신규, 저장, 수정의 이미지 변화(경로 변경 ../ -> ./)
function btnSetCommon(value){
	if(value == 1){																	//처음 페이지 로딩시, 조회, 저장, 수정
		document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSaveDisabled").value.substr(1,top.topFrame.document.getElementById("hidBtnSaveDisabled").value.length);
		document.getElementById("ImgSave").style.cursor = "default";
		document.getElementById("ImgSave").disabled = true;
		document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModifyDisabled").value.substr(1,top.topFrame.document.getElementById("hidBtnModifyDisabled").value.length);
		document.getElementById("ImgModify").style.cursor = "default";
		document.getElementById("ImgModify").disabled = true;	
	}else if(value == 2){															//신규버튼 눌렀을 때
		document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSave").value.substr(1,top.topFrame.document.getElementById("hidBtnSave").value.length);
		document.getElementById("ImgSave").style.cursor = "hand";
		document.getElementById("ImgSave").disabled = false;
		document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModifyDisabled").value.substr(1,top.topFrame.document.getElementById("hidBtnModifyDisabled").value.length);
		document.getElementById("ImgModify").style.cursor = "default";
		document.getElementById("ImgModify").disabled = true;	
	}else if(value == 3){                                       					//리스트를 클릭했을 때
		parent.document.getElementById("ImgSave").src = top.topFrame.document.getElementById("hidBtnSaveDisabled").value.substr(1,top.topFrame.document.getElementById("hidBtnSaveDisabled").value.length);
		parent.document.getElementById("ImgSave").style.cursor = "default";
		parent.document.getElementById("ImgSave").disabled = true;
		parent.document.getElementById("ImgModify").src = top.topFrame.document.getElementById("hidBtnModify").value.substr(1,top.topFrame.document.getElementById("hidBtnModify").value.length);
		parent.document.getElementById("ImgModify").style.cursor = "hand";
		parent.document.getElementById("ImgModify").disabled = false;	
	}

}


// 두 날짜의 일수 차이 구하기
function getDateInterval(startDate, endDate){
	var d1 = new Date(startDate.substring(0,4), startDate.substring(5,7), startDate.substring(8,10));
	var d2 = new Date(endDate.substring(0,4), endDate.substring(5,7), endDate.substring(8,10));
	var returnVal = (d1.getTime() - d2.getTime())/(1000*60*60*24);
	return returnVal;
}


// 3자리 콤마(금액 등의 숫자)
// str : 숫자
// return : 금액(1,000,000)
function commercialComma(str){
	
	if (str == ""){
		return "";
	}
	if (str == 0){
		return "0";
	}
	str.toString();
	var tempValue = str.split(".");
	var newValue = tempValue[0] + "";
	
	var len = newValue.length;  
	var ch="";
	var j=1;
	var formatValue="";
	var minusFlag = false;
	newValue = newValue.replace(/\,/gi, ' ');
	if (parseInt(newValue) < 0){
		minusFlag = true;
	}
	
	newValue = getOnlyNumber(newValue);
	// comma제거된 문자열 길이
	len = newValue.length;
	
	for(i=len ; i>0 ; i--){
		ch = newValue.substring(i-1,i);
		formatValue = ch + formatValue;
		if ((j%3) == 0 && i>1 ){
			formatValue=","+formatValue;
		}
		j++
	}
	if(minusFlag == true){
		formatValue = "-" + formatValue;
	}else{
		formatValue = formatValue;
	}
	
	if (tempValue.length > 1) {
		formatValue = formatValue + "." + tempValue[1];
	}
	return formatValue;
 }

 
 // 숫자만 가져오기
// instring : 문자열
// return : 문자가 제거된 숫자
function getOnlyNumber(instring) 
{
	var ic;
	var result = "";
	var charpnum = null;
	
	for (ic=0; ic<instring.length; ic++)
	{
		charpnum = instring.substr(ic,1);
		if (charpnum.charCodeAt(0) < 47 || charpnum.charCodeAt(0) > 58)
		{
		} else {
			result = result + "" + charpnum;
		}
	}
	return result;
}

/* 캠페인 검색 공통모듈 */ 
function searchCamp(code, strCampName){
	if(code == "0"){
		var searchType = "";
		var searchText = "";	
		var objParam= new Object();
		objParam.OPENER = window;
		objParam.strSearchText = searchText;        //검색 텍스트
		objParam.strSearchType = searchType;        //그룹명검색인지 그룹아이디 검색인지
		objParam.strCampName = "";  				//검색 캠페인명
		objParam.strCampNameParam = strCampName;    //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
		
		var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
		
		var winSearchBranch = window.showModalDialog("../searchCampPop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');	
	
	}else if(code == "13" || code == ""){
		
		var obj1 = eval("document.getElementById('" + strCampName +"')");
		var searchType = "";
		var searchText = "";	
		
		searchText = obj1.value;
		
		var strUrl = "strSearchText=" + searchText;
		var strReturnValue = getXMLHttpRequestXML("../searchCamp.action",strUrl);
		var strResult = strReturnValue.getElementsByTagName("Result")[0];
		var resultVal = strResult.getElementsByTagName("resultVal")[0].firstChild.nodeValue;
		
		if(resultVal == -1){
			var errorVal = strResult.getElementsByTagName("idVal")[0].firstChild.nodeValue;
			alert(errorVal);
		}
		else if(resultVal != 1){
			var objParam= new Object();
			objParam.OPENER = window;
			objParam.strSearchText = searchText;        //검색 텍스트
			objParam.strCampName = obj1;  				//검색 그룹 이름
			objParam.strCampNameParam = strCampName;  //팝업창 화면에서 선택한 그룹명이 어디 변수로 넣을지
			
			var arrValue = centerPop("480", top.topFrame.document.getElementById('explorerVer').value);
			
			var winSearchBranch = window.showModalDialog("../searchCampPop.action", objParam, ' dialogWidth:480px; dialogHeight:'+top.topFrame.document.getElementById("explorerVer").value+'px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:0; center:0;');
			
		}else {
			var strCampNameTag = strResult.getElementsByTagName("arr1")[0].firstChild.nodeValue;		
			
			eval("document.getElementById('" + strCampName +"')").value = strCampNameTag;
		
		}
	}
}

/*
 * 사용법 
 * onclick="userPop('searchUserName', 'searchUserId', 'searchUserSeq', userSearchForm.searchGroupSeq.value, '<c:url value='/system/' />');
 * 파라미터로 넘겨주는 이름은 jsp 에 객체로 있어야함.
 * 사용자 팝업에서 선택한사용자를 넘겨준 이름의 객체의 값에 넘겨줍니다.
 * 네번째 파라미터는 그룹 아이디가 검색된 변수의 값을 넘겨줍니다. 값이 있다면 해당 그룹 안에서만 사용자가 검색됩니다.
 * 
 * */
function userPop(userName, userId, userSeq, groupSeq, systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strUserNameParam = userName;    //팝업창 화면에서 선택한 사용자명이 어디 변수로 넣을지
	objParam.strUserIdParam = userId;        //팝업창 화면에서 선택한 사용자아이디를 어디 변수로 넣을지
	objParam.strUserSeqParam = userSeq;      //팝업창 화면에서 선택한 사용자코드를 어디 변수로 넣을지
	objParam.strGroupSeqParam = groupSeq;    //그룹이 검색되 있는 상태이면 해당 그룹에서만 사용자를 검색합니다.
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("500", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"userPopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("506", "595");
		var winSearchBranch = window.showModalDialog(systemPath+"userPopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}

// 녹취파일 청취 팝업  
function playerPop(serverUrl, filePath, systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strServerUrlParam = serverUrl;	//서버 url.
	objParam.strFilePathParam = filePath;	//파일 경로.
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("500", "565");
		var winSearchBranch = window.showModelessDialog(systemPath+"playerPop.do", objParam,' status:true;dialogWidth:350px;dialogHeight:159px;scroll:no');
	}else{
		var arrValue = centerPop("506", "595");
		var winSearchBranch = window.showModelessDialog(systemPath+"playerPop.do", objParam,' status:true;dialogWidth:350px;dialogHeight:159px;scroll:no');
	}
}

function recordPlayer(serverUrl, filePath){
	var url = serverUrl+filePath;
	var state = ZiPhonePlayer.StartURLPlay(url, 5);
}



var winSearchBranch;

/* 통화 메모 팝업 */ 
function callMemoPop(recId, custName, memo, systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strMemoParam = memo;	//메모.
	objParam.strCustName = custName;	//고객명.
	objParam.recId = recId;	//아이디.
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("500", "565");
		if (winSearchBranch!=null){
			winSearchBranch.close();
		}
		winSearchBranch = window.showModelessDialog(systemPath+"callMemoPop.do", objParam,' status:true;dialogWidth:350px;dialogHeight:350px;scroll:no');
	}else{
		if (winSearchBranch!=null){
			winSearchBranch.close();
		}
		var arrValue = centerPop("506", "595");
		winSearchBranch = window.showModelessDialog(systemPath+"callMemoPop.do", objParam,' status:true;dialogWidth:350px;dialogHeight:350px;scroll:no');
	}
}

/*common.js
 * 사용법 
 * onclick="gradePop('gradeName', 'gradeSeq', '<c:url value='/system/' />');
 * 파라미터로 넘겨주는 이름은 jsp 에 객체로 있어야함.
 * 사용자 팝업에서 선택한사용자를 넘겨준 이름의 객체의 값에 넘겨줍니다.
 * 
 * */
function gradePop(gradeName, gradeSeq, systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strGradeNameParam = gradeName;    //팝업창 화면에서 선택한 권한명이 어디 변수로 넣을지
	objParam.strGradeSeqParam = gradeSeq;      //팝업창 화면에서 선택한 권한코드를 어디 변수로 넣을지
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("350", "350");
		var winSearchBranch = window.showModalDialog(systemPath+"gradePopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("356", "380");
		var winSearchBranch = window.showModalDialog(systemPath+"gradePopMain.do", objParam,' dialogWidth:356px; dialogHeight:380px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}

/* 굿콜등록 메모 팝업 */ 
function goodCallPop(systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("500", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"goodCallPop.do", window,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0; scroll:no;');
	}else{
		var arrValue = centerPop("506", "595");
		var winSearchBranch = window.showModalDialog(systemPath+"goodCallPop.do", window,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0; scroll:no;');
	}
}

function campaignPop(campaign, systemPath){
	var objParam= new Object();
	objParam.OPENER = window;
	objParam.strCampNameParam = campaign;    //팝업창 화면에서 선택한 캠페인명이 어디 변수로 넣을지
	
	var br_version = navigator.userAgent;
	//MSIE 부터 잘라내기 위함
	var br_index = br_version.indexOf('MSIE');
	//MSIE 포함한 브라우저 버전명
	var br_info = br_version.substr(br_index,8);
	//브라우저버전
	var br_info_num = br_info.substr(5,2);
	
	if(br_info_num >= 8){			
		var arrValue = centerPop("500", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"campaignPopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}else{
		var arrValue = centerPop("500", "565");
		var winSearchBranch = window.showModalDialog(systemPath+"campaignPopMain.do", objParam,' dialogWidth:350px; dialogHeight:350px; dialogTop:'+arrValue[0]+'px; dialogLeft:'+arrValue[1]+'px; help:0; resizable:0; status:0; scroll:1; center:0;');
	}
}

/* 팝업창을 가운데에 띄우는 모듈 */ 
function centerPop(width, height){
	var arrValue = [];	
	arrValue[0] = window.screenTop + 100;    //TOP
	arrValue[1] = window.screenLeft + 250;   //LEFT	
	return arrValue;
}

/* 마우스 오버 이미지 스위칭 처리 모듈 
 * 작성자 : 풍기정
 * 
 * */ 
$(function() {
	$("img.button").mouseover(function() {
	    $(this).attr("src", $(this).attr("src").replace(".","_over."));
	});
	$("img.button").mouseout(function() {
	    $(this).attr("src", $(this).attr("src").replace("_over", ""));
	});
});

/* 마우스 오버 이미지 스위칭 처리 모듈 - 호환성 문제로 인한 td background 이미지 전용
 * 작성자 : 구자호
 * 
 * */

$(function() {
	$("td.button").mouseover(function() {
	    $(this).attr("style", $(this).attr("style").replace(".","_over."));
	});
	$("td.button").mouseout(function() {
	    $(this).attr("style", $(this).attr("style").replace("_over", ""));
	});
});
