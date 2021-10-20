<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/authority.js' />"></script>
<script type="text/javascript">
$(document).ready(function(){

	$('tr').click(function(){ 
		if(this.id != '')
			changeLine('true', this.id.substring(3)); 
	});
	$('tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length);
			overColor(vId);
		}
	});
	$('tr').mouseout(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length);
			outColor(vId);
		}
	});

});
function init(){
	parent.$("#topTable").scrollLeft(0);
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
	parent.document.getElementById("btn_search").disabled = false;
	parent.document.getElementById("maxPage").innerHTML = document.getElementById("maxPage").value;
	parent.document.getElementById("maxPageCheck").value = document.getElementById("maxPage").value;
	parent.document.getElementById("totalCount").innerHTML = document.getElementById("totalCount").value;
}

/* pagination 페이지 링크 function */
function fn_record_list_page(pageNo){
	parent.document.getElementById("pageIndex").value = pageNo;
	parent.document.getElementById("nowpage").value = pageNo;
	
	historySave();
	
   	parent.$("#recordSearchVO").attr("target","callHistoryRefreshList.do");
   	parent.$("#recordSearchVO").attr("action","<c:url value='/record/callHistoryManageList.do'/>");
   	parent.$("#recordSearchVO").submit();
}

<% /* 새로고침시에 사용할 이전 검색값 세팅  */ %>
function historySave(){
	alert(1);
	parent.document.getElementById("refgroupSeq").value = parent.document.getElementById("schGroupId").value;
	parent.document.getElementById("refuserId").value = parent.document.getElementById("schUserZirecxId").value;
	parent.document.getElementById("refsearchKeyword").value = parent.document.getElementById("searchKeyword").value;
	parent.document.getElementById("refstrStartDate").value = parent.document.getElementById("strStartDate").value;
	parent.document.getElementById("refstrEndDate").value = parent.document.getElementById("strEndDate").value;
}

<% /* 굿콜 추가&제거 체크박스  */ %>
function checkGoodCall(callId){
	if(document.getElementById("goodcall_"+callId).checked){
		
		document.getElementById("goodcall_"+callId).checked = false;
		document.getElementById("callIdSave").value = callId;
		goodCallPop("<c:url value='/common/' />");
			
	}else{
		document.getElementById("strRecFileId").value = callId;
		$("#recordSearchVO").attr("target","iframe_call_b_hidden");
	   	$("#recordSearchVO").attr("action","<c:url value='/record/removeGoodCall.do'/>");
	   	$("#recordSearchVO").submit();
	}
}

<% /* 굿콜 추가 및 메모등록  */ %>
function goodCallMemo(callId){
	
	document.getElementById("goodcall_"+callId).checked = true;
	document.getElementById("strCallCode").value = "M";
	document.getElementById("strRecFileId").value = callId;
	document.getElementById("strCallFlag").value = "G";
	
	$("#recordSearchVO").attr("target","iframe_call_b_hidden");
   	$("#recordSearchVO").attr("action","<c:url value='/record/addGoodCall.do'/>");
   	$("#recordSearchVO").submit();
}

<% /* Sorting */ %>
function orderByField(field){
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	parent.document.getElementById("btn_search").disabled = true;
	var pageNo = getOnlyNumber(document.getElementById("nowpage").value);
	if(pageNo == ""){
		document.getElementById("nowpage").value = "1";
	}
	
	if (parent.document.getElementById("orderField").value == field && parent.document.getElementById("orderType").value == "DESC") {
		document.getElementById("orderType").value = "ASC";
	} else {
		document.getElementById("orderType").value = "DESC";
	}
	document.getElementById("orderField").value = field;
	
	parent.document.getElementById("pageIndex").value = pageNo;
	parent.document.getElementById("nowpage").value = pageNo;
	parent.document.getElementById("orderField").value = document.getElementById("orderField").value;
	parent.document.getElementById("orderType").value = document.getElementById("orderType").value;
	
   	parent.$("#recordSearchVO").attr("target","callHistoryRefreshList.do");
   	parent.$("#recordSearchVO").attr("action","<c:url value='/record/callHistoryManageList.do'/>");
   	parent.$("#recordSearchVO").submit();
}

</script>
<style type="text/css"> html { overflow:hidden; } </style>
</head>
<body onload="init();">
<form:form commandName="recordSearchVO" id="recordSearchVO" name="recordSearchVO" method="post">
<input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(callHistoryList)}" />
<form:hidden path="pageIndex" />
<input type="hidden" id="strCallCode" name="strCallCode" />
<input type="hidden" id="strRecFileId" name="strRecFileId" />
<input type="hidden" id="strCallFlag" name="strCallFlag" />
<input type="hidden" id="userId" name="userId" />
<input type="hidden" id="description" name="description" />
<input type="hidden" id="callIdSave" name="callIdSave" />
<input type="hidden" id="orderField" name="orderField" />
<input type="hidden" id="orderType" name="orderType" />
<input type="hidden" id="maxPage" name="maxPage" value="${maxPage}" />
<input type="hidden" id="totalCount" name="totalCount" value="${totalCount}" />
<input type="hidden" id="nowpage" name="nowpage" value="1"/>
<div id="scrollTable" style="overflow:scroll; height:463px; width:1170px; " onScroll="parent.topTable.scrollLeft = this.scrollLeft;"  >
<table width="1275px" cellpadding="0" cellspacing="0" border="1" style=" border-top: 0;" class="list_table_box">
<c:forEach var="result" items="${callHistoryList}" varStatus="status">
	<tr height="24px" id='tr_<c:out value="${status.count}"/>'>
		<td width="50px" align="center" class="list_value">
			<c:out value="${status.count + cnt}"/>
		</td>
		<td width="150px" align="left" class="list_value">
			<div style='width:150;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;' title="<c:out value='${result.groupName}'/>">
				&nbsp;<c:out value="${result.groupName}"/>
			</div>
		</td>
		<td width="150px" align="center" class="list_value">
			<c:out value="${result.firstname}"/>
		</td>
		<td width="150px" align="center" class="list_value">
			<c:out value="${result.zirecxId}"/>
		</td>
		<td width="200px" align="center" class="list_value">
			<c:out value="${result.downDateTime}"/>
		</td>
		<td width="60px" align="center" class="list_value">
			<c:out value="${result.recordingType}"/>
		</td>
		<td width="507px" align="center" class="list_value">
			<div style='width:450;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>
				<c:out value="${result.fileName}"/>
			</div>
		</td>
	</tr>
</c:forEach>

<c:if test="${fn:length(callHistoryList) == 0}">
	<tr height="72px">
		<td colspan="7" align="left" class="list_no_result"  style="padding-left: 520px;"><spring:message code='common.nodata.message' /></td>
	</tr>
</c:if>
</table>
<table cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td height="15px"><iframe name="iframe_call_b_hidden" id="iframe_call_b_hidden" width="0px" height="0px" style="visibility: hidden;"></iframe></td>
	</tr>
	<tr style="display: none;">
		<td><input type="text" /> </td>
	</tr>
</table>
</div>
</form:form>
</body>
</html>
