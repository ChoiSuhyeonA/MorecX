<%-- 
- 페이지 제목 : 콜통계
- 페이지 ID : reportHourlyManageGroupListExcel.jsp
- 저작권 : ㈜ 아이알링크
- 작성자 : 김정철
- 작성일자 : 2013-09-12
- 설명 : 콜통계를 엑셀로 export 표시
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
	response.setHeader("Content-Disposition","attachment;filename=ReportHourlyManageGroupList.xls");
	response.setHeader("Content-Description","JSP Generated Data");
	//out.clearBuffer();

%>
<body>
<table border="1">
<tr>
 	<td rowspan="3" width="40px" align="center">No</td>
 	<td rowspan="3" width="300px" align="center"><spring:message code='message.group' /></td>
 	<td colspan="6" align="center">전체</td>
    <td colspan="6" align="center">00 ~ 09</td>
    <td colspan="6" align="center">09 ~ 10</td>
    <td colspan="6" align="center">10 ~ 11</td>
    <td colspan="6" align="center">11 ~ 12</td>
    <td colspan="6" align="center">12 ~ 13</td>
    <td colspan="6" align="center">13 ~ 14</td>
    <td colspan="6" align="center">14 ~ 15</td>
    <td colspan="6" align="center">15 ~ 16</td>
    <td colspan="6" align="center">16 ~ 17</td>
    <td colspan="6" align="center">17 ~ 18</td>
    <td colspan="6" align="center">18 ~ 19</td>
    <td colspan="6" align="center">19 ~ 20</td>
    <td colspan="6" align="center">20 ~ 21</td>
    <td colspan="6" align="center">21 ~ 22</td>
    <td colspan="6" align="center">22 ~ 23</td>
    <td colspan="6" align="center">23 ~ 24</td>
</tr>
<tr>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.total' /></td>
	<td colspan="2" align="center"><spring:message code='message.outbound' /></td>
	<td colspan="2" align="center"><spring:message code='message.inbound' /></td>
</tr>
<tr>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
	<td width="60px" align="center"><spring:message code='message.count' /></td>
	<td width="60px" align="center"><spring:message code='message.session' /></td>
</tr>
<c:if test="${fn:length(reportList) == 0}">
<tr><td align="center" colspan="102"><spring:message code='common.nodata.message' /></td></tr>
</c:if>
<c:choose>
<c:when test="${fn:length(reportList) > 0}">
<c:forEach var="result" items="${reportList}" varStatus="status">
<tr>
	<td><c:out value="${status.count}" /></td>
	<td style="mso-number-format:'\@'"><c:out value="${result.groupId}" /></td>
	<td><%/* 전체통화건수 00~09*/%><c:out value="${result.cT16}" />&nbsp;</td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT16}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO16}" />&nbsp;</td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO16}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI16}" />&nbsp;</td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI16}" /></td>
	
	<td><%/* 전체통화건수 00~09*/%><c:out value="${result.cT0}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT0}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO0}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO0}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI0}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI0}" /></td>
	<td><%/* 전체통화건수 09~10*/%><c:out value="${result.cT1}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT1}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO1}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO1}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI1}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI1}" /></td>
	<td><%/* 전체통화건수 10~11*/%><c:out value="${result.cT2}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT2}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO2}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO2}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI2}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI2}" /></td>
	<td><%/* 전체통화건수 11~12*/%><c:out value="${result.cT3}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT3}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO3}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO3}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI3}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI3}" /></td>
	<td><%/* 전체통화건수 12~13*/%><c:out value="${result.cT4}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT4}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO4}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO4}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI4}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI4}" /></td>
	<td><%/* 전체통화건수 13~14*/%><c:out value="${result.cT5}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT5}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO5}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO5}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI5}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI5}" /></td>
	<td><%/* 전체통화건수 14~15*/%><c:out value="${result.cT6}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT6}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO6}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO6}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI6}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI6}" /></td>
	<td><%/* 전체통화건수 15~16*/%><c:out value="${result.cT7}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT7}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO7}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO7}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI7}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI7}" /></td>
	<td><%/* 전체통화건수 16~17*/%><c:out value="${result.cT8}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT8}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO8}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO8}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI8}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI8}" /></td>
	<td><%/* 전체통화건수 17~18*/%><c:out value="${result.cT9}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT9}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO9}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO9}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI9}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI9}" /></td>
	<td><%/* 전체통화건수 18~19*/%><c:out value="${result.cT10}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT10}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO10}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO10}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI10}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI10}" /></td>
	<td><%/* 전체통화건수 19~20*/%><c:out value="${result.cT11}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT11}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO11}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO11}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI11}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI11}" /></td>
	<td><%/* 전체통화건수 20~21*/%><c:out value="${result.cT12}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT12}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO12}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO12}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI12}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI12}" /></td>
	<td><%/* 전체통화건수 21~22*/%><c:out value="${result.cT13}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT13}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO13}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO13}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI13}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI13}" /></td>
	<td><%/* 전체통화건수 22~23*/%><c:out value="${result.cT14}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT14}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO14}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO14}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI14}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI14}" /></td>
	<td><%/* 전체통화건수 23~24*/%><c:out value="${result.cT15}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${result.dT15}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${result.cO15}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${result.dO15}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${result.cI15}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${result.dI15}" /></td>
