<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/popup.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript">

//var win = window.dialogArguments;
var gPinNumberCount = 0;
var gPinNumberInit = "N";
var gPinNumberLimitTime = "Y";

function init(){
	document.getElementById('userId').value = "<c:out value='${strUserIdParam}' />";
}

function popClose(){
	self.close();
}

function fn_resetPasswordFlag(){
	if($.trim($("#userId").val()) == "") {
		alert("사용자 아이디를 입력해 주세요.");
		return;
	}
	
	if($.trim($("#pinNumber").val()) == "") {
		alert("PIN 번호를 입력해 주세요.");
		return;
	}
	
	if(gPinNumberInit == "N") {
		alert("PIN 번호 발송 버튼을 클릭 후 발급받으신 PIN 번호를 넣고 진행해 주세요.");
		return;
	}
	
	if(gPinNumberLimitTime == "Y") {
		alert("PIN 번호 입력 시간이 초과 되었습니다. PIN 번호를 재발송 받으신 후 진행해 주세요.");
		return;
	}
	
	var param = "userId="+$("#userId").val()
			  + "&pinNumber="+$("#pinNumber").val()
	;
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/common/sendRandomPassword.do'/>",
		data: param,
		success: function(result){
			var jsonObj = decodeURIComponent(result);
			var searchData = $.parseJSON(jsonObj);
			
			if(searchData.result == "SUCCESS") {
				alert("임시 비밀번호가 발송 되었습니다.\r\n임시 비밀번호를 변경 후 이용해 주시기 바랍니다.");
				//alert(searchData.sms);
				
				opener.document.getElementById("spanUserCurrentPassword").innerText = "임시 비밀번호";
				self.close();
			} else if(searchData.result == "LIMIT") {
				alert("1일 3회 비밀번호 초기화 횟수를 초과 하셨습니다.");
				return;
			} else if(searchData.result == "NOTCONFIRM") {
				alert("사용자 아이디, PIN 번호를 확인 후 다시 시도해 주세요.");
				return;
			} else if(searchData.result == "FAILURE") {
				alert("임시 비밀번호 발급에 실패 하였습니다.\r\n확인 후 다시 시도해 주세요.");
				return;
			}
		},
		error: function(e){
			alert("임시 비밀번호 발급 실패입니다.");
			return;
		}
	}); 
}

function pinNumberSend() {
	if($.trim($("#userId").val()) == "") {
		alert("사용자 아이디를 입력해 주세요.");
		return;
	}
	
	if(gPinNumberCount == 2) {
		alert("PIN 번호 재발송 횟수를 모두 사용하셨습니다.\r\n(PIN 번호 재발송 횟수는 1회까지만 가능합니다.)");
		return;
	}
	
	// PIN 번호 발송 카운트
	gPinNumberCount += 1;
	gPinNumberInit = "Y";
	gPinNumberLimitTime = "N";
	
	var param = "userId="+$("#userId").val();
	
	$.ajax({
		type: "POST",  
		url: "<c:url value='/common/sendPinNumber.do'/>",
		data: param,
		success: function(result){
			var jsonObj = decodeURIComponent(result);
			var searchData = $.parseJSON(jsonObj);
			
			if(searchData.result == "SUCCESS") {
				alert("PIN 번호가 개인 핸드폰번호로 전송 되었습니다.");
				//alert(searchData.sms);
				document.getElementById("sendBtn").src = "<c:url value='/images/button/btn_resend_pin_inactive.gif' />";
				document.getElementById("sendBtn").disabled = "disabled";
				
				if(gPinNumberCount <= 2) {
					document.getElementById("pinNumberResend").innerText = "* PIN 번호 재발송 1회 가능 (가능횟수 : "+(2-gPinNumberCount)+"회)";
					document.getElementById("sendBtn").src = "<c:url value='/images/button/btn_resend_pin_inactive.gif' />";
					document.getElementById("sendBtn").disabled = "disabled";
				}
				
				pinNumberInsertCount();
				
			} else if(searchData.result == "FAILURE") {
				alert("PIN 번호 전송 실패입니다.");
				return;
			} else if(searchData.result == "NOTUSER") {
				alert("존재하지 않는 사용자 아이디 입니다.\r\n사용자를 확인 후 진행해 주세요.");
				return;
			}
		},
		error: function(e){  
		}
	}); 
	
}

