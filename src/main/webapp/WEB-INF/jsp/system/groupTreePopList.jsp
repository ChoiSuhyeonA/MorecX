<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/dtree.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script language="javascript" src="<c:url value='/jquery/js/dtree.js'/>"></script>
<script type="text/javascript">
var win = window.dialogArguments;
var d = new dTree('d');

function init(){
	
}

function selectGroupSeq(id){	
	var params="seq="+id;

	$.ajax({  
	    type: "POST",  
	    url: "<c:url value='/system/selectGroupTreeSeq.do'/>",
	    data:params,
	    //contentType: "application/json",
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			   
			if(searchData.size != 0){
				document.getElementById("test").innerHTML = "";
				for(var i=0; i < searchData.size ; i++){
					d.add(searchData.list[i].groupSeq, searchData.list[i].parentGroupSeq, searchData.list[i].groupName, searchData.list[i].groupDepth);
				}	
				document.getElementById("test").innerHTML = d;
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });  
	
}

function clear(){
	d.closeAll();
}

function selectNode(name,id,depth){
		eval("win.OPENER.document.getElementById('" + win.strGroupNameParam +"')").value = name;
		eval("win.OPENER.document.getElementById('" + win.strGroupSeqParam +"')").value = id;
		if(win.strDepthParam != ""){
			eval("win.OPENER.document.getElementById('" + win.strDepthParam +"')").value = depth;	
		}
		
		// 그룹 상위 상세정보
		
		if(eval("win.OPENER.document.getElementById('" + win.strGroupNameParam +"')").id == "groupNameUpperDT") {
			
			eval("win.OPENER.document.getElementById('" + win.strGroupNameParam +"')").value = "";
			
			var params="groupSeq="+id;
			$.ajax({  
			    type: "POST",
			    url: "<c:url value='/system/selectGroupUpper.do'/>",
			    data:params,
			    //contentType: "application/json",
			     
			    success: function(list){  
					var jsonObj = decodeURIComponent(list);
					var searchData = $.parseJSON(jsonObj);
					   
					if(searchData.size != 0){
						eval("win.OPENER.document.getElementById('" + win.strGroupNameParam +"')").value = searchData.list[0].groupnameupper;
					}
					
					self.close();
			    },  
			    error: function(e){  
			      alert('Error: ' + e.responseText);
			      self.close();
			    }  
			});
			
		} else {
			self.close();
		}
}

function openAll(){
	d.openAll();
}

function closeAll(){
	d.closeAll();
}

	
</script>
</head>
<body topmargin="0px" leftmargin="0px" style="" onunload="clear();" >
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%" style="border-collapse:collapse;">
<tr>
	<td style="line-height: 1px;">	
		<div class="dtree">
			<div id="test">
				<script type="text/javascript">
					//첫번째인자는 자기의 아이디, 두번째인자는 부모아이디, 세번째인자는 표시이름	
					d.add(0,-1,'<spring:message code='common.groupMap.message' />');	
				</script>
				
				<c:forEach var="result" items="${groupTreeList}" varStatus="status">
				<script type="text/javascript">
					//d.add("100","0","테스트","테스트");
					d.add('<c:out value="${result.id}"/>','<c:out value="${result.parent}"/>','<c:out value="${result.groupName}"/>','<c:out value="${result.depth}"/>');
				</script>
				</c:forEach>
				<script type="text/javascript">
					document.write(d);
				</script>
			</div>	
		</div>
	</td>
</tr>	
</table>
</body>
</html>