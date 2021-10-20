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
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">

var win = window.dialogArguments;

function init(){
	var setMemo;
	var recId; 
	var custName;
	
	setMemo = win.strMemoParam;
	document.getElementById('memo').value = setMemo.replace(/<br>/gi, "\r\n");
	document.getElementById('custName').value = win.strCustName;
	document.getElementById('recId').value = win.recId;
}


function save() {
		$.ajax({  
		    type: "POST",  
		    url: "<c:url value='/record/updateMemo.do'/>",
		    data:"recId="+document.getElementById('recId').value
		    +"&custName="+document.getElementById('custName').value
		    +"&memo="+$.trim(encodeURIComponent(document.getElementById('memo').value))
		    ,
		     
		    success: updateMemoCallBack,
		    error: function(e){  
		        alert('Error: ' + e.responseText);  
		    }  
        }); 	 
}

<% /* 메모 업데이트 콜백 */ %>
function updateMemoCallBack(result){
	var jsonObj = decodeURIComponent(result);
	var searchData = $.parseJSON(jsonObj);

	if(searchData.result == "1"){
		alert('변경되었습니다.');
		win.OPENER.parent.refreshList();
		self.close();
	}
}
</script>
</head>
<body style="width: 350px; height: 350px; margin: 0px;" onload="init();" class="popup_call_memo">
<input type="hidden" name="recId" id="recId">
	<table width="350px" height="" cellpadding="0" cellspacing="0" border="0">
		<tr height="88px">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr height="200px">
			<td width="15px">&nbsp;</td>
			<td>
				<table width="100%" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
				<tr>
					<td width="70px" class="detail_column">고객명</td>
					<td width="" class="detail_description"><input type="text" id="custName" class="detail_value_writable" style="width:150px" maxlength="255"/></td>
				</tr>
				<tr>
					<td width="" class="detail_column" >메모</td>
					<td width="" class="detail_description">
						<textarea class="" id="memo" name="memo" style="width:240px;height:180px;font-family: 돋움;font-size: 11px;	color: #737373;" ></textarea>
					</td>
				</tr>
				</table>
			</td>
			<td width="15px">&nbsp;</td>
		</tr>
		<tr height="25px">
			<td width="15px">&nbsp;</td>
			<td align="right">
			<table cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td><img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />" onClick="save();"/></td>
			</tr>
			</table>
			
			<td width="15px">&nbsp;</td>
		</tr>
		<tr height="10px">
			<td></td>
		</tr>
	</table>
</body>
</html>