function pinNumberInsertCount() {
	var minute = "0"+3;
	var second = "0"+0;
	
	$(".countTimeMinute").html(minute);
	$(".countTimeSecond").html(second);
	
	var timer = setInterval(function() {
		minute = parseInt(minute);
		second = parseInt(second);
		
        if(minute == 0) {minute = "00"} else {if(minute < 10) {minute = "0" + minute;}};
        if(second == 0) {second = "00"} else {if(second < 10) {second = "0" + second;}};
		
		$(".countTimeMinute").html(minute);
		$(".countTimeSecond").html(second);

		if(second == 0 && minute == 0){
			alert('입력 시간이 만료 되었습니다.');
			
			gPinNumberLimitTime = "Y";
			clearInterval(timer);
			
			if(gPinNumberCount < 2) {
				document.getElementById("sendBtn").disabled = false;
				document.getElementById("sendBtn").src = "<c:url value='/images/button/btn_resend_pin.gif' />";
			}
			
		}else{
			second--;
			if(second < 0){
				minute--;
				second = 59;
			}
		}
    }, 1000);
}



</script>
</head>
<body onload="init();">
<form:form commandName="changePasswordVO" name="changePasswordVO" method="post">
<table width="295px" height="240px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_reset_password.gif' />" style="background-repeat: no-repeat;">
	<tr>
		<td width="15px"></td>
		<td align="center">
      		<table width="265px" height="240px" cellpadding="0" cellspacing="0" border="0">
      			<tr height="88px"><td></td></tr>
        		<tr height="101px">
          			<td valign="top">
          				<table width="100%" cellpadding="0" cellspacing="0" border="1" class="list_table_box">
          					<tr height="24px">
          						<td width="100px" align="center" class="password_header">
          							<spring:message code='changePassword.column.userId' />
          						</td>
          						<td class="password_value">
									&nbsp;<form:input path="userId" cssStyle="ime-mode:disabled;width:165px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
								</td>
							</tr>
							<tr height="24px">
								<td width="100px" align="center" class="password_header">
          							<spring:message code='resetPassword.column.pinNumber' />
          						</td>
								<td align="left" class="password_value">
									&nbsp;
									<form:input path="pinNumber" maxlength="6" cssStyle="ime-mode:disabled;width:120px; height:18px; border:0; background-color:#ecfafb; font-family: 돋움; font-size: 11pt; color: #9e9e9e; outline-style:none;" />
									<span style="font-size: 12px;">(<span class="countTimeMinute" style="font-size: 12px;">03</span><span style="font-size: 12px;">:<span class="countTimeSecond" style="font-size: 12px;">00</span><span style="font-size: 12px;">)</span>
								</td>
							</tr>
							<tr height="24px">
								<td colspan="2" align="left">
									<font color="#ff0000"; size="1px"><span id="pinNumberResend">* PIN 번호 재발송 1회 가능 (가능횟수 : 2회)</span></font>
								</td>
							</tr>
							<tr height="24px" bordercolor="#ffffff">
								<td colspan="2" align="left">
									<font color="#ff0000"; size="1px"><spring:message code='resetPassword.column.limitWarning' /></font>
								</td>
							</tr>
						</table>
          			</td>
        		</tr>
        		<tr height="51px">
        			<td>
						<table align="right" cellpadding="0" cellspacing="0" border="0">
							<tr height="10px"><td colspan="3"></td></tr>
							<tr height="24px">
								<td width="48px">
									<img class="button" id="sendBtn" src="<c:url value='/images/button/btn_send_pin.gif' />" style="cursor: hand" onclick="javascript:pinNumberSend();"/>
								</td>
								<td width="5px">
									&nbsp;
								</td>
								<td width="48px">
									<img class="button" src="<c:url value='/images/button/btn_confirm.gif' />" style="cursor: hand" onclick="javascript:fn_resetPasswordFlag();"/>
								</td>
								<td width="5px">
									&nbsp;
								</td>
								<td width="48px">
									<img class="button" src="<c:url value='/images/button/btn_change_password_cancle.gif' />" style="cursor: hand" onclick="javascript:popClose();"/>
								</td>
							</tr>
							<tr height="17px"><td colspan="3"></td></tr>
						</table>
        			</td>
        		</tr>
      		</table>
    	</td>
    	<td width="15px"></td>
	</tr>
</table>

</form:form>
</body>
</html>