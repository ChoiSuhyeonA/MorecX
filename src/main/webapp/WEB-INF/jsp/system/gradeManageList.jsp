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
function init(){
	parent.document.getElementById("btn_search").src ="<c:url value='/images/button/btn_search.gif' />";
	parent.document.getElementById("btn_search").disabled = false;
	
	parent.document.getElementById("maxPage").innerHTML = document.getElementById("maxPage").value;
	parent.document.getElementById("maxPageCheck").value = document.getElementById("maxPage").value;
	parent.document.getElementById("totalCount").innerHTML = document.getElementById("totalCount").value;
}

function fn_grade_detail(gradeSeq, trId) {
	parent.clickEnabled();
	changeLine(gradeSeq, trId);
	var params="gradeSeq="+gradeSeq;
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/gradeManageDetail.do'/>",
	    data:params,
	    //contentType: "application/json",
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			   
			if(searchData.size != 0){
				parent.document.gradeSearchVO.selectedGradeId.value = searchData.list[0].id;
				parent.document.gradeSearchVO.gradeNameDT.value = searchData.list[0].groupname;
				parent.document.gradeSearchVO.gradeSortDT.value = searchData.list[0].sortOrder;
				
				if(searchData.list[0].deleted == "1") {
					parent.document.gradeSearchVO.deleteYnDT.checked = true;
				} else {
					parent.document.gradeSearchVO.deleteYnDT.checked = false;
				}
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}
</script>
</head>
<body onload="init();">
<form:form commandName="gradeSearchVO" name="gradeSearchVO" method="post">
<input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(gradeList)}" />
<table  width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top" height="">
		<td>
			<table width="100%" height="" cellpadding="0" cellspacing="0" style="border: 1px solid #cbe0dd; border-collapse: collapse;">
			
				<tr height="27px">
					<td width="30px" align="center" class="list_header">
						No
						<input type="hidden" id="maxPage" name="maxPage" value="${maxPage+1}" />
						<input type="hidden" id="totalCount" name="totalCount" value="${totalCount}" />
					</td>
					<td width="" align="center" class="list_header">
						권한조직명
					</td>
					<td width="60px" align="center" class="list_header">
						코드
					</td>
					<td width="60px" align="center" class="list_header">
						정렬
					</td>
					<td width="60px" align="center" class="list_header">
						삭제여부
					</td>
				</tr>
				
			<c:if test="${fn:length(gradeList) == 0}">
				<tr height="72px">
					<td height="72px" colspan="5" align="center" class="list_no_result"><spring:message code='common.nodata.message' /></td>
				</tr>
			</c:if>
			
			<c:forEach var="result" items="${gradeList}" varStatus="status">
				<tr height="24px" id='tr_<c:out value="${status.count}"/>' onclick="javascript:fn_grade_detail('<c:out value="${result.id}"/>', '<c:out value="${status.count}"/>');" onMouseOver="overColor('<c:out value="${status.count}"/>')" onMouseOut="outColor('<c:out value="${status.count}"/>')">
					<td width="30px"  align="center" class="list_value">
						<c:out value="${status.count + cnt}"/>
					</td>
					<td width="" align="center" class="list_value">
						<c:out value="${result.groupName}"/>
					</td>
					<td width="60px" align="center" class="list_value">
						<c:out value="${result.id}"/>
					</td>
					<td width="60px" align="center" class="list_value">
						<c:out value="${result.sortOrder}"/>
					</td>
					<td width="60px" align="center" class="list_value">
					<c:if test="${result.deleted == 0}">
						<input type="checkbox" disabled="disabled"/>
					</c:if>
					<c:if test="${result.deleted != 0}">
						<input type="checkbox"  checked="checked" disabled="disabled"/>
					</c:if>
					</td>
				</tr>
			</c:forEach>
			
			</table>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>
