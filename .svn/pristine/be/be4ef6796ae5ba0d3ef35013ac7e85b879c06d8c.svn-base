<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  style="overflow:hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript">

function init(){
	var pageType = eval(GetDialogArguments()).strPageType;
	
	if(pageType == "system") {
		$("#cmnGroupSearchVO").attr("action","<c:url value='/common/systemGroupTreeList.do'/>");
	}
	else {
		$("#cmnGroupSearchVO").attr("action","<c:url value='/common/groupTreeList.do'/>");
	} 
	
	$("#cmnGroupSearchVO").attr("target","iframeGroupTreeList");
	$("#cmnGroupSearchVO").submit();
}

$(function() {
	$("#btn_close").bind("click", function(event) {		
		self.close();
	});
});

function GetDialogArguments() {
    var arguments;
 
    if (window.dialogArguments) { // For IE
        arguments = "window.dialogArguments";
    }
    else { //For FF and Chrome
        arguments = "parent.window.opener";
    }
 
    return arguments;
}


</script>
</head>
<body onload="init();" style="margin:0px;">
<form:form commandName="cmnGroupSearchVO" id="cmnGroupSearchVO" name="cmnGroupSearchVO" method="post">
<form:hidden path="auth" />
<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse" background="<c:url value='/images/bg/bg_group_tree.gif' />">
	<tr height="88px">
		<td colspan="3"></td>
	</tr>
	<tr height="213px" valign="top">
		<td width="16px"></td>
		<td>
			<table width="320px" height="213px" cellpadding="0" cellspacing="0" border="0" class="popup_box">
			<tr height="10px">
				<td></td>
			</tr>
			<tr height="203px">
				<td width="5px"></td>
				<td>
					<iframe id="iframeGroupTreeList" name="iframeGroupTreeList" frameborder="0" style="width: 310px; height: 203px; border: 0;"></iframe>		
          		</td>	
          		<td width="5px"></td>	
			</tr>
			</table>
		</td>
    	<td width="16px"></td>
	</tr>
	<tr height = "7px">
		<td></td>
	</tr>
	<tr valign="top" height="24px">
		<td></td>
		<td align="right"><img id="btn_close" height="24px" class="button" src="<c:url value='/images/button/btn_close.gif' />" /></td>
		<td></td>
	</tr>
	<tr>
		<td></Td>
	</tr>
</table>
</form:form>
</body>
</html>