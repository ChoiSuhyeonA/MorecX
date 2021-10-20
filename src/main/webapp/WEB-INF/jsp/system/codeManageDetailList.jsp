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
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/common.js'/>"></script>
<script type="text/javascript">

$(document).ready(function(){
	$('.tr_data').click(function(){ changeLine('true', this.id.substring(3)); });
	$('.tr_data').mouseover(function(){ overColor(this.id.substring(3)); });
	$('.tr_data').mouseout(function(){ outColor(this.id.substring(3)); });
});

function fn_code_detail_detail(trId, codeMaster, codeValue, codeName, sortOrder, description, deleted){
	parent.setDetailDetailInfo('modify');
	
	$('#detailCode', parent.document).val(codeValue);
	$('#detailCodeName', parent.document).val(codeName);
	$('#detailOrderNum', parent.document).val(sortOrder);
	$('#detailDetailInfo', parent.document).val(description);
	
	if(deleted == '1')
		$("input[name=detailDeleteYn]", parent.document).attr('checked', true);
	else
		$("input[name=detailDeleteYn]", parent.document).attr('checked', false);
	
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
			<spring:message code='code.name.detailcode' />
		</td>
		<td width="240px" align="center" class="list_header">
			<spring:message code='code.name.detailcodename' />
		</td>
		<td width="70px" align="center" class="list_header">
			<spring:message code='code.name.deleteyn' />
		</td>
		<td width="17px" align="center" class="list_header">
		</td>
	</tr>
</table>
<div id="scrollTable" style="width:576px; height:494px; overflow-x:hidden;overflow-y:scroll; border:none;">
<c:if test="${fn:length(codeDetailList) == 0}">
	<table width="559px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
	<tr>
		<td class="list_value" align="center" style="height:78px;">
			<spring:message code='common.nodata.message' />
		</td>
	</tr>
	</table>
</c:if>
<c:choose>
<c:when test="${fn:length(codeDetailList) > 0}">
	<table width="559px" border="0" cellspacing="0" cellpadding="0" class="list_table_box">
	<c:forEach var="result" items="${codeDetailList}" varStatus="status">
		<tr id='tr_<c:out value="${status.count}" />' title='<c:out value="${result.codeName}" />' onclick="javascript:fn_code_detail_detail('<c:out value="${status.count}"/>','<c:out value="${result.codeMaster}"/>','<c:out value="${result.codeValue}"/>','<c:out value="${result.codeName}"/>','<c:out value="${result.sortOrder}"/>','<c:out value="${result.description}"/>','<c:out value="${result.deleted}"/>');" style="cursor: arrow;" class="tr_data">
			<td height="50px" width="50px" align="right" class="list_value">
				<c:out value="${status.count}" />&nbsp;
			</td>
			<td width="" align="right" class="list_value">
				<c:out value="${result.codeValue}"/>&nbsp;
			</td>
			<td width="240" align="right" class="list_value">
				<div style='width:235px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>
					<c:out value="${result.codeName}"/>&nbsp;
				</div>
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
