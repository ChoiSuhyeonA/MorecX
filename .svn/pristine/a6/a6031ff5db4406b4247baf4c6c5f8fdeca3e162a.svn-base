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
<style type="text/css">
 /* td {border:solid 1 #C6E3ED; border-collapse: collapse;} */
</style>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">

<% /* 리스트 클릭시 */ %>
$(function() {
	$('.group_list').bind({
		click : function() {
			$('.group_list').attr("bgcolor","#ffffff");
			$('#'+this.id).attr("bgcolor","#e0f5f5");
			
			arrGroupName = $.trim($(this).children("#groupNameUpper").text()).split("/");
			
			$('#hidGroupName').val( arrGroupName[arrGroupName.length-1] );
			$('#hidGroupId').val( $.trim($(this).children("#groupId").text()) );
			
		
		},
		
		dblclick : function() {
			$('.group_list').attr("bgcolor","#ffffff");
			$('#'+this.id).attr("bgcolor","#e0f5f5");
			
			arrGroupName = $.trim($(this).children("#groupNameUpper").text()).split("/");
			
			$('#hidGroupName').val( arrGroupName[arrGroupName.length-1] );
			$('#hidGroupId').val( $.trim($(this).children("#groupId").text()) );
			$('#hidOfficeCode').val( $.trim($(this).children("#officeCode").text()) );
			$('#hidGroupCode').val( $.trim($(this).children("#groupCode").text()) );

			parent.setParam();
			parent.self.close();
		}
	})
});


<% /* 리스트 더블 클릭시 */ %>

</script>
</head>
<body>
<form:form commandName="cmnGroupSearchVO" id="cmnGroupSearchVO" name="cmnGroupSearchVO" method="post">
<%-- <input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(groupList)}" /> --%>

<!-- 리스트 클릭 값 -->
<input type="hidden" id="hidGroupName" value="" />
<input type="hidden" id="hidGroupId" value="" />
<input type="hidden" id="hidOfficeCode" value="" />
<input type="hidden" id="hidGroupCode" value="" />

<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="border:solid 1 #C6E3ED; border-collapse: collapse;" >
	<tr height="20px">
		<td width="40px" align="center" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" background="<c:url value='/images/bg/bg_table_header.gif' />">No</td>
		<td width="70px" align="center" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" background="<c:url value='/images/bg/bg_table_header.gif' />">센터 아이디</td>
		<td width="" align="center" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" background="<c:url value='/images/bg/bg_table_header.gif' />" colspan="3">센터명</td>
	</tr>
	<span>
	<c:forEach var="result" items="${groupList}" varStatus="status">
		<tr height="20px" id="tr_<c:out value="${status.count}"/>" style="cursor: hand;" class="group_list">
			<td id="no" width="" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" align="right">
				<c:out value="${status.count}"/>&nbsp;
			</td>
			<td id="groupId" width="" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" align="right">
				<c:out value="${result.groupId}"/>&nbsp;
			</td>
			<td id="groupNameUpper" width="" style="font-family: 돋움;font-size: 11px; color: #737373; border:solid 1 #C6E3ED; border-collapse: collapse;" align="left">
				&nbsp;<c:out value="${result.parentGroupName}"/>
			</td>
			<td id="officeCode" width="0" style="font-size: 0px; display:none;">
				<c:out value="${result.officeCode}"/>
			</td>
			<td id="groupCode" width="0" style="font-size: 0px; display:none;">
				<c:out value="${result.groupCode}"/>
			</td>
		</tr>
	</c:forEach>
	</span>
	
	<tr><td colspan="3"></td></tr>
</table>
</form:form>
</body>
</html>