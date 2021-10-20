<%-- 
- ������ ���� : �����
- ������ ID : reportManageGroupListExcel.jsp
- ���۱� : �� ���̾˸�ũ
- �ۼ��� : ����ö
- �ۼ����� : 2013-09-11
- ���� : ����踦 ������ export ǥ��
- ���� method : N/A
- ���泻�� : 
- 
--%>

<meta http-equiv="Content-type" content="application/vns.ms-excel;charset=euc-kr">
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<%@ page language ="java" contentType="application/vnd.ms-excel; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	response.setHeader("Cache-Control","cache, must-revalidate");
	response.setHeader("Content-Disposition","attachment;filename=ReportGroupManageList.xls");
	response.setHeader("Content-Description","JSP Generated Data");
	//out.clearBuffer();

%>
<body>
<table border="1">
<tr>
 	<td rowspan="3" width="40px" align="center">No</td>
 	<td rowspan="3" width="300px" align="center"><spring:message code='message.group' /></td>
    <td colspan="6" align="center"><spring:message code='message.sum' /></td>
    <td colspan="3" align="center"><spring:message code='message.average' /></td>
</tr>
<tr>
	<td colspan="3" align="center"><spring:message code='message.call_count' />(total)</td>
	<td colspan="3" align="center"><spring:message code='message.call_time_report' />(total)</td>
	<td colspan="3" align="center"><spring:message code='message.call_time_report' />(total)</td>
</tr>
<tr>
	<td width="60px" align="center"><spring:message code='message.total' /></td>
	<td width="60px" align="center"><spring:message code='message.outbound' /></td>
	<td width="60px" align="center"><spring:message code='message.inbound' /></td>
	<td width="60px" align="center"><spring:message code='message.total' /></td>
	<td width="60px" align="center"><spring:message code='message.outbound' /></td>
	<td width="60px" align="center"><spring:message code='message.inbound' /></td>
	<td width="60px" align="center"><spring:message code='message.total' /></td>
	<td width="60px" align="center"><spring:message code='message.outbound' /></td>
	<td width="60px" align="center"><spring:message code='message.inbound' /></td>
</tr>
<c:if test="${fn:length(reportList) == 0}">
<tr><td align="center" colspan="21"><spring:message code='common.nodata.message' /></td></tr>
</c:if>
<c:choose>
<c:when test="${fn:length(reportList) > 0}">
<c:forEach var="result" items="${reportList}" varStatus="status">
<tr>
	<td width="50px"><c:out value="${status.count}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.groupId}" /></td>
	<td><%/* ��ü��ȭ�Ǽ�*/%><c:out value="${result.totCountCall}" /></td>
	<td><%/* �߽���ȭ�Ǽ�*/%><c:out value="${result.outCountCall}" /></td>
	<td><%/* ������ȭ�Ǽ�*/%><c:out value="${result.inCountCall}" /></td>
	<td><%/* ��ü��ȭ�ð�*/%><c:out value="${result.totDurationCall}" /></td>
	<td><%/* �߽���ȭ�ð�*/%><c:out value="${result.outDurationCall}" /></td>
	<td><%/* ������ȭ�ð�*/%><c:out value="${result.inDurationCall}" /></td>
	<td><%/* ��ü��ȭ��սð�*/%><c:out value="${result.totDurationAverage}" /></td>
	<td><%/* �߽���ȭ��սð�*/%><c:out value="${result.outDurationAverage}" /></td>
	<td><%/* ������ȭ��սð�*/%><c:out value="${result.inDurationAverage}" /></td>
</tr>
</c:forEach>
<tr bgcolor="#aaaaaa"  height="25px">
	<td colspan="2"><spring:message code='message.sum' /></td>
	<td><%/* ��ü��ȭ�Ǽ�*/%><c:out value="${totCnt.totCountCall}" />&nbsp;</td>
	<td><%/* �߽���ȭ�Ǽ�*/%><c:out value="${totCnt.outCountCall}" />&nbsp;</td>
	<td><%/* ������ȭ�Ǽ�*/%><c:out value="${totCnt.inCountCall}" />&nbsp;</td>
	<td><%/* ��ü��ȭ�ð�*/%><c:out value="${totCnt.totDurationCall}" /></td>
	<td><%/* �߽���ȭ�ð�*/%><c:out value="${totCnt.outDurationCall}" /></td>
	<td><%/* ������ȭ�ð�*/%><c:out value="${totCnt.inDurationCall}" /></td>
	<td><%/* ��ü��ȭ��սð�*/%><c:out value="${totCnt.totDurationAverage}" /></td>
	<td><%/* �߽���ȭ��սð�*/%><c:out value="${totCnt.outDurationAverage}" /></td>
	<td><%/* ������ȭ��սð�*/%><c:out value="${totCnt.inDurationAverage}" /></td>
</tr>
</c:when>
</c:choose>
</table>
</body>
</html>
