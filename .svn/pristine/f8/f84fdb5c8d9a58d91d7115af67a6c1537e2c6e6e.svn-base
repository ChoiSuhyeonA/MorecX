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
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript">

function showDetail(trId, gradeName, gradeSeq){
	changeLine(gradeSeq, trId);
	top.document.getElementById("gradeName").value = gradeName;
	top.document.getElementById("gradeSeq").value = gradeSeq;
}

function selectGroup(gradeName, gradeSeq)
{	
	if(gradeSeq == ""){alert("선택된 권한이 없습니다."); return;}
	eval("top.win.OPENER.document.getElementById('" + top.win.strGradeNameParam +"')").value = gradeName;
	eval("top.win.OPENER.document.getElementById('" + top.win.strGradeSeqParam +"')").value = gradeSeq;
	
	self.close();
}

</script>
</head>
<body>
<form:form commandName="cmnUserSearchVO" id="cmnUserSearchVO" name="cmnUserSearchVO" method="post">
<%-- <input type="hidden" name="hidListCount" id="hidListCount" value="${fn:length(groupList)}" /> --%>
<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;" bordercolor="#c6e3ed">
	<tr height="20px">
		<td width="40px" align="center" class="list_header">No</td>
		<td width="150px" align="center" class="list_header">권한조직명</td>
		<td width="" align="center" class="list_header">권한조직코드</td>
	</tr>
	<span>
	<c:forEach var="result" items="${gradePopList}" varStatus="status">
		<tr height="20px" id="tr_<c:out value="${status.count}"/>" style="cursor: hand;" onclick="showDetail('<c:out value="${status.count}"/>','<c:out value="${result.groupName}"/>','<c:out value="${result.id}"/>');" ondblclick="selectGroup('<c:out value="${result.groupName}"/>','<c:out value="${result.id}"/>')" style="cursor:hand" onMouseOver="overColor('<c:out value="${status.count}"/>')" onMouseOut="outColor('<c:out value="${status.count}"/>')">
			<td id="no" width="" class="list_value" align="right">
				<c:out value="${status.count}"/>&nbsp;
			</td>
			<td id="groupName" width="" class="list_value" align="left">
				&nbsp;<c:out value="${result.groupName}"/>
			</td>
			<td id="id" width="" class="list_value" align="left">
				&nbsp;<c:out value="${result.id}"/>
			</td>
		</tr>
	</c:forEach>
	</span>
	
	<tr><td colspan="3"></td></tr>
</table>
</form:form>
</body>
</html>