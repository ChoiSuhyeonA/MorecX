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
<script type="text/javascript">




$(document).ready(function(){
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
	parent.document.getElementById("btn_search").disabled = false;
	parent.document.getElementById("totalCnt").innerHTML = <c:out value="${totCnt}"/> + "건&nbsp;";
	parent.document.getElementById("pageCnt").innerHTML = <c:out value="${maxPage+1}"/> + "&nbsp;";
	parent.document.getElementById("maxPageCheck").value = <c:out value="${maxPage+1}"/>;
	
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
	
	$('u').click(function(){
		if(this.id != ''){
			parent.sortField(this.id);
			parent.searchList();
		}
	});
	
	
});


/* pagination 페이지 링크 function */
function fn_record_list_page(pageNo){
	parent.document.recordSearchVO.pageIndex.value = pageNo;
   	parent.document.recordSearchVO.target = "iframeRecordList";
   	parent.document.recordSearchVO.action = "<c:url value='/record/recordManageList.do'/>";
   	parent.document.recordSearchVO.submit();
}

function fn_group_detail(groupSeq) {
	var params="groupSeq="+groupSeq;
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/groupManageDetail.do'/>",
	    data:params,
	    //contentType: "application/json",
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			var console = console || {

			    log:function(){},

			    warn:function(){},

			    error:function(){}

			};
			
			console.log(searchData);
			if(searchData.size != 0){
				parent.document.groupSearchVO.groupSeqDT.value = searchData.list[0].id;
				if(searchData.list[0].groupnameupper != null) {
					parent.document.groupSearchVO.groupNameUpperDT.value = searchData.list[0].groupnameupper;
					if ((searchData.list[0].groupnameupper == "") && ("<c:out value="${sessionScope.zirecx_id}"/>" == "admin")){		
						parent.document.groupSearchVO.licenseCnt.className = "detail_value_writable";
						//parent.$('licenseCnt').removeAttr("readOnly");
						parent.document.groupSearchVO.licenseCnt.readOnly = false;
					} else {
						parent.document.groupSearchVO.licenseCnt.className = "detail_value_readonly";
						//parent.$('licenseCnt').attr("readOnly", true);
						parent.document.groupSearchVO.licenseCnt.readOnly = true;
					}
				} else {
					
					parent.document.groupSearchVO.groupNameUpperDT.value = "";
				}
				
				parent.document.groupSearchVO.groupNameDT.value = searchData.list[0].groupname;
				if(searchData.list[0].deleted == "1") {
					parent.document.groupSearchVO.deleteYnDT.checked = true;
				} else {
					parent.document.groupSearchVO.deleteYnDT.checked = false;
				}
				
				parent.document.groupSearchVO.licenseCnt.value = searchData.list[0].licenseCnt;
				
				parent.document.groupSearchVO.groupSeqUpperDT.value = searchData.list[0].parent;
				
				parent.$('div.div_groupDetail input[type=text]').attr("disabled", false);
				
				parent.document.groupSearchVO.storagePeriod.value = searchData.list[0].storagePeriod;
				
				if(searchData.list[0].listenSupported == "1") {
					parent.document.groupSearchVO.listenSupported.checked = true;
				} else {
					parent.document.groupSearchVO.listenSupported.checked = false;
				}
				
				parent.document.groupSearchVO.officeCode.value = searchData.list[0].officeCode;
				
				parent.document.groupSearchVO.groupCode.value = searchData.list[0].groupCode;
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}

/* pagination 페이지 링크 function */
function fn_group_list_page(){
	var pageNo = getOnlyNumber(parent.$("input[name=nowpage]").val());
	if(pageNo == ""){
		alert("원하시는 페이지를 입력해주십시오.");
		parent.$("input:hidden[name=nowpage]").focus();
	}else{
		parent.document.getElementById("pageIndex").value = pageNo;
		parent.document.getElementById("nowpage").value = pageNo;
		
		//historySave();
		
		parent.$("#groupSearchVO").attr("target","iframeGroupList");
	   	parent.$("#groupSearchVO").attr("action","<c:url value='/system/groupManageList.do'/>");
	   	parent.$("#groupSearchVO").submit();
	}
}

</script>
</head>
<body style="margin:0px" bgcolor="#FFFFFF" >
<form:form commandName="groupSearchVO" name="groupSearchVO" method="post">

<input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(groupList)}" />

<table width="100%" height="" cellpadding="0" cellspacing="0" border="1" class="list_table_box">
<tr>
	<td width="40px" class="list_header">번호</td>
	<td width="" class="list_header"><u style="cursor:hand" id="groupnameupper">상위센터</u></td>
	<td width="95px" class="list_header"><u style="cursor:hand" id="groupname">센터명</u></td>
	<td width="60px" class="list_header"><u style="cursor:hand" id="deleted">삭제</u></td>
</tr>

<c:if test="${fn:length(groupList) == 0}">
<tr height="24px">
	<td colspan="4" align="center" class="list_no_result"><spring:message code='common.nodata.message' /></td>
</tr>
</c:if>

<c:forEach var="result" items="${groupList}" varStatus="status">
<tr id="tr_<c:out value="${status.count}"/>" style="cursor: hand;" onclick="javascript:fn_group_detail(<c:out value="${result.id}"/>);">
	<td id="no" align="right" class="list_value">
		<c:out value="${status.count + cnt}"/>&nbsp;
	</td>
	<td id="groupNameUpper" align="left" class="list_value">
		&nbsp;<c:out value="${result.groupnameupper}"/>
	</td>
	<td id="groupName" align="left" class="list_value">
		&nbsp;<c:out value="${result.groupname}"/>
	</td>
	<td id="deleteYn" align="center" class="list_value">
		<c:if test="${result.deleted == '0'}">
			<input type="checkbox" disabled="disabled" />
		</c:if>
		<c:if test="${result.deleted == '1'}">
			<input type="checkbox" disabled="disabled" checked="checked"  />
		</c:if>
	</td>
</tr>
</c:forEach>

</table>

</form:form>
</body>
</html>
