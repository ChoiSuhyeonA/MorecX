<%-- 
- 페이지 제목 : 통화길이별콜통계
- 페이지 ID : reportDurationManageListExcel.jsp
- 저작권 : ㈜ 아이알링크
- 작성자 : 김정철
- 작성일자 : 2013-09-04
- 설명 : 통화길이별콜통계를 엑셀로 export 표시
- 연관 method : N/A
- 변경내역 : 
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
	response.setHeader("Content-Disposition","attachment;filename=ReportDurationManageList.xls");
	response.setHeader("Content-Description","JSP Generated Data");
	//out.clearBuffer();

%>
<body>
<table border="1">
<tr>
 	<td width="40px" align="center" rowspan="2">No</td>
 	<td width="300px" align="center" rowspan="2"><spring:message code='message.group' /></td>
 	<td width="100px" align="center" rowspan="2"><spring:message code='message.user' /></td>
 	<td width="100px" align="center" rowspan="2"><spring:message code='message.user_id' /></td>
 	<td width="100px" align="center" rowspan="2"><spring:message code='message.camp_name' /></td>
 	<td width="100px" align="center" rowspan="2"><spring:message code='message.local_party' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.sum' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.less1' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.from1to5' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.from5to10' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.from10to20' /></td>
    <td colspan="3" width="180px" align="center"><spring:message code='message.more20' /></td>
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
<tr><td align="center" colspan="24"><spring:message code='common.nodata.message' /></td></tr>
</c:if>
<c:choose>
<c:when test="${fn:length(reportList) > 0}">
<c:forEach var="result" items="${reportList}" varStatus="status">
<tr>
	<td width="50px"><c:out value="${status.count}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.groupPath}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.firstName}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.userId}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.campaignName}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.phoneno}" /></td>
	<td><c:out value="${result.tO + result.tI}" /></td>
	<td><c:out value="${result.tO}" /></td>
	<td><c:out value="${result.tI}" /></td>
	<td><c:out value="${result.less1O + result.less1I}" /></td>
	<td><c:out value="${result.less1O}" /></td>
	<td><c:out value="${result.less1I}" /></td>
	<td><c:out value="${result.less2O + result.less2I}" /></td>
	<td><c:out value="${result.less2O}" /></td>
	<td><c:out value="${result.less2I}" /></td>
	<td><c:out value="${result.less3O + result.less3I}" /></td>
	<td><c:out value="${result.less3O}" /></td>
	<td><c:out value="${result.less3I}" /></td>
	<td><c:out value="${result.less4O + result.less4I}" /></td>
	<td><c:out value="${result.less4O}" /></td>
	<td><c:out value="${result.less4I}" /></td>
	<td><c:out value="${result.less5O + result.less5I}" /></td>
	<td><c:out value="${result.less5O}" /></td>
	<td><c:out value="${result.less5I}" /></td>
</tr>
</c:forEach>
<tr bgcolor="#aaaaaa"  height="25px">
		<td colspan="3" align="center"><spring:message code='message.sum' /></td>
		<td></td>
		<td></td>
		<td></td>
		<td align="right"><c:out value="${totCnt.i0 + totCnt.o0}" /></td>
		<td align="right"><c:out value="${totCnt.o0}" /></td>
		<td align="right"><c:out value="${totCnt.i0}" /></td>
		<td align="right"><c:out value="${totCnt.i1 + totCnt.o1}" /></td>
		<td align="right"><c:out value="${totCnt.o1}" /></td>
		<td align="right"><c:out value="${totCnt.i1}" /></td>
		<td align="right"><c:out value="${totCnt.i2 + totCnt.o2}" /></td>
		<td align="right"><c:out value="${totCnt.o2}" /></td>
		<td align="right"><c:out value="${totCnt.i2}" /></td>
		<td align="right"><c:out value="${totCnt.i3 + totCnt.o3}" /></td>
		<td align="right"><c:out value="${totCnt.o3}" /></td>
		<td align="right"><c:out value="${totCnt.i3}" /></td>
		<td align="right"><c:out value="${totCnt.i4 + totCnt.o4}" /></td>
		<td align="right"><c:out value="${totCnt.o4}" /></td>
		<td align="right"><c:out value="${totCnt.i4}" /></td>
		<td align="right"><c:out value="${totCnt.i5 + totCnt.o5}" /></td>
		<td align="right"><c:out value="${totCnt.o5}" /></td>
		<td align="right"><c:out value="${totCnt.i5}" /></td>
</tr>
</c:when>
</c:choose>
</table>
</body>
</html>
