<%-- 
- 페이지 제목 : 사용자관리 메인
- 페이지 ID : userManageMain.jsp
- 저작권 : ㈜ 아이알링크
- 작성자 : 풍기정
- 작성일자 : 2013-08-28
- 설명 : 사용자의 정보를 조회 등록 수정 삭제 한다.
- 연관 method : /system/userManageList.do
- 변경내역 : 
- 
--%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery.jqplot.min.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript">
function init(){
	//searchGradeList();
}

$(function() {
	$("#btn_new").bind("click", function(event) {		
		clickBtnNew();
	}),
	$("#btn_save").bind("click", function(event) {		
		clickBtnSave();
	});
});

function searchGradeList(){
	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	$("#selectedGradeId").val("");
	$("input:hidden[name=nowpage]").val("1");
	$("input:hidden[name=pageIndex]").val("1");
	$("#gradeSearchVO").attr("target","iframeGradeList");
	$("#gradeSearchVO").attr("action","<c:url value='/system/gradeManageList.do'/>");
	$("#gradeSearchVO").submit();
}

function blankText(code, type){	
	if(type == "gradeName"){
		$("#gradeSeq").val("");
	}else {		
		$("#gradeName").val("");
	}	
	if(code == '13'){
		searchGradeList();
	}
}	
function clickDisabled() {
	$("#selectedGradeId").val("");
	$("#gradeName").val("");
	$("#gradeSeq").val("");
	$("#gradeNameDT").val("");
	$("#gradeSortDT").val("");
	$("#gradeNameDT").val("").attr("disabled", true);
	$("#gradeSortDT").val("").attr("disabled", true);
	$("#deleteYnDT").val("").attr("checked", false);
	$("#deleteYnDT").val("").attr("disabled", true);
}

function clickEnabled() {
	$("#gradeNameDT").val("").removeAttr("disabled");
	$("#gradeSortDT").val("").removeAttr("disabled");
	$("#deleteYnDT").val("").removeAttr("disabled");
}

function clickBtnNew() {
	$("#selectedGradeId").val("");
	$("#gradeNameDT").val("");
	$("#gradeSortDT").val("");
	$("#gradeNameDT").val("").removeAttr("disabled");
	$("#gradeSortDT").val("").removeAttr("disabled");
	$("#deleteYnDT").val("").attr("checked", false);
	$("#deleteYnDT").val("").removeAttr("disabled");
}

function clickBtnSave() {
	if($("#gradeNameDT").val() == "" || $("#gradeSortDT").val() == ""){
		alert("입력된 데이터가 없습니다.");
		return;
	}
	var strDeleteYn = "";
	if( document.getElementById("deleteYnDT").checked == true ) {
		strDeleteYn = "1";
	} else {
		strDeleteYn = "0";
	}
	
	var param = "gradeSeq="+$("#selectedGradeId").val()
	  + "&gradeNameDT="+$("#gradeNameDT").val()
	  + "&gradeSortDT="+$("#gradeSortDT").val()
	  + "&deleteYnDT="+strDeleteYn
	;
	  
	if(document.getElementById("selectedGradeId").value == "") {
		
		// 저장
		$.ajax({
			type: "POST",  
			url: "<c:url value='/system/gradeManageInsert.do'/>",
			data: param,
			success: gradeInsertCallBack,
			error: function(e){  
				alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
			}  
		});	
	} else {
		
		// 수정
		$.ajax({
			type: "POST",  
			url: "<c:url value='/system/gradeManageUpdate.do'/>",
			data: param,
			success: gradeUpdateCallBack,
			error: function(e){  
				alert('<spring:message code='group.insertGroup.failure' /> : ' + e.responseText);
			}  
		});
	}
	 
	function gradeInsertCallBack(result) {
		var jsonObj = decodeURIComponent(result);
		var searchData = $.parseJSON(jsonObj);
		
		if(searchData.result != "0") {
			alert("<spring:message code='group.insertGroup.success' />");
			clickDisabled();
			searchGradeList();
		} else {
			alert("<spring:message code='group.insertGroup.failure' />");
		}
	}
	
	function gradeUpdateCallBack(result){
		var jsonObj = decodeURIComponent(result);
		var searchData = $.parseJSON(jsonObj);
		
		if(searchData.result == "SUCCESS") {
			alert("<spring:message code='group.insertGroup.success' />");
			clickDisabled();
			searchGradeList();
		} else {
			alert("<spring:message code='group.insertGroup.failure' />");
		}
	}
}

<% /* 새로고침 */ %>
function refreshList(){
	if(document.getElementById("btn_search").disabled == true){
		return false;
	}

	document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
	document.getElementById("btn_search").disabled = true;
	
	$("#gradeSearchVO").attr("target","iframeGradeList");
   	$("#gradeSearchVO").attr("action","<c:url value='/system/gradeManageList.do'/>");
   	$("#gradeSearchVO").submit();
}
/* pagination 페이지 링크 function */
function fn_grade_list_pinpage(){
	if(document.getElementById("btn_search").disabled == true){
		return false;
	}
	var pageNo = getOnlyNumber(document.getElementById("nowpage").value);
	if(pageNo == ""){
		document.getElementById("nowpage").value = "";
		alert("원하시는 페이지를 입력해주십시오.");
	}else{
		document.getElementById("btn_search").src ="<c:url value='/images/button/btn_searching.gif' />";
		document.getElementById("btn_search").disabled = true;
		
		document.getElementById("pageIndex").value = pageNo;
		document.getElementById("nowpage").value = pageNo;
		
		//historySave();
		
		$("#gradeSearchVO").attr("target","iframeGradeList");
	   	$("#gradeSearchVO").attr("action","<c:url value='/system/gradeManageList.do'/>");
	   	$("#gradeSearchVO").submit();
	}
	/*parent.document.recordSearchVO.pageIndex.value = pageNo;
	parent.document.recordSearchVO.nowpage.value = pageNo;
   	parent.document.recordSearchVO.target = "iframeGradeList";
   	parent.document.recordSearchVO.action = "<c:url value='/system/gradeManageList.do'/>";
   	parent.document.recordSearchVO.submit();*/
}
<% /* 페이징 */ %>
function page_first() {
	document.getElementById("nowpage").value = 1;
	fn_grade_list_pinpage();
}

function page_previous() {
	var pin = parseInt(document.getElementById("nowpage").value);
	if(1 < pin){
		document.getElementById("nowpage").value = pin - 1;
		fn_grade_list_pinpage();
	}else{
		
	}
}

function page_next() {
	var pin = parseInt(document.getElementById("nowpage").value);
	var max = parseInt(document.getElementById("maxPageCheck").value);
	if(pin < max){
		document.getElementById("nowpage").value = (pin + 1);
		fn_grade_list_pinpage();
	}else{
		
	}
}

function page_last() {
	document.getElementById("nowpage").value = document.getElementById("maxPageCheck").value;
	fn_grade_list_pinpage();
}


