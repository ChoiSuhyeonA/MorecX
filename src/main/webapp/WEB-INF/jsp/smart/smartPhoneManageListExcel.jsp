<%-- 
- ������ ���� : ����Ʈ������
- ������ ID : smartPhoneManageListExcel.jsp
- ���۱� : �� ���̾˸�ũ
- �ۼ��� : �ۿ
- �ۼ����� : 2019-06-07
- ���� : ����Ʈ�� �˻������ ������ export ǥ��
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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	response.setHeader("Cache-Control","cache, must-revalidate");
	response.setHeader("Content-Disposition","attachment;filename=SmartPhoneManageList.xls");
	response.setHeader("Content-Description","JSP Generated Data");
	//out.clearBuffer();

%>
<body>
<table border="1">
<tr>
 	<td rowspan="3" width="40px" align="center">No</td>
 	<td rowspan="3" width="300px" align="center"><spring:message code='message.group' /></td>
 	<td rowspan="3" width="100px" align="center">��ȭ��ȣ</td>
 	<td rowspan="3" width="130px" align="center">IMEI</td>
 	<td rowspan="3" width="100px" align="center">������</td>
    <td rowspan="3" width="70px" align="center">����</td>
    <td rowspan="3" width="70px" align="center">�۾���</td>
    <td rowspan="3" width="300px" align="center">Ư�̻���</td>
</tr>
<tr>
</tr>
<tr>
</tr>
<c:if test="${fn:length(smartPhoneList) == 0}">
<tr><td align="center" colspan="21"><spring:message code='common.nodata.message' /></td></tr>
</c:if>
<c:choose>
<c:when test="${fn:length(smartPhoneList) > 0}">
<c:forEach var="result" items="${smartPhoneList}" varStatus="status">
<tr>
	<td width="50px"><c:out value="${status.count + cnt}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.groupId}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.phoneNumber}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.imei}" /></td>
	<td style="mso-number-format:'\@'"><fmt:formatDate value="${result.dateUpdated}" pattern="yyyy-MM-dd"/></td>
	<td style="mso-number-format:'\@'">
		<c:if test="${result.useStatusFlag == 'Y'}">
			���&nbsp;
		</c:if>
		<c:if test="${result.useStatusFlag == 'N'}">
			�̻��&nbsp;
		</c:if>
	</td>
	<td style="mso-number-format:'\@'"><c:out value="${result.updateUserId}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.memo}" /></td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</table>
</body>
</html>
