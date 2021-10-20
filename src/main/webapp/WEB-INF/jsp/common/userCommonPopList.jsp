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
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">

<% /* 리스트 클릭시 */ %>
$(function() {
	
	$('.group_list').bind({
		click : function() {
			$('span tr').attr("bgcolor","#ffffff");
			$('#'+this.id).attr("bgcolor","#e0f5f5");
			
			$('#hidUserName').val( $.trim($(this).children("#userName").text()) );
			$('#hidUserId').val( $.trim($(this).children("#userId").text()) );
		},
		
		dblclick : function() {
			$('.group_list').attr("bgcolor","#ffffff");
			$('#'+this.id).attr("bgcolor","#e0f5f5");
			
			$('#hidUserName').val( $.trim($(this).children("#userName").text()) );
			$('#hidUserId').val( $.trim($(this).children("#userId").text()) );
			
			parent.setParam();
			parent.self.close();
		}
	})
});


<% /* 리스트 더블 클릭시 */ %>

</script>
</head>
<body>
<form:form commandName="cmnUserSearchVO" id="cmnUserSearchVO" name="cmnUserSearchVO" method="post">
<%-- <input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(groupList)}" /> --%>

<!-- 리스트 클릭 값 -->
<input type="hidden" id="hidUserName" value="" />
<input type="hidden" id="hidUserId" value="" />

<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;" bordercolor="#c6e3ed">
	<tr height="20px">
		<td width="40px" align="center" style="font-family: 돋움;font-size: 11px; color: #737373;" background="<c:url value='/images/bg/bg_table_header.gif' />">No</td>
		<td width="100px" align="center" style="font-family: 돋움;font-size: 11px; color: #737373;" background="<c:url value='/images/bg/bg_table_header.gif' />">사용자 아이디</td>
		<td width="" align="center" style="font-family: 돋움;font-size: 11px; color: #737373;" background="<c:url value='/images/bg/bg_table_header.gif' />">사용자명</td>
	</tr>
	<span>
	<c:forEach var="result" items="${userList}" varStatus="status">
		<tr height="20px" id="tr_<c:out value="${status.count}"/>" style="cursor: hand;" class="group_list">
			<td id="no" width="" style="font-family: 돋움;font-size: 11px; color: #737373;" align="right">
				<c:out value="${status.count}"/>&nbsp;
			</td>
			<td id="userId" width="" style="font-family: 돋움;font-size: 11px; color: #737373;" align="right">
				<c:out value="${result.zirecxId}"/>&nbsp;
			</td>
			<td id="userName" width="" style="font-family: 돋움;font-size: 11px; color: #737373;" align="left">
				&nbsp;<c:out value="${result.firstname}"/>
			</td>
		</tr>
	</c:forEach>
	</span>
	
	<tr><td colspan="3"></td></tr>
</table>
</form:form>
</body>
</html>