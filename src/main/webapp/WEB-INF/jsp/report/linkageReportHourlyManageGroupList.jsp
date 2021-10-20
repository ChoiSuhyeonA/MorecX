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
<title></title>
<script language="javascript" src="<c:url value='/jquery/js/util.js'/>"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/common.js'/>"></script>
<script type="text/javascript">

$(document).ready(function(){
	parent.chngBtnSearch('end');	//조회중 버튼처리
	
	$('#nonScrollTitle u:first').click(function(){ 
		parent.sortField('usr.firstname');
		parent.searchReportList();
	});
	$('div[id$=crollTable] tr').click(function(){ 
		if(this.id != '')
			changeLine2('true', this.id.substring(3)); 
	});
	$('div[id$=crollTable] tr').mouseover(function(){
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length-1);
			overColor(vId + 'L');
			overColor(vId + 'R');
		}
	});
	$('div[id$=crollTable] tr').mouseout(function(){ 
		if(this.id != ''){
			var vId = this.id.substring(3, this.id.length-1);
			outColor(vId + 'L');
			outColor(vId + 'R');
		}
	});
});

</script>
</head>
<body>
<form:form method="post">
<%/*전체를 감싸는 테이블 */ %>
<table width="1170px" cellpadding="0" cellspacing="0" border="0" style="overflow:hidden;" >
	<tr>
		<td style="vertical-align:top" width="300px">
			<%/*왼쪽 전체를 감싸는 테이블 (스크롤 자리 만들기) */ %>
			<table border="0" cellspacing="0" cellpadding="0" >
				<tr>
					<td>
					<%/*왼쪽 타이틀 고정 테이블*/ %>
						<table id="nonScrollTitle" width="300px" class="list_table_box" border="0" cellspacing="0" cellpadding="0" >
							<tr>
								<td width="50px" align="center" class="list_header_report" style="height:78px">
									<div style='width:48px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
										No
									</div>
								</td>
								<td width="250px" align="center" class="list_header_report">
									<div style='width:248px;overflow:hidden;text-align:center;text-overflow:ellipsis;white-space:nowrap;'>
										<spring:message code='message.group' />
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="300px" height="396px">
					<%/*왼쪽 고정 테이블 */ %>
					<c:if test="${fn:length(reportList) == 0}">
					<div style="width:300px; height:396px; overflow:hidden; border:none;">
						<table width="300px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
							<tr><td class="list_value">&nbsp;</td></tr>
						</table>
					</div>
					</c:if>
					<c:choose>
					<c:when test="${fn:length(reportList) > 0}">
					<div id="nonScrollTable" style="width:300px; height:396px; overflow:hidden; border:none;">
						<table width="300px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
						<c:forEach var="result" items="${reportList}" varStatus="status">
							<tr id="tr_<c:out value="${status.count}"/>L" >
								<td width="50px" align="center" class="list_value">
									<div style='width:48px;overflow:hidden;text-align:right;text-overflow:ellipsis;white-space:nowrap;'>
										<c:out value="${status.count}" />&nbsp;
									</div>
								</td>
								<td width="250px" align="center" class="list_value">
									<div style='width:248px;overflow:hidden;text-align:left;text-overflow:ellipsis;white-space:nowrap;'>
										&nbsp;<c:out value="${result.groupId}" />
									</div>
								</td>
							</tr>
						</c:forEach>
							<tr id="">
								<td colspan="2" align="center" class="list_value"><spring:message code='message.sum' />
								</td>
							</tr>
						</table>
					</div>
					</c:when>
					</c:choose>
					</td>
				</tr>
			</table>
		</td>
		<td><!-- 오른쪽 테이블 -->
			<table border="0px" style="width:100%;" cellspacing="0" cellpadding="0" >
				<tr>
				 	<td>
			 		<%/* 오른쪽 타이틀테이블 */ %>
			 		<div id="topTable" style="width:853px; overflow:hidden;">
						<table width="5526px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" style="border-left:0xp;">
						<tr>
							<td class="list_header_report" colspan="6" align="center" style="border-left:0px;">00 ~ 09</td>
							<td class="list_header_report" colspan="6" align="center">00 ~ 09</td>
		                	<td class="list_header_report" colspan="6" align="center">09 ~ 10</td>
		                	<td class="list_header_report" colspan="6" align="center">10 ~ 11</td>
		                	<td class="list_header_report" colspan="6" align="center">11 ~ 12</td>
		                	<td class="list_header_report" colspan="6" align="center">12 ~ 13</td>
		                	<td class="list_header_report" colspan="6" align="center">13 ~ 14</td>
		                	<td class="list_header_report" colspan="6" align="center">14 ~ 15</td>
		                	<td class="list_header_report" colspan="6" align="center">15 ~ 16</td>
		                	<td class="list_header_report" colspan="6" align="center">16 ~ 17</td>
		                	<td class="list_header_report" colspan="6" align="center">17 ~ 18</td>
		                	<td class="list_header_report" colspan="6" align="center">18 ~ 19</td>
		                	<td class="list_header_report" colspan="6" align="center">19 ~ 20</td>
		                	<td class="list_header_report" colspan="6" align="center">20 ~ 21</td>
		                	<td class="list_header_report" colspan="6" align="center">21 ~ 22</td>
		                	<td class="list_header_report" colspan="6" align="center">22 ~ 23</td>
		                	<td class="list_header_report" colspan="6" align="center">23 ~ 24</td>
						</tr>
						<tr>
							<td class="list_header_report" colspan="2" align="center" style="border-left:0px;"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	
		                	<td class="list_header_report" colspan="2" align="center" ><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.total' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.outbound' /></td>
		                	<td class="list_header_report" colspan="2" align="center"><spring:message code='message.inbound' /></td>
		                </tr>
						<tr>
							<td class="list_header_report" width="54px" align="center" style="border-left:0px;"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="60px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="60px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="60px" align="center"><spring:message code='message.session' /></td>
							
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.count' /></td>
							<td class="list_header_report" width="54px" align="center"><spring:message code='message.session' /></td>
						</tr>
						</table>
					</div>
					</td>
					<td>
						<table border="0" cellspacing="0" cellpadding="0" class="list_table_box">
							<tr><td class="list_header_report" width="17px" style="height:78px"></td></tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<%/* 오른쪽 내용 테이블 */ %>
						<c:if test="${fn:length(reportList) == 0}">
						<div style="width:870px; height:413px; overflow:hidden; border:none;">
							<table width="870px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" >
								<tr><td align="center" class="list_value" style="border-left:0px;"><spring:message code='common.nodata.message' /></td></tr>
							</table>
						</div>
						</c:if>
						<c:choose>
						<c:when test="${fn:length(reportList) > 0}">
						<div id="scrollTable" style="overflow:scroll; height:413px; width:870px;" onscroll="javascript:tableScrolling()" >
						<table width="5526px" border="0" cellspacing="0" cellpadding="0" class="list_table_box" style="border-left:0xp;">
						<c:forEach var="result" items="${reportList}" varStatus="status">
							<tr id='tr_<c:out value="${status.count}" />R' title='<c:out value="${result.firstName}" />' >
								<td class="list_value" width="54px" align="right" style="border-left:0px;"><%/* 전체통화건수 00~09*/%><c:out value="${result.cT16}" />&nbsp;</td>
								<td class="list_value" width="60px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT16}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO16}" />&nbsp;</td>
								<td class="list_value" width="60px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO16}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI16}" />&nbsp;</td>
								<td class="list_value" width="60px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI16}" /></td>

								<td class="list_value" width="54px" align="right" ><%/* 전체통화건수 00~09*/%><c:out value="${result.cT0}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT0}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO0}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO0}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI0}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI0}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 09~10*/%><c:out value="${result.cT1}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT1}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO1}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO1}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI1}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI1}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 10~11*/%><c:out value="${result.cT2}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT2}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO2}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO2}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI2}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI2}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 11~12*/%><c:out value="${result.cT3}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT3}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO3}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO3}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI3}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI3}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 12~13*/%><c:out value="${result.cT4}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT4}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO4}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO4}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI4}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI4}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 13~14*/%><c:out value="${result.cT5}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT5}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO5}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO5}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI5}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI5}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 14~15*/%><c:out value="${result.cT6}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT6}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO6}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO6}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI6}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI6}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 15~16*/%><c:out value="${result.cT7}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT7}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO7}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO7}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI7}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI7}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 16~17*/%><c:out value="${result.cT8}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT8}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO8}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO8}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI8}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI8}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 17~18*/%><c:out value="${result.cT9}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT9}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO9}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO9}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI9}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI9}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 18~19*/%><c:out value="${result.cT10}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT10}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO10}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO10}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI10}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI10}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 19~20*/%><c:out value="${result.cT11}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT11}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO11}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO11}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI11}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI11}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 20~21*/%><c:out value="${result.cT12}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT12}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO12}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO12}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI12}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI12}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 21~22*/%><c:out value="${result.cT13}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT13}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO13}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO13}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI13}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI13}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 22~23*/%><c:out value="${result.cT14}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT14}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO14}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO14}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI14}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI14}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 전체통화건수 23~24*/%><c:out value="${result.cT15}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 전체통화시간*/%><c:out value="${result.dT15}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 발신통화건수*/%><c:out value="${result.cO15}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 발신통화시간*/%><c:out value="${result.dO15}" /></td>
								<td class="list_value" width="54px" align="right"><%/* 수신통화건수*/%><c:out value="${result.cI15}" />&nbsp;</td>
								<td class="list_value" width="54px" align="center"><%/* 수신통화시간*/%><c:out value="${result.dI15}" /></td>
							</tr>
						</c:forEach>
							<tr>
								<td class="list_value" align="right" style="border-left:0px;"><%/* 전체통화건수 00~09*/%><c:out value="${totCnt.totCT16}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT16}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO16}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO16}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI16}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI16}" /></td>
								
								
								<td class="list_value" align="right" ><%/* 전체통화건수 00~09*/%><c:out value="${totCnt.totCT0}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT0}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO0}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO0}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI0}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI0}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 09~10*/%><c:out value="${totCnt.totCT1}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT1}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO1}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO1}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI1}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI1}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 10~11*/%><c:out value="${totCnt.totCT2}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT2}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO2}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO2}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI2}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI2}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 11~12*/%><c:out value="${totCnt.totCT3}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT3}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO3}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO3}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI3}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI3}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 12~13*/%><c:out value="${totCnt.totCT4}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT4}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO4}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO4}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI4}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI4}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 13~14*/%><c:out value="${totCnt.totCT5}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT5}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO5}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO5}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI5}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI5}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 14~15*/%><c:out value="${totCnt.totCT6}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT6}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO6}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO6}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI6}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI6}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 15~16*/%><c:out value="${totCnt.totCT7}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT7}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO7}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO7}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI7}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI7}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 16~17*/%><c:out value="${totCnt.totCT8}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT8}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO8}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO8}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI8}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI8}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 17~18*/%><c:out value="${totCnt.totCT9}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT9}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO9}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO9}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI9}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI9}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 18~19*/%><c:out value="${totCnt.totCT10}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT10}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO10}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO10}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI10}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI10}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 19~20*/%><c:out value="${totCnt.totCT11}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT11}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO11}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO11}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI11}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI11}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 20~21*/%><c:out value="${totCnt.totCT12}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT12}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO12}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO12}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI12}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI12}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 21~22*/%><c:out value="${totCnt.totCT13}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT13}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO13}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO13}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI13}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI13}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 22~23*/%><c:out value="${totCnt.totCT14}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT14}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO14}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO14}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI14}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI14}" /></td>
								<td class="list_value" align="right"><%/* 전체통화건수 23~24*/%><c:out value="${totCnt.totCT15}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 전체통화시간*/%><c:out value="${totCnt.totDT15}" /></td>
								<td class="list_value" align="right"><%/* 발신통화건수*/%><c:out value="${totCnt.totCO15}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 발신통화시간*/%><c:out value="${totCnt.totDO15}" /></td>
								<td class="list_value" align="right"><%/* 수신통화건수*/%><c:out value="${totCnt.totCI15}" />&nbsp;</td>
								<td class="list_value" align="center"><%/* 수신통화시간*/%><c:out value="${totCnt.totDI15}" /></td>
							</tr>
						</table>
						</div>
						</c:when>
						</c:choose>
					</td>
				</tr>
			</table>
		</td><!-- 오른쪽 전체테이블 끝 -->
	</tr>
</table>
</form:form>
</body>
</html>
