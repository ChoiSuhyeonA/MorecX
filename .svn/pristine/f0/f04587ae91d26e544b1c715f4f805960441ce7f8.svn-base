<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title></title>
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/common.js'/>"></script>
<script type="text/javascript">

$(document).ready(function(){
	parent.changBtnSearch('end');
	
	parent.document.getElementById("totalCnt").innerHTML = <c:out value="${totCnt}"/> + "건&nbsp;";
	parent.document.getElementById("pageCnt").innerHTML = <c:out value="${maxPage+1}"/> + "&nbsp;";
	parent.document.getElementById("maxPageCheck").value = <c:out value="${maxPage+1}"/>;
	
	$('#nonScrollTitle u:first').click(function(){ 
		parent.sortField('groupId');
		parent.searchList();
	});
	$('#nonScrollTitle u:last').click(function(){ 
		parent.sortFieldDate('dateUpdated');
		parent.searchList();
	});
	$('div[id$=crollTable] tr').click(function(){
		if(this.id != '')
			changeLine('true', this.id.substring(3)); 
	});
	$('div[id$=crollTable] tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3);
			overColor(vId);
		}
	});
	$('div[id$=crollTable] tr').mouseout(function(){ 
		if(this.id != ''){
			var vId = this.id.substring(3);
			outColor(vId);
		}
	});
});

