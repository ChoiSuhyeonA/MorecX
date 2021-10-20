<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<style>
TD {
	font-family:Dotum,DotumChe,Gulim;
	font-size:12px;
	color:#000000;
	font-weight: normal;
	word-break:break-all;
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<title>Left MENU</title>
<script language="javascript">
$(window).load(function() {
	var bigMenuDiv1 = false; 	
	$('#bigMenuDiv1').find("div").each(function(idx, item) {
	    if($(item).attr("display") != "none") {
	    	bigMenuDiv1 = true; 	
	    } 
	});
	if (!bigMenuDiv1){ 
		$('#bigMenuDiv1').css("display", "none");
	}
	
	var bigMenuDiv2 = false; 	
	$('#bigMenuDiv2').find("div").each(function(idx, item) {
	    if($(item).attr("display") != "none") {
	    	bigMenuDiv2 = true; 	
	    } 
	});
	if (!bigMenuDiv2){ 
		$('#bigMenuDiv2').css("display", "none");
	}
	
	var bigMenuDiv3 = false; 	
	$('#bigMenuDiv3').find("div").each(function(idx, item) {
	    if($(item).attr("display") != "none") {
	    	bigMenuDiv3 = true; 	
	    } 
	});
	if (!bigMenuDiv3){ 
		$('#bigMenuDiv3').css("display", "none");
	}
	
	var bigMenuDiv4 = false; 	
	$('#bigMenuDiv4').find("div").each(function(idx, item) {
	    if($(item).attr("display") != "none") {
	    	bigMenuDiv4 = true; 	
	    } 
	});
	if (!bigMenuDiv4){ 
		$('#bigMenuDiv4').css("display", "none");
	}
	
	var bigMenuDiv5 = false; 	
	$('#bigMenuDiv5').find("div").each(function(idx, item) {
	    if($(item).attr("display") != "none") {
	    	bigMenuDiv5 = true; 	
	    } 
	});
	if (!bigMenuDiv5){ 
		$('#bigMenuDiv5').css("display", "none");
	}
});	

	var strOpenTrId;
	
	function viewSubMenu(tr_id) {
		var i;
		var j;
		
		var viewSub = eval(document.getElementsByName("smallMenu" +tr_id));
		
		for (i=0 ;i< viewSub.length; i++){
			if(viewSub(i).display){
				viewSub(i).style.display = viewSub(i).display;
			} else {
				viewSub(i).style.display = "none";
			}
			
		}
		
		if(strOpenTrId != ""){
			var closeSub = eval(document.getElementsByName("smallMenu" +strOpenTrId));
			for (j=0 ;j< closeSub.length; j++){
				closeSub(j).style.display = "none";
			}
		}
						
		if(strOpenTrId != tr_id){
			strOpenTrId = tr_id;
		}else{
			strOpenTrId = "";
		}
	}
	
	function choiceMenu(id, url) {
		
		if(id.substring(0,7) == "bigMenu") {
			if(document.getElementById("smallMenu" +id.substring(7,12)) == null) {
				parent.document.getElementById("hiddenUrl").value = url;
				parent.document.getElementById("hidMenuId").value = menuId;
				parent.slideCateScroll();
				parent.submit();
			}
		} else if(id.substring(0,9) == "smallMenu") {
			//parent.document.getElementById("hiddenUrl").value = url;
			//parent.document.getElementById("hidMenuId").value = menuId;
			parent.slideCateScroll();
			parent.iframeMain.location.href = url;
			//parent.submit();
		}
	}
	
	function logout() {
		top.topFrame.logoutInit('button');
	}
	
	
</script>
</head>

<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" oncontextmenu="return false" ondragstart="return false">
	<form:form id="form_leftMenu">
		<table width="173px" height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table width="" height="100%" border="0" cellspacing="0" cellpadding="0">
						<tr height="143px">
							<td align="center">
								<table border="0" cellpadding="0" cellspacing="0" width="" height="143px">
									<tr>
										<td width="159px" height="11px" background="<c:url value='/images/bg/leftMenuTop1.gif' />">
									</tr>
									<tr>
										<td width="159px" height="127px" background="<c:url value='/images/bg/leftMenuBg.gif' />"> &nbsp; <font color="#ffffff"> <b></b> </font></td>
									</tr>
									<tr>
										<td width="159px" height="5px" background="<c:url value='/images/bg/leftMenuTop2.gif' />"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="">
							<td valign="top">
								<table width="159px" height="100%" border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBg.gif' />">
									<tr id="bigMenuDiv1" height="30px" valign="top">
										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr id="bigMenu1" height="30px" style="cursor: hand;" onclick="viewSubMenu('1');">
													<td width="5%"></td>
													<td width="10%"><img src="<c:url value='/images/icon/icon_big_dot.gif' />" /></td>
													<td width="85%"><font color="#ffffff"> <b>녹취청취</b> </font></td>
												</tr>
												<tr height="1">
													<td colspan="3"><img src="<c:url value='/images/menu/cmDotLine.gif' />"></td>
												</tr>
											</table>
											<div id="smallMenu1" name="smallMenu1" style="display: none;" display="<c:out value="${sessionScope.linkCallManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu1', '<c:url value='/record/linkCallManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>녹취청취</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu1" name="smallMenu1" style="display: none;" display="<c:out value="${sessionScope.linkPenCallManageMainAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu1', '<c:url value='/record/linkPenCallManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>펜녹취이력조회</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu1" name="smallMenu1" style="display: none;" display="<c:out value="${sessionScope.callHistoryManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu1', '<c:url value='/record/callHistoryManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>녹취다운내역</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
									
									<tr id="bigMenuDiv3" valign="top" height="30px">
										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr id="bigMenu3" height="30px" style="cursor: hand;" onclick="viewSubMenu('3');">
													<td width="5%"></td>
													<td width="10%"><img src="<c:url value='/images/icon/icon_big_dot.gif' />" /></td>
													<td width="85%"><font color="#ffffff"> <b>시스템관리</b> </font></td>
												</tr>
												<tr height="1">
													<td colspan="3"><img src="<c:url value='/images/menu/cmDotLine.gif' />"></td>
												</tr>
											</table>
											<div id="smallMenu3" name="smallMenu3" style="display: none;" display="<c:out value="${sessionScope.userManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu3', '<c:url value='/system/userManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>사용자관리</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu3" name="smallMenu3" style="display: none;" display="<c:out value="${sessionScope.groupManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu3','<c:url value='/system/groupManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>센터관리</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu3" name="smallMenu3" style="display: none;" display="<c:out value="${sessionScope.codeManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu3','<c:url value='/system/codeManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>공통코드관리</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu3" name="smallMenu3" style="display: none;" display="<c:out value="${sessionScope.gradeManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu3','<c:url value='/system/gradeManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>권한관리</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
											<div id="smallMenu3" name="smallMenu3" style="display: none;" display="<c:out value="${sessionScope.accessManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu3','<c:url value='/system/accessManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>접근권한관리</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
									
									<tr valign="top" height="30px" id="bigMenuDiv4">
										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr id="bigMenu4" height="30px" style="cursor: hand;" onclick="viewSubMenu('4');">
													<td width="5%"></td>
													<td width="10%"><img src="<c:url value='/images/icon/icon_big_dot.gif' />" /></td>
													<td width="85%"><font color="#ffffff"> <b>통계</b></font></td>
												</tr>
												<tr height="1">
													<td colspan="3"><img src="<c:url value='/images/menu/cmDotLine.gif' />"></td>
												</tr>
											</table>

											<div id="smallMenu4" name="smallMenu4" style="display: none;" display="<c:out value="${sessionScope.linkageReportManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu4', '<c:url value='/report/linkageReportManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>콜통계</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>

											<div id="smallMenu4" name="smallMenu4" style="display: none;" display="<c:out value="${sessionScope.linkageReportHourlyManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu4', '<c:url value='/report/linkageReportHourlyManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>시간대별콜통계</b> </font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>

											<div id="smallMenu4" name="smallMenu4" style="display: none;" display="<c:out value="${sessionScope.linkageReportDurationManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu4', '<c:url value='/report/linkageReportDurationManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>통화길이별콜통계</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

									<tr valign="top" height="30px" id="bigMenuDiv5">
										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr id="bigMenu5" height="30px" style="cursor: hand;" onclick="viewSubMenu('5');">
													<td width="5%"></td>
													<td width="10%"><img src="<c:url value='/images/icon/icon_big_dot.gif' />" /></td>
													<td width="85%"><font color="#ffffff"> <b>스마트폰관리</b></font></td>
												</tr>
												<tr height="1">
													<td colspan="3"><img src="<c:url value='/images/menu/cmDotLine.gif' />"></td>
												</tr>
											</table>				
											<div id="smallMenu5" name="smallMenu5" style="display: none;" display="<c:out value="${sessionScope.smartPhoneManageAuth}"/>">
												<table border="0" cellspacing="0" cellpadding="0">
													<tr onclick="choiceMenu('smallMenu5', '<c:url value='/smart/smartPhoneManageMain.do'/>');">
														<td colspan="3">
															<table border="0" cellspacing="0" cellpadding="0" background="<c:url value='/images/bg/leftMenuBgS.gif' />">
																<tr height="20px" style="cursor: hand;">
																	<td width="10%"></td>
																	<td width="10%"><img src="<c:url value='/images/icon/icon_small_dot.gif' />" /></td>
																	<td width="80%"><font color="#395A0C"> <b>스마트폰관리</b></font></td>
																</tr>
																<tr height="1">
																	<td colspan="3"><img src="<c:url value='/images/bg/left_bg02_line.gif' />"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="11px">
							<td><img src="<c:url value='/images/bg/leftMenuBottom.gif' />" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>