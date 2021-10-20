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

$(function() {
	$('#btnSubmit').bind({
		click : function() {
			eval("top.win.OPENER.document.getElementById('" + top.win.strCampNameParam +"')").value = document.getElementById("strCampName").value;
				self.close();
		}
	}),
	
	$('#btnCancel').bind({
		click : function() {
			self.close();
		}
	}),
	
	$('#btnSearch').bind({
		click : function() {
			search();
		}
	}),
	
	$("input:text[name^=campaignSearch]").keyup(function(event) {
		if (event.keyCode == 13){
			search();
			
		}
	});
});

function search(){
	$("#campaignPopSearchVO").attr("target","iframeCampaignPopList");
	$("#campaignPopSearchVO").attr("action","<c:url value='/common/campaignPopList.do'/>");
	$("#campaignPopSearchVO").submit();
}

function setParam() {
	win.$("#campaign").val(document.getElementById("strCampName").value);
}

</script>
<style type="text/css"> html { overflow:hidden; } </style>
</head>
<body onload="search();">
<form:form commandName="campaignPopSearchVO" id="campaignPopSearchVO" name="campaignPopSearchVO" method="post">
<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0" background="<c:url value='/images/bg/bg_campaign.gif' />">
	<tr>
		<td width="15px">
		</td>
		<td width="320px">
			<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="88px"><td>&nbsp;</td></tr>
				<tr height="33px">
					<td>
						<table width="100%" height="20px" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="15px"></td>
								<td width="250px">
									<form:input path="strCampName" cssStyle="width:250px; border:1px solid #C3C3C3; background-color:#FFFFFF" />
								</td>
								<td width="10px">&nbsp;</td>
								<td>
									<table><tr><td><img id="btnSearch" style="cursor: pointer;" src="<c:url value='/images/button/btn_simple_search.gif' />" /></td></tr></table>
									
								</td>
								<td width="">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="10px"><td></td></tr>
				<tr height="">
					<td width="320px">
						<iframe id="iframeCampaignPopList" name="iframeCampaignPopList" frameborder="0" style="width: 100%; height: 100%; border: none;" scrolling="yes"></iframe>
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