function fn_smartPhone_detail(phoneNumber) {
	
	//parent.$("#detail_phoneNumber").val($(element).find("#row_phoneNumber").val());
	parent.$("input:hidden[id=jobType]").val("update");
	var params="phoneNumber="+phoneNumber;
	
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/smart/smartPhoneManageDetail.do'/>",
	    data:params,
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			   
			if(searchData.size != 0){
				parent.$('div.div_smartPhoneDetail input[type=text]').val("");
				parent.$('div.div_smartPhoneDetail input[type=text]').removeAttr("disabled");
				
				parent.document.smartPhoneSearchVO.detail_id.value = searchData.list[0].id;
				parent.document.smartPhoneSearchVO.groupNameDetail.value = searchData.list[0].groupName;
				parent.document.smartPhoneSearchVO.groupIdDetail.value = searchData.list[0].groupId;			
				parent.document.smartPhoneSearchVO.detail_phoneNumber.value = searchData.list[0].phoneNumber;
				parent.document.smartPhoneSearchVO.detail_imei.value = searchData.list[0].imei;
				parent.document.smartPhoneSearchVO.detail_useStatusFlag.value = searchData.list[0].useStatusFlag;
				parent.document.smartPhoneSearchVO.detail_memo.value = searchData.list[0].memo;
				
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}

function fn_smartPhone_list_page(){
	var pageNo = getOnlyNumber(parent.$("input[name=nowpage]").val());
	if(pageNo == ""){
		alert("원하시는 페이지를 입력해주십시오.");
		parent.$("input:hidden[name=nowpage]").focus();
	}else{
		parent.document.getElementById("pageIndex").value = pageNo;
		parent.document.getElementById("nowpage").value = pageNo;
		
		parent.$("#smartPhoneSearchVO").attr("target","iframeSmartPhonetList");
	   	parent.$("#smartPhoneSearchVO").attr("action","<c:url value='/smart/smartPhoneManageList.do'/>");
	   	parent.$("#smartPhoneSearchVO").submit();
	}
}


//#################################################추가 

<% /* 체크박스 전체 선택..  */ %>
function checkAll(){
	var chkObj = document.getElementsByName("chkSelect");
	var chkCnt = document.getElementsByName("chkSelect").length;
	var saveObj = parent.document.getElementById("selectedId");

	if(document.getElementById("chkAll").checked){
		for(i=0 ; i < chkCnt ; i++){
			if (!chkObj[i].checked){
				chkObj[i].checked = true;
				checkId(chkObj[i].id.split("_")[1]);
			}
		}
	}else{
		for(i=0 ; i < chkCnt ; i++){
			chkObj[i].checked = false;
			checkId(chkObj[i].id.split("_")[1]);
		}
	} 
}

<% /* 체크박스 단일선택  */ %>
<% /* 단일 선택된 id를 기억한다  */ %>
function checkId(id){
	var saveObj = parent.document.getElementById("selectedId");
	if(document.getElementById("chk_"+id).checked){
		if (saveObj.value == ""){
			saveObj.value = id;
		} else {
			saveObj.value = saveObj.value + ", " + id;
		}
	}else{
		if (saveObj.value.split(",").length == 1){
			saveObj.value = "";
		} else {
			if (saveObj.value.split(",")[0] == id){
				saveObj.value = saveObj.value.replace(id + ", ", "");
				saveObj.value = saveObj.value.replace(id , "");
			} else {
				saveObj.value = saveObj.value.replace(", "+ id , "");
			}
		}
	}
}

<% /* 이전 체크박스 로딩시 체크  */ %>
function checkBefore(){
	var saveObj = parent.document.getElementById("selectedId");
	var id = saveObj.value.split(", ");
	
	for (var i=0; i< id.length; i++){
		if(document.getElementById("chk_" + id[i])){
			document.getElementById("chk_" + id[i]).checked = true;
		}
	}
	document.getElementById("nowpage").value = parent.document.getElementById("nowpage").value;
}



</script>
</head>
<body>
<form:form commandName="smartPhoneSearchVO" name="smartPhoneSearchVO" method="post">
<table id="nonScrollTitle" width="1170px" class="list_table_box" border="0" cellspacing="0" cellpadding="0" >
	<tr>
		<td width="30px" align="center" class="list_header">
			<input type="checkbox" name="chkAll" id="chkAll" hidefocus="true" onclick="checkAll();"></input>
		</td>
		<td width="50px" rowspan="3" align="center" class="list_header">
			No
		</td>
		<td width="" rowspan="3" align="center" class="list_header">
			<u style="cursor:hand"><spring:message code='message.group' /></u>
		</td>
		<td width="110px" rowspan="3" align="center" class="list_header">
			전화번호
		</td>
		<td width="130px" rowspan="3" align="center" class="list_header">
			IMEI
		</td>
		<td width="100px" rowspan="3" align="center" class="list_header">
			<u style="cursor:hand">변경일</u>
		</td>
		<td width="80px" rowspan="3" align="center" class="list_header">
			상태
		</td>
		<td width="100px" rowspan="3" align="center" class="list_header">
			작업자
		</td>
		<td width="254px" rowspan="3" align="center" class="list_header">
			특이사항
		</td>
		<td width="16px" align="center" class="list_header">
		</td>
	</tr>
</table>
<div id="scrollTable" style="width:1170px; height:280px; overflow-x:hidden;overflow-y:scroll; border:none;">
<c:if test="${fn:length(smartPhoneList) == 0}">
	<table width="1153px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
		<tr id=""><td align="center" class="list_value" style="border-left:0px; height:78px;"><spring:message code='common.nodata.message' /></td></tr>
	</table>
</c:if>
<c:choose>
<c:when test="${fn:length(smartPhoneList) > 0}">
	<table width="1170px" border="0" cellspacing="0" cellpadding="0" class="list_table_box">
	<c:forEach var="result" items="${smartPhoneList}" varStatus="status">
		<tr id='tr_<c:out value="${status.count + cnt}" />' onclick="fn_smartPhone_detail('<c:out value="${result.phoneNumber}"/>');">
			<td width="30px"  align="center" class="list_value">
				<input type="checkbox" name="chkSelect" id="chk_<c:out value='${result.id}'/>" hidefocus="true" value="<c:out value="${result.id}"/>" onclick="checkId('<c:out value="${result.id}"/>');"></input>
			</td> 
			<td width="50px" align="center" class="list_value">
				<div style='width:48px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${status.count + cnt}" />&nbsp;
				</div>
			</td>
			<td width="" align="left" class="list_value" title="${result.groupId}">
				<div style='width:90%;overflow:hidden;text-align:left;text-overflow:ellipsis;white-space:nowrap;'>
					&nbsp;<c:out value="${result.groupId}" />
				</div>
			</td>
			<td width="110px" align="center" class="list_value">
				<script type="text/javascript">
					document.write(fn_get_phone_format('<c:out value="${result.phoneNumber}"/>'));
				</script>
			</td>
			<td width="130px" align="center" class="list_value">
				<c:out value="${result.imei}" />&nbsp;
			</td>
			<td width="100px" align="center" class="list_value">
				<fmt:formatDate value="${result.dateUpdated}" pattern="yyyy-MM-dd"/>
			</td>
			<td width="80px" align="center" class="list_value">
				<c:if test="${result.useStatusFlag == 'Y'}">
					사용&nbsp;
				</c:if>
				<c:if test="${result.useStatusFlag == 'N'}">
					미사용&nbsp;
				</c:if>
			</td>
			<td width="100px" align="center" class="list_value">
				<c:out value="${result.updateUserId}" />&nbsp;
			</td>
			<td width="254px" align="left" class="list_value" title="${result.memo}">
				<div style='width:244px;overflow:hidden;text-align:left;text-overflow:ellipsis;white-space:nowrap;'>
					&nbsp;<c:out value="${result.memo}" />
				</div>
			</td>
			<td width="16px" align="center" class="list_value">
			</td>
		</tr>
	</c:forEach>
	</table>
</c:when>
</c:choose>
</div>
</form:form>
</body>
</html>
