<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<title></title>
<link href="../css/irlink.css" rel="stylesheet" type="text/css">
<SCRIPT type="text/javascript" src = "../js/util.js"></SCRIPT>
<script language="javascript">
	document.onkeydown=keycheck;
	function keycheck(){
		if(event.keyCode == 8){
			if(event.srcElement.tagName=="INPUT"){
				if(event.srcElement.type=="text"){
					return;
				}
			}else if(event.srcElement.tagName=="TEXTAREA"){
				return;
			}
			return false;
	    }
		if (event.keyCode == 116) {
			event.keyCode = 0;
			return false;
		}
		document.onkeydown=keycheck;
	}
	
	function keycheck2(){
		if(event.keyCode == 8){
			event.returnValue = false;
		}
	}
	
	function startCateScrollScroll() {
	    setTimeout("slideCateScroll()", 10);                                 //div time
	}
	
	function slideCateScroll() {
	   	var Sel_width=150;                                                   //div width
		el = document.getElementById("leftMenu");						
	  	el1 = document.getElementById("leftMenuTab");
	  	
	    if (el.widthPos == null || (el.isDone && el.isOn == false)) {       //div opensize
	       //alert(el.widthPos+":"+el.isDone);
	  		el.isDone = false;		//변경 완료 여부	
	        el.widthPos = 0;			//시작 값
	        el.widthTo = Sel_width;//open 시 최종변경될 크기
	    }else if (el.isDone && el.isOn){                                     //div close size
	      //alert(el.isDone);
	  		el.isDone = false;
	        el.widthTo = -5; //close 시 최종변화될 크기
	    }
	    
	    if (Math.abs(el.widthTo - el.widthPos) > 1) { //목표치에 도달햇는지 확인
	        el.widthPos += (el.widthTo - el.widthPos) / 10;
	        el.style.left = (el.widthPos - 150) + "px";
	        el1.style.left = (el.widthPos + 10) + "px";
	        startCateScrollScroll();   //목표치에 도달 할때까지 반복  
	    } else {
	    if (el.widthTo == Sel_width) { 
	        el.isOn = true;//open
	    } else {
	        el.isOn = false;//close
	    }
	        el.widthPos = el.widthTo;
	        //el.style.width = el.widthPos + "px";
	        el.isDone = true;//변경완료 
	    }
	}
	
	//function submit()
	//{
		//session 체크
		//var strSessionUserId = '<s:property value="#session.user_id"/>';
		//checkSession(strSessionUserId);
		
		//alert(document.getElementById("hidMenuId").value);
		//alert(document.getElementById("hiddenUrl").value);
		
		//if(document.getElementById("hiddenUrl").value == "12000_1001m.action") {
			// 팝업 화면 중앙에 위치..
		//	if(screen.width < 1025) {
		//		LeftPos = 0;
		//		TopPos = 0;
		//	} else {
		//		LeftPos = (screen.width)?(screen.width-447)/2:100;
		//		TopPos = (screen.height)?(screen.height-450)/2:100;
		//	}
			
		//	var custRegistPop = "12000_1001m.action";
		//	var popCustRegist = window.showModalDialog(custRegistPop, window, 'dialogWidth:447px; dialogHeight:650px; dialogTop:'+TopPos+'; dialogLeft:'+LeftPos+'; help:0; resizable:0; status:0; scroll:0; center:0;');
			 
		//} else {
			//if(top.topFrame.document.getElementById("hidCallProcessFlag").value != "0") {
			//	alert("※ 통화중에는 다른 유권자 선택하실 수 없습니다.\r\n 상담저장 후 선택하실 수 있습니다.");
			//	return;
			//} else {
			//	top.topFrame.document.getElementById("hidUrl").value = document.getElementById("hiddenUrl").value;
			//	document.getElementById("iframeMain").src = document.getElementById("hiddenUrl").value;			
			//}
		//}
	//}
	//-->
</script>
</head>
<body leftmargin="0" topmargin="0" style="overflow-y:hidden" onload="" oncontextmenu="return false" ondragstart="return false">
	<table border="0" width="100%" height ="100%" cellpadding="0" cellspacing="0">
		<tr align="top">
			<td width="11">
				<div id="leftMenu" style="position:absolute;left:-149px;width:160px;height:100%;overflow:hidden">
				<iframe id="iframeMenu" name="" src="<c:url value='/common/leftMenu.do'/>" width="100%" height="100%" marginwidth="0" marginheight="0" frameborder="0" scrolling="no"></iframe>
				</div>
				<div id="leftMenuTab" style="position:absolute;width:14px;height:64px;top:33px;left:10px;overflow:hidden">
				<iframe id="iframeMenuTab" name="" src="<c:url value='/common/leftMenuTab.do'/>" width="100%" height="100%" marginwidth="0" marginheight="0" frameborder="0" scrolling="no"></iframe>
				</div>	
			</td>
			<td width="">
				<iframe id="iframeMain" src="<c:url value='${target}'/>" width="100%" height="100%" marginwidth="0" marginheight="0" frameborder="0" style=""></iframe>
				<s:hidden id="hiddenUrl" value="" />
				<s:hidden id="hidMenuId" value="" />
			</td>
		</tr>
	</table>
</body>
</html>