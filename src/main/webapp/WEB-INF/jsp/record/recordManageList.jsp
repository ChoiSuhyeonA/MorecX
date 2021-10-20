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
	parent.document.getElementById("chkAll").checked = false;
	<% /* 굿콜지정 권한 */ %>
	if("<c:out value="${sessionScope.zirecx_id}"/>" != "admin"){				
		privChooseGoodCall(parent.document.getElementById("strGoodCallPolicy").value, "goodcall");		
	}
	checkBefore();
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
	parent.document.getElementById("btn_search").disabled = false;
	parent.document.getElementById("maxPage").innerHTML = document.getElementById("maxPage").value;
	parent.document.getElementById("maxPageCheck").value = document.getElementById("maxPage").value;
	parent.document.getElementById("totalCount").innerHTML = document.getElementById("totalCount").value;
}
function fn_recordPlayer(serverUrl, filePath){
	<% /* 녹취 플레이 */ %>
	top.topFrame.recordPlayer(serverUrl, filePath);
}
/* pagination 페이지 링크 function */
function fn_record_list_page(pageNo){
	parent.document.getElementById("pageIndex").value = pageNo;
	parent.document.getElementById("nowpage").value = pageNo;
	
	historySave();
	
   	parent.$("#recordSearchVO").attr("target","iframeRecordList");
   	parent.$("#recordSearchVO").attr("action","<c:url value='/record/recordManageList.do'/>");
   	parent.$("#recordSearchVO").submit();
}

<% /* 새로고침시에 사용할 이전 검색값 세팅  */ %>
function historySave(){
	parent.document.getElementById("refgroupSeq").value = parent.document.getElementById("groupSeq").value;
	parent.document.getElementById("refuserId").value = parent.document.getElementById("userId").value;
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
	document.getElementById("strCallCode").value = "Z";
	document.getElementById("strRecFileId").value = callId;
	document.getElementById("strCallFlag").value = "G";
	
	$("#recordSearchVO").attr("target","iframe_call_b_hidden");
   	$("#recordSearchVO").attr("action","<c:url value='/record/addGoodCall.do'/>");
   	$("#recordSearchVO").submit();
}

<% /* 체크박스 전체 선택..  */ %>
function checkAll(){
	var chkObj = document.getElementsByName("chkSelect");
	var chkCnt = document.getElementsByName("chkSelect").length;
	var saveObj = parent.document.getElementById("selectedRecId");
	
	if(parent.document.getElementById("chkAll").checked){
		for(i=0 ; i < chkCnt ; i++){
			if (!chkObj[i].checked){
				chkObj[i].checked = true;
				checkRec(chkObj[i].id.split("_")[1]);
			}
		}
	}else{
		for(i=0 ; i < chkCnt ; i++){
			chkObj[i].checked = false;
			checkRec(chkObj[i].id.split("_")[1]);
		}
	}
}

<% /* 체크박스 단일선택  */ %>
<% /* 단일 선택된 seg_id를 기억한다  */ %>
function checkRec(recId){
	var saveObj = parent.document.getElementById("selectedRecId");
	if(document.getElementById("chkRec_"+recId).checked){
		if (saveObj.value == ""){
			saveObj.value = recId;
		} else {
			saveObj.value = saveObj.value + ", " + recId;
		}
	}else{
		if (saveObj.value.split(",").length == 1){
			saveObj.value = "";
		} else {
			if (saveObj.value.split(",")[0] == recId){
				saveObj.value = saveObj.value.replace(recId + ", ", "");
				saveObj.value = saveObj.value.replace(recId , "");
			} else {
				saveObj.value = saveObj.value.replace(", "+ recId , "");
			}
		}
	}
}

<% /* 이전 체크박스 로딩시 체크  */ %>
function checkBefore(){
	var saveObj = parent.document.getElementById("selectedRecId");
	var recId = saveObj.value.split(", ");
	
	for (var i=0; i< recId.length; i++){
		if(document.getElementById("chkRec_" + recId[i])){
			document.getElementById("chkRec_" + recId[i]).checked = true;
		}
	}
	document.getElementById("nowpage").value = parent.document.getElementById("nowpage").value;
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
	
   	parent.$("#recordSearchVO").attr("target","iframeRecordList");
   	parent.$("#recordSearchVO").attr("action","<c:url value='/record/recordManageList.do'/>");
   	parent.$("#recordSearchVO").submit();
}

</script>
</head>
<body onload="init();" style="overflow-y: scroll;">
<form:form commandName="recordSearchVO" id="recordSearchVO" name="recordSearchVO" method="post">
<input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(recordList)}" />
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
<table width="1153px" cellpadding="0" cellspacing="0" border="0" style="border-top: 0;" class="list_table_box">
<c:forEach var="result" items="${recordList}" varStatus="status">
	<tr height="24px" id='tr_<c:out value="${status.count}"/>'>
		<td width="30px"  align="center" class="list_value">
			<input type="checkbox" name="chkSelect" id="chkRec_<c:out value='${result.segId}'/>" hidefocus="true" value="<c:out value="${result.segId}"/>" onclick="checkRec('<c:out value="${result.segId}"/>');"></input>
		</td>
		<td width="50px" align="center" class="list_value">
			<c:out value="${status.count + cnt}"/>
		</td>
		<td width="30px" align="center" class="list_value">
			<img class="button" src="<c:url value='/images/icon/icon_play.png' />" onclick="fn_recordPlayer('<c:out value="${serverUrl}"/>', '<c:out value="${result.fileName}"/>');" style="cursor: pointer;" />
		</td>
		<td width="30px" align="center" class="list_value">
		<c:if test="${result.goodId == NULL || result.goodId ==''}">
			<input type="checkbox" name="goodcall" id="goodcall_<c:out value='${result.segId}'/>" hidefocus="true" onclick="checkGoodCall('<c:out value="${result.segId}"/>')" />
		</c:if>
		<c:if test="${result.goodId != NULL && result.goodId !=''}">
			<input type="checkbox" name="goodcall" id="goodcall_<c:out value='${result.segId}'/>" hidefocus="true" onclick="checkGoodCall('<c:out value="${result.segId}"/>')" checked/>
		</c:if>
		</td>
		<td align="left" class="list_value">
			&nbsp;<c:out value="${result.schGroupName}"/>
		</td>
		<td width="100px" align="center" class="list_value">
			<c:out value="${result.firstname}"/>
		</td>
		<td width="100px" align="center" class="list_value">
			<c:out value="${result.zirecxId}"/>
		</td>
		<td width="100px" align="center" class="list_value">
			<c:if test="${result.phonenumber == ''}">
				-
			</c:if>
			<c:if test="${result.phonenumber != ''}">
				<c:out value="${result.phonenumber}"/>
			</c:if>
		</td>
		<td width="50px" align="center" class="list_value">
			<c:if test="${result.io == 'I'}">
				수신
			</c:if>
			<c:if test="${result.io == 'O'}">
				발신
			</c:if>
		</td>
		<td width="100px" align="center" class="list_value">
			<c:if test="${result.remoteparty == ''}">
				-
			</c:if>
			<c:if test="${result.remoteparty != ''}">
				<c:out value="${result.remoteparty}"/>
			</c:if>
		</td>
		<td width="80px" align="center" class="list_value">
			<c:out value="${result.date}"/>
		</td>
		<td width="100px" align="center" class="list_value">
			<c:out value="${result.time}"/>
		</td>
		<td width="70px" align="center" class="list_value">
			<script type="text/javascript">
				document.write(convertDuration('<c:out value="${result.duration}"/>'));
			</script>
			
		</td>
		<td style="display: none;">
			<c:out value="${result.fileName}"/>
		</td>
	</tr>
</c:forEach>

<c:if test="${fn:length(recordList) == 0}">
	<tr height="72px">
		<td colspan="14" align="center" class="list_no_result"><spring:message code='common.nodata.message' /></td>
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
</form:form>
</body>
</html>
