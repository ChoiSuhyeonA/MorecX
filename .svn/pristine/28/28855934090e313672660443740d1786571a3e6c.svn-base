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
			win.document.getElementById("description").value = document.getElementById("goodCallMemo").value;
			win.goodCallMemo(win.document.getElementById("callIdSave").value);
			self.close();
		}
	}),
	
	$('#btnCancel').bind({
		click : function() {
			self.close();
		}
	});
});

$(document).ready(
		function() {
			$(function() {
				function updateInputCount() {
					var textLength = $('textarea').val().length;
					var count = textLength;
					$('span.input_point').text(count);
					if (count >= 500) {
						$('span.input_point').addClass('disabled');
					} else {
						$('span.input_point').removeClass('disabled');
					}
				}
				$('textarea').focus(updateInputCount)
						.blur(updateInputCount).keypress(updateInputCount);
				window.setInterval(updateInputCount, 100);
				updateInputCount();
			});
		});

function Limit(obj, target) {

	var maxLength = parseInt(obj.getAttribute("maxlength"));
	if (obj.value.length > maxLength) {
		alert(maxLength + "<spring:message code='message.overWord' />");
		obj.value = obj.value.substring(0, maxLength);
		return;
	}
}

</script>
</head>
<body style="width: 350px; height: 350px; margin: 0px;" class="popup_goodcall">
	<table width="350px" height="350px" cellpadding="0" cellspacing="0" border="0">
		<tr height="">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr height="200px">
			<td width="20px">&nbsp;</td>
			<td>
				<textarea class="popup_goodcall_textarea" id="goodCallMemo" name="goodCallMemo" maxlength="150" onkeyup="Limit(this)" onkeydown="Limit(this)"></textarea>
			</td>
			<td width="20px">&nbsp;</td>
		</tr>
		<tr height="10px"><td colspan="3"></td></tr>
		<tr height="24px">
			<td align="right" colspan="2">
				<img id="btnSubmit" style="cursor: pointer;" src="<c:url value='/images/button/btn_confirm.gif' />" />
				<img id="btnCancel" style="cursor: pointer;" src="<c:url value='/images/button/btn_close.gif' />" />
			</td>
			<td width="16px">&nbsp;</td>
		</tr>
		<tr height="16px"><td colspan="3">&nbsp;</td></tr>
	</table>
</body>
</html>