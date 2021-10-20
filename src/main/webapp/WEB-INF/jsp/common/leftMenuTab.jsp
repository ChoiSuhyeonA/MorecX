<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<title>Left MENU</title>
<link href="../css/irlink.css" rel="stylesheet" type="text/css">
<script language="javascript">
	document.onkeydown=keycheck;
	function keycheck(){
		if(event.keyCode == 8){
			if(event.srcElement.tagName=="INPUT"){
				if(event.srcElement.type=="text"){
					return;
				}
			}else if(event.srcElement.tagName=="TEXTAREA"){
				return;
			}
			return false;
	    }
		if (event.keyCode == 116) {
			event.keyCode = 0;
			return false;
		}
		document.onkeydown=keycheck;
	}
	
	function keycheck2(){
		if(event.keyCode == 8){
			event.returnValue = false;
		}
	}

	function ShowDisplay()
	{
		if(document.getElementById("btnLeftMenuTab").value == "open")
		{
			document.getElementById("btnLeftMenuTab").value = "close";
			document.getElementById("btnLeftMenuTab").src = "<c:url value='/images/button/btnLeftMenuClose.gif' />";
		}
		else
		{
			document.getElementById("btnLeftMenuTab").value = "open";
			document.getElementById("btnLeftMenuTab").src = "<c:url value='/images/button/btnLeftMenuOpen.gif' />";
		}
	}
	</script>
</head>
<body oncontextmenu="return false" ondragstart="return false">
	<table width="14px" height="64px" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="bottom">
				<img id="btnLeftMenuTab" src="<c:url value='/images/button/btnLeftMenuOpen.gif' />" value="open" style="cursor:hand;" onclick="ShowDisplay();parent.slideCateScroll()">
			</td>
		</tr>
	</table>
</body>
</html>