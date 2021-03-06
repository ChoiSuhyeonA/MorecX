<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/authority.js' />"></script>
<script type="text/javascript">

var win = window.dialogArguments;

function init(){
	var clareCalendar = {
			monthNamesShort: ['<spring:message code='calendar.month.jan' />','<spring:message code='calendar.month.feb' />','<spring:message code='calendar.month.mar' />','<spring:message code='calendar.month.apr' />','<spring:message code='calendar.month.may' />','<spring:message code='calendar.month.jun' />','<spring:message code='calendar.month.jul' />','<spring:message code='calendar.month.aug' />','<spring:message code='calendar.month.sep' />','<spring:message code='calendar.month.oct' />','<spring:message code='calendar.month.nov' />','<spring:message code='calendar.month.dec' />'],
			dayNamesMin: ['<spring:message code='calendar.week.sun' />','<spring:message code='calendar.week.mon' />','<spring:message code='calendar.week.tue' />','<spring:message code='calendar.week.wed' />','<spring:message code='calendar.week.thu' />','<spring:message code='calendar.week.fri' />','<spring:message code='calendar.week.sat' />'],
			weekHeader: 'Wk',
			dateFormat: 'yy-mm-dd',
			autoSize: false,
			changeMonth: true,
			changeYear: true,
			showMonthAfterYear: true,
			showAnim: "slide", 
			buttonImageOnly: false
		};
		$("#visitDate").datepicker(clareCalendar);
}

function selectVisitType(obj) {
	if(obj.value == ""){
		document.getElementById("visitPlace").setAttribute("disabled","disabled");
		document.getElementById("visitPlace").value = "";
		return;
	} else if(obj.value == "????????????" || obj.value == "??????" || obj.value == "??????") {
		document.getElementById("visitPlace").setAttribute("disabled","disabled");
		document.getElementById("visitPlace").value = obj.value;
	} else {
		document.getElementById("visitPlace").value = "";
		document.getElementById("visitPlace").removeAttribute("disabled");
	} 
}

function calendarPickerFrom(){
	$("#visitDate").focus();
}

function save(){
	if(validation1()&&confirm("?????????????????????????")){
		$("input[name=visitPlace]").prop("disabled", false);
		document.fileUpload.submit();	
	}
}

function validation1(){
	if(!$("[name=customerNumber]").val()){
		alert("??????????????? ??????????????????.");
		$("[name=customerNumber]").focus();
		return;
	}
	if(!$("[name=customerName]").val()){
		alert("???????????? ??????????????????.");
		$("[name=customerName]").focus();
		return;
	}
	if(!$("[name=visitDate]").val()){
		alert("???????????? ??????????????????.");
		$("[name=visitDate]").focus();
		return;
	}
	if(!$("[name=file]").val()){
		alert("??????????????? ??????????????????.");
		return;
	}
	return true;
}

</script>
</head>
<body style="margin: 0px;" onload="init();" class="popup_uploadFile">
<form id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data" action="<c:url value='/record/insertPenCallInfo.do'/>">
<%-- <form:hidden path="serverUrl" />
<form:hidden path="filePath" /> --%>
	<div style="padding: 30px 30px; margin-top: 90px; font-size: 12px; font-family: '??????';">
    <div>
      <span style="width: 250px;">
        <span style="width: 80px;">????????????<font color="red">*</font></span>
			<input type="text" name="customerNumber" id="customerNumber" class="search_value" style="height:20px; color:#c5c8cd;" maxlength="20">
		</span>
      
      <span style="margin-left: 15px;">
        <span style="width: 80px;">?????????<font color="red">*</font></span>
        <input type="text" name="customerName" id="customerName" class="search_value" style="height:20px; color:#c5c8cd;" maxlength="8">
      </span>
    </div>
    
    <div style="margin-top: 15px;">
      <span style="width: 250px;">
        <span style="width: 80px;">??????</span>
        <select name="faceToFace" class="search_condition_select" style="width:130px;">
          <option value="??????"><spring:message code='penrec.option.myself' /></option>
          <option value="??????"><spring:message code='penrec.option.absence' /></option>
          <option value="??????"><spring:message code='penrec.option.family' /></option>
          <option value="??????"><spring:message code='penrec.option.acquaintance' /></option>
          <option value="??????"><spring:message code='penrec.option.guitar' /></option>
        </select>
      </span>
      
      <span style="margin-left: 15px;">
        <span style="width: 80px;">???????????????</span>
        <select name="visitDateClass" class="search_condition_select" style="width:130px;">
          <option value="??????">??????</option>
          <option value="??????">??????</option>
          <option value="??????">??????</option>
          <option value="??????">??????</option>
        </select>
      </span>
    </div>
    
    <div style="margin-top: 15px;">
      <span style="width: 250px;">
        <span style="width: 80px;">?????????<font color="red">*</font></span>
        <span width="75px" ><input type="text" id="visitDate" name="visitDate" class="search_value" style="width:114px; height:20px;" readonly="readonly"/></span>
        <span width="14px" align="right"><img class="button" src="<c:url value='/images/icon/icon_calendar.gif' />" onclick="calendarPickerFrom();"/></span>
      </span>
    </div>
    
    <div style="margin-top: 15px;">
      <span>
        <span style="width: 80px;">???????????????</span>
        <select name="visitType" class="search_condition_select" style="width:130px;" onchange="selectVisitType(this)" >
          <option value="????????????"><spring:message code='penrec.option.live' /></option>
          <option value="??????"><spring:message code='penrec.option.uniform' /></option>
          <option value="??????"><spring:message code='penrec.option.job' /></option>
          <option value="DIRECTINPUT"><spring:message code='penrec.option.directinput' /></option>
        </select>
        <input type="text" name="visitPlace" id="visitPlace" value="????????????" class="search_value" style="height:20px; width:260px; color:#c5c8cd;" maxlength="50">
      </span>
    </div>
    
    <div style="margin-top: 15px;">
      <span style="width: 80px;">????????????<font color="red">*</font></span>
      <input type="file" name="file" style="width: 395px; height: 20px;" />
    </div>
	</div>
  <div align="right" style="margin-right: 45px;">
    <img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />" onClick="save();"/>
  </div>
</form>
</body>
</html>