<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Expires", "0");
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<title>MorecX</title>
</head>
<frameset rows="*,0" border="0px">
	<c:choose>
       <c:when test="hidWidth < 1280 || hidHeight < 821">
           <frame src="<c:url value='/common/login.do' />" name="mainFrame" scrolling="auto">
       </c:when>
       <c:otherwise>
           <frame src="<c:url value='/common/login.do' />" name="mainFrame" scrolling="auto">
       </c:otherwise>
   </c:choose>	  
   <frame id="hiddenFrame" name="hiddenFrame" src="<c:url value='/common/hiddenFrame.do' />" />
</frameset>
</html>