</script>
</head>
<body bgcolor="#FFFFFF" style="text-align: left" onload="init();">
<form:form  commandName="gradeSearchVO" name="gradeSearchVO" method="post">
<form:hidden path="pageIndex" />
<input type="hidden" id="selectedGradeId" name="selectedGradeId" value=""/>
<input type="hidden" id="maxPageCheck" name="maxPageCheck" value=""/>
<table align="left" width="1249px" height="100%" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
<tr valign="top">
	<td>
		<table align="left" width="" height="730px" cellpadding="0" cellspacing="0" border="0" >
		<tr height="36px" valign="top">
			<td colspan="3">
				<table width="100%" height="36px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_title.gif' />">
				<tr>
					<td width="14px"></td>
					<td style="padding-top:1px;">
						<img height="33px" border="0px" src="<c:url value='/images/title/title_grade.gif' />" />
					</td>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr height="100%" valign="top">
			<td width="400px">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td>
						<table width="400px" height="136px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top">
							<td>
								<table width="400px" height="100%" cellpadding="0" cellspacing="0" border="0" >
								<tr valign="top" height="23px">
									<td width="14px"></td>
									<td>
										<table width="100%" height="23px" cellpadding="0" cellspacing="0" border="0" class="search_title">
										<tr>
											<td width=""  height="23px">&nbsp;</td>
											<td width="50px" align="right"><img id="btn_search" class="button" align="absmiddle" src="<c:url value='/images/button/btn_search.gif' />" onclick="javascript:searchGradeList();" /></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								<tr height="79px" valign="top">
									<td></td>
									<td>
										<table width="372px" height="79px" cellpadding="0" cellspacing="0" border="0" class="search_area">
										<tr height="15px">
											<td colspan="2"></td>
										</tr>
										<tr valign="top" height="48px">
											<td>
												<table width="" height="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td>
														<table width="" height="20" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="14px" height="20"></td>
															<td width="8px" style="padding-bottom: 4px;" align="left"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="3px"></td>
															<td width="48px" class="search_condition" align="left">권한조직</td>
															<td width="7px"></td>
															<td width="1px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="13px"></td>
															<td width="96px" style="padding-bottom: 2px;" align="left"><form:input type="text" path="gradeName" class="search_value" style="width:93px; height:16px;" maxlength="255" onkeyup="blankText(event.keyCode, 'gradeName');" /></td>
															<td width="3px"></td>
															<td width="96px" style="padding-bottom: 2px;" align="left"><form:input type="text" path="gradeSeq"  class="search_value"  style="width:93px; height:16px;" maxlength="11" onkeyup="blankText(event.keyCode, 'gradeSeq');" /></td>
															<td width="3px"></td>
															<td width="20px" style="padding-top: 4px;"><!-- <img id="btn_groupSearch" class="button" src="<c:url value='/images/button/btn_simple_search.gif' />" onclick="gradePop('gradeName', 'gradeSeq', '<c:url value='/system/' />');"/> --></td>
															<td width=""></td>
														</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td>
														<table width="" height="20" cellpadding="0" cellspacing="0" border="0">
														<tr>
															<td width="14px"></td>
															<td width="8px" style="padding-bottom: 4px;" align="left"><img src="<c:url value='/images/icon/icon_search_item.png' />" /></td>
															<td width="3px"></td>
															<td width="48px" class="search_condition" align="left">삭제포함</td>
															<td width="7px"></td>
															<td width="1px" style="border-right: 1px solid #d0e3e3 ;">&nbsp;</td>
															<td width="11px"></td>
															<td width="93px" align="left"><input type="checkbox" align="absmiddle" id="deleteYn" name="deleteYn" /></td>
															<td width=""></td>
														</tr>
														</table>
													</td>
												</tr>
												</table>
											</td>
											<td width="14px"></td>
										</tr>
										<tr height="10px">
											<td colspan="2"></td>
										</tr>
										</table>
									</td>
									<td width="14px"></td>
								</tr>
								<tr valign="top" height="6px">
									<td></td>
									<td>
										<table width="100%" height="6px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_shadow.gif' />">
										<tr>
											<td></td>
										</tr>
										</table>
									</td>
									<td></td>
								</tr>
								</table>
							</td>
						</tr>
						<tr height="14px">
							<td></td>
						</tr>
						</table>
					</td>
				</tr>
				<tr height="4px">
					<td>
						<table width="100%" height="100%" border="1px" class="screen_bar">
						<tr>
						<td>
						</td>
						</tr>	
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="400px" height="510px" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
						<tr height="20px">
							<td></td>
						</tr>
						<tr valign="top" height="510px">
							<td width="14px"></td>
							<td>
								<table width="" height="" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
									<tr valign="top">
										<td>
											<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="list_title">
											<tr>
												<td>&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											<iframe id="iframeGradeList" name="iframeGradeList" frameborder="0" style="width: 372px; height: 475px; border: 1px solid #cbe0dd;"  scrolling="yes"></iframe>
										</td>
									</tr>
									<tr height="5px">
										<td></td>
									</tr>
									<tr>
										<td>
											<table width="372px" height="29px" cellpadding="0" cellspacing="0" border="0" class="paging_table_box">
											<tr>
												<td width="15px"></td>
												<td width="10px"><img id="btn_first" style="cursor: pointer;" src="<c:url value='/images/button/btn_first.gif' />" onclick="page_first();" /></td>
												<td width="5px"></td>
												<td width="6px"><img id="btn_previous" style="cursor: pointer;" src="<c:url value='/images/button/btn_previous.gif' />" onclick="page_previous();"/></td>
												<td width="10px"></td>
												<td width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="40px">페이지</td>
												<td width="25px"><input id="nowpage" name="nowpage" type="text" value="1" style="width:20px; height:13px" class="detail_value_writable" onkeydown="javascript : if(event.keyCode == 13) fn_record_list_pinpage();"></td>
												<td width="3px"></td>
												<td>/</td>
												<td width="20px"><span style="text-align: left;" id="maxPage">0</span></td>
												<td width="5px"></td>
												<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="6px"><img id="btn_next" style="cursor: pointer;" src="<c:url value='/images/button/btn_next.gif' />" onclick="page_next();"/></td>
												<td width="5px"></td>
												<td width="10px"><img id="btn_last" style="cursor: pointer;" src="<c:url value='/images/button/btn_last.gif' />" onclick="page_last();"/></td>
												<td width="10px"></td>
												<td  width="1px"><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="13px"><img id="btn_refresh" style="cursor: pointer;" src="<c:url value='/images/button/btn_refresh.gif' />" onclick="refreshList();"/></td>
												<td width="10px"></td>
												<td><img src="<c:url value='/images/bg/bg_line.gif' />" /></td>
												<td width="10px"></td>
												<td width="30px">표시</td>
												<td>
													<select id="pagelist" name="pagelist">
														<option value="10">10</option>
														<option value="50">50</option>
														<option value="100">100</option>
														<option value="200">200</option>
													</select>
												</td>
												<td align="right"><span id="totalCount" >0</span>건&nbsp;</td>
											</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
										<table width="100%" height="6px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_shadow.gif' />">
										<tr>
											<td></td>
										</tr>
										</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			<td width="4px" height="100%" valign="top" >
				<table width="4px" height="730px" class="screen_bar">
						<tr>
						<td>
						</td>
						</tr>	
						</table>
			</td>
			<td valign="top">
				<table width="" height="100%" cellpadding="0" cellspacing="0" border="0" bgcolor="#FFFFFF">
				<tr height="20px">
					<td></td>
				</tr>
				<tr valign="top" height="600px">
					<td width="14px"></td>
					<td>
						<div class="div_gradeDetail">
						<table width="" height="" cellpadding="0" cellspacing="0" border="0" >
							<tr valign="top">
								<td>
									<table width="122px" height="23px" cellpadding="0" cellspacing="0" border="0" class="detail_title">
									<tr>
										<td>&nbsp;</td>
									</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="805px" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
									
									<tr>
										<td width="116px" class="detail_column">권한조직명</td>
										<td width="234px" class="detail_description">
											<form:input path="gradeNameDT" class="detail_value_writable" style="width:400px; height:17px;" disabled="true" />
										</td>
									</tr>
									<tr>
										<td width="116px" class="detail_column">정렬</td>
										<td width="234px" class="detail_description">
											<form:input path="gradeSortDT" class="detail_value_writable" style="width:400px; height:17px;" disabled="true" />
										</td>
									</tr>
									<tr>
										<td width="116px" class="detail_column">삭제여부</td>
										<td width="234px" class="detail_description">
											<input type="checkbox" id="deleteYnDT" name="deleteYnDT" disabled="disabled" />
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr height="3px">
								<td></td>
							</tr>
							<tr>
								<td>
									<table cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td width="727px">&nbsp;</td>
										<td><img id="btn_new" class="button" src="<c:url value='/images/button/btn_new.gif' />" /></td>
										<td width="5px"></td>
										<td><img id="btn_save" class="button" src="<c:url value='/images/button/btn_save.gif' />" /></td>
									</tr>
									</table>
								</td>
							</tr>
						</table>
					</div>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		</table>
	</td>
</tr>
</table>
</form:form>
</body>
</html>
