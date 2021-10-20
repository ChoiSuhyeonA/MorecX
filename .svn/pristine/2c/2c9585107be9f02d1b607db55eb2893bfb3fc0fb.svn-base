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


var win = window.dialogArguments;

function search(){
	//gradePopForm.gradeSeq.value = win.strGradeSeqParam;	
	gradePopForm.target = "iframeGradePopList";
	gradePopForm.action = "<c:url value='/system/gradePopList.do'/>";
	gradePopForm.submit();
}

function blankText(code, type){	
	if(type == "gradeName"){
		document.getElementById("gradeSeq").value = "";
	}else {		
		document.getElementById("gradeName").value = "";
	}	
	if(code == '13'){
		search();
	}
}

<% /* 검색버튼 클릭시 이벤트 */ %>
$(function() {
	$("#btnSubmit").bind("click", function(event) {
		iframeGradePopList.selectGroup(document.getElementById("gradeName").value,document.getElementById("gradeSeq").value);
	}),
	$("#btnCancel").bind("click", function(event) {
		self.close();
	});
});
</script>
</head>
<body onload="search();">
<form:form commandName="gradeSearchVO" id="gradePopForm" name="gradePopForm" method="post">
<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_group_pop.gif' />">
	<tr>
		<td width="15px">
		</td>
		<td width="320px">
			<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="88px"><td>&nbsp;</td></tr>
				<tr height="33px">
					<td>
						<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="5px"></td>
								<td width="127px">
									<form:input path="gradeName" class="detail_value_writable" style="width:127px; height:20px;" onkeyup="blankText(event.keyCode, 'gradeName');" onkeypress="if(event.keyCode == 13)search();" />
								</td>
								<td width="5px"></td>
								<td width="127px">
									<form:input path="gradeSeq" class="detail_value_writable" style="width:127px; height:20px;" onkeyup="blankText(event.keyCode, 'gradeSeq');" onkeypress="if(event.keyCode == 13)search();"  />
								</td>
								<td width="5px"></td>
								<td width="20px">
									<img id="btnSearch" style="cursor: pointer;" src="<c:url value='/images/button/btn_simple_search.gif' />" onclick="search();"/>
								</td>
								<td width="">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="10px"><td></td></tr>
				<tr height="">
					<td width="320px">
						<iframe id="iframeGradePopList" name="iframeGradePopList" frameborder="0" style="width: 100%; height: 100%; border: none;" scrolling="yes"></iframe>
					</td>
				</tr>
				<tr height="10px"><td></td></tr>
				<tr height="24px">
					<td align="right">
						<img id="btnSubmit" style="cursor: pointer;" src="<c:url value='/images/button/btn_confirm.gif' />" />
						<img id="btnCancel" style="cursor: pointer;" src="<c:url value='/images/button/btn_close.gif' />" />
					</td>
				</tr>
				<tr height="16px"><td>&nbsp;</td></tr>
			</table>
		</td>
		<td width="15px">
		</td>
  	</tr>
</table>
</form:form>
</body>
</html>