</tr>
</c:forEach>
<tr bgcolor="#aaaaaa"  height="25px">
	<td colspan="2"><spring:message code='message.sum' /></td>
	<td><%/* 전체통화건수 00~09*/%><c:out value="${totCnt.totCT16}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT16}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO16}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO16}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI16}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI16}" /></td>
	
	<td><%/* 전체통화건수 00~09*/%><c:out value="${totCnt.totCT0}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT0}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO0}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO0}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI0}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI0}" /></td>
	<td><%/* 전체통화건수 09~10*/%><c:out value="${totCnt.totCT1}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT1}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO1}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO1}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI1}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI1}" /></td>
	<td><%/* 전체통화건수 10~11*/%><c:out value="${totCnt.totCT2}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT2}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO2}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO2}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI2}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI2}" /></td>
	<td><%/* 전체통화건수 11~12*/%><c:out value="${totCnt.totCT3}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT3}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO3}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO3}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI3}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI3}" /></td>
	<td><%/* 전체통화건수 12~13*/%><c:out value="${totCnt.totCT4}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT4}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO4}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO4}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI4}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI4}" /></td>
	<td><%/* 전체통화건수 13~14*/%><c:out value="${totCnt.totCT5}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT5}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO5}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO5}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI5}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI5}" /></td>
	<td><%/* 전체통화건수 14~15*/%><c:out value="${totCnt.totCT6}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT6}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO6}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO6}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI6}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI6}" /></td>
	<td><%/* 전체통화건수 15~16*/%><c:out value="${totCnt.totCT7}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT7}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO7}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO7}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI7}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI7}" /></td>
	<td><%/* 전체통화건수 16~17*/%><c:out value="${totCnt.totCT8}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT8}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO8}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO8}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI8}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI8}" /></td>
	<td><%/* 전체통화건수 17~18*/%><c:out value="${totCnt.totCT9}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT9}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO9}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO9}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI9}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI9}" /></td>
	<td><%/* 전체통화건수 18~19*/%><c:out value="${totCnt.totCT10}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT10}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO10}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO10}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI10}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI10}" /></td>
	<td><%/* 전체통화건수 19~20*/%><c:out value="${totCnt.totCT11}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT11}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO11}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO11}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI11}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI11}" /></td>
	<td><%/* 전체통화건수 20~21*/%><c:out value="${totCnt.totCT12}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT12}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO12}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO12}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI12}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI12}" /></td>
	<td><%/* 전체통화건수 21~22*/%><c:out value="${totCnt.totCT13}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT13}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO13}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO13}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI13}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI13}" /></td>
	<td><%/* 전체통화건수 22~23*/%><c:out value="${totCnt.totCT14}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT14}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO14}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO14}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI14}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI14}" /></td>
	<td><%/* 전체통화건수 23~24*/%><c:out value="${totCnt.totCT15}" /></td>
	<td><%/* 전체통화시간*/%><c:out value="${totCnt.totDT15}" /></td>
	<td><%/* 발신통화건수*/%><c:out value="${totCnt.totCO15}" /></td>
	<td><%/* 발신통화시간*/%><c:out value="${totCnt.totDO15}" /></td>
	<td><%/* 수신통화건수*/%><c:out value="${totCnt.totCI15}" /></td>
	<td><%/* 수신통화시간*/%><c:out value="${totCnt.totDI15}" /></td>
</tr>
</c:when>
</c:choose>
</table>
</body>
</html>
