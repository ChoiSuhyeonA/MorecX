<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title></title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script language="javascript" src="<c:url value='/jquery/js/common.js'/>"></script>
<script type="text/javascript">

$(document).ready(function(){
	$('.tr_data').click(function(){ changeLine('true', this.id.substring(3)); });
	$('.tr_data').mouseover(function(){ overColor(this.id.substring(3)); });
	$('.tr_data').mouseout(function(){ outColor(this.id.substring(3)); });
	
	parent.chngBtnSearch('end');	//조회중 버튼처리
});

function fn_code_master_detail(trId, codeMaster, codeName, description, deleted){
	parent.setMasterDetailInfo('modify');
	
	$('#masterCode', parent.document).val(codeMaster);
	$('#masterCodeName', parent.document).val(codeName);
	$('#masterDetailInfo', parent.document).val(description);
	
	if(deleted == '1')
		$("input[name=masterDeleteYn]", parent.document).attr('checked', true);
	else
		$("input[name=masterDeleteYn]", parent.document).attr('checked', false);
	
	parent.searchCodeDetailList();
}
</script>
</head>
<body>
<form:form commandName="codeSearchVO" name="codeSearchVO" method="post">
<table width="576px" class="list_table_box" border="0" cellspacing="0" cellpadding="0" >
	<tr>
		<td width="50px" align="center" class="list_header">
			<spring:message code='group.name.column.number' />
		</td>
		<td width="" align="center" class="list_header">
			<spring:message code='code.name.mastercode' />
		</td>
		<td width="300px" align="center" class="list_header">
			<spring:message code='code.name.mastercodename' />
		</td>
		<td width="70px" align="center" class="list_header">
			<spring:message code='code.name.deleteyn' />
		</td>
		<td width="17px" align="center" class="list_header">
		</td>
	</tr>
</table>
<div id="scrollTable" style="width:576px; height:322px; overflow-x:hidden;overflow-y:scroll; border:none;">
<c:if test="${fn:length(codeMasterList) == 0}">
	<table width="559px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
	<tr>
		<td class="list_value" align="center" style="height:78px;">
			<spring:message code='common.nodata.message' />
		</td>
	</tr>
	</table>
</c:if>
<c:choose>
<c:when test="${fn:length(codeMasterList) > 0}">
	<table width="559px" border="0" cellspacing="0" cellpadding="0" class="list_table_box">
	<c:forEach var="result" items="${codeMasterList}" varStatus="status">
		<tr id='tr_<c:out value="${status.count}" />' title='<c:out value="${result.codeName}" />' onclick="javascript:fn_code_master_detail('<c:out value="${status.count}"/>','<c:out value="${result.codeMaster}"/>','<c:out value="${result.codeName}"/>','<c:out value="${result.description}"/>','<c:out value="${result.deleted}"/>');" style="cursor: arrow;" class="tr_data">
			<td height="50px" width="50px" align="right" class="list_value">
				<c:out value="${status.count}" />&nbsp;
			</td>
			<td width="" align="center" class="list_value">
				<c:out value="${result.codeMaster}"/>
			</td>
			<td width="300" align="left" class="list_value">
				&nbsp;<c:out value="${result.codeName}"/>
			</td>
			<td width="70" align="center" class="list_value">
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
</c:when>
</c:choose>
</div>
</form:form>
</body>
</html>
