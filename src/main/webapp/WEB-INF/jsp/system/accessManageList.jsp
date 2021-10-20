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
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>
<script type="text/javascript">
function init() {
	var params="";
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/accessManageDetail.do'/>",
	    //data:params,
	    //contentType: "application/json",
	     
	    success: function(list){  
			var jsonObj = decodeURIComponent(list);
			var searchData = $.parseJSON(jsonObj);
			var size = '<c:out value="${fn:length(accessColumnList)}"/>' - 7;
			//alert('<c:out value="${fn:length(accessColumnList)}"/>');
		
			document.getElementById("tableMain01").style.width = 1150 + (130*size);
			document.getElementById("tableMain02").style.width = 1150 + (130*size);
			
			if(searchData.size != 0){
				for(var i=0; i<searchData.size; i++){
					if(searchData.list[i].scope == "true" || searchData.list[i].scope == "false" ){
						document.getElementById("hidChk_"+searchData.list[i].privPointId+"_"+searchData.list[i].groupId).value = searchData.list[i].accessPolicyId;
						if(searchData.list[i].scope == "true"){
							document.getElementById("chk_"+searchData.list[i].privPointId+"_"+searchData.list[i].groupId).checked = true;
						}else{
							document.getElementById("chk_"+searchData.list[i].privPointId+"_"+searchData.list[i].groupId).checked = false;
						}
					}else{
						document.getElementById("hid_"+searchData.list[i].privPointId+"_"+searchData.list[i].groupId).value = searchData.list[i].accessPolicyId;
						document.getElementById("sel_"+searchData.list[i].privPointId+"_"+searchData.list[i].groupId).value = searchData.list[i].scope;						
					}
				}
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
	
}

function chkChangePolicy(id){
	var idSplit = id.split("_");
	
	var params="strPrivPointId="+idSplit[1]
			  +"&strGroupId="+idSplit[2]
			  +"&hidAccessPolicyId="+document.getElementById("hidChk_"+idSplit[1]+"_"+idSplit[2]).value
			  +"&strValue="+document.getElementById("chk_"+idSplit[1]+"_"+idSplit[2]).checked;
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/accessManageChangePolicy.do'/>",
	    data:params,
	    //contentType: "application/json",
	    
	    success: function(result){  
	    	var jsonObj = decodeURIComponent(result);
			var searchData = $.parseJSON(jsonObj);

			if(searchData.result > 0){
				if(document.getElementById("hidChk_"+idSplit[1]+"_"+idSplit[2]).value == ""){
					document.getElementById("hidChk_"+idSplit[1]+"_"+idSplit[2]).value = searchData.result;
				}else{
					document.getElementById("hidChk_"+idSplit[1]+"_"+idSplit[2]).value = "";
				}
				alert("반영 되었습니다.");
			}else{
				alert("실패 하였습니다.");
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}

function changeMenu(object){
	
	var idSplit = object.name.split("_");

	var params="strPrivPointId="+idSplit[1]
	  +"&strGroupId="+idSplit[2]
	  +"&hidAccessPolicyId="+document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value
	  +"&strValue="+object.value;
	
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/accessManageChangeMenu.do'/>",
	    data:params,
	    //contentType: "application/json",
	    
	    success: function(result){  
	    	var jsonObj = decodeURIComponent(result);
			var searchData = $.parseJSON(jsonObj);
			
			if(searchData.result > 0){
				if(document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value == ""){
					document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value = searchData.result;
				}else{
					document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value = "";
				}
				alert("반영 되었습니다.");
			}else{
				alert("실패 하였습니다.");
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}

function changePolicy(id, value){
	var idSplit = id.split("_");
	
	var params="strPrivPointId="+idSplit[1]
	  +"&strGroupId="+idSplit[2]
	  +"&hidAccessPolicyId="+document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value
	  +"&strValue="+value;
	
	$.ajax({  
	    type: "POST",
	    url: "<c:url value='/system/accessManageChangePolicy.do'/>",
	    data:params,
	    //contentType: "application/json",
	    
	    success: function(result){  
	    	var jsonObj = decodeURIComponent(result);
			var searchData = $.parseJSON(jsonObj);
			
			if(searchData.result > 0){
				if(document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value == ""){
					document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value = searchData.result;
				}else{
					document.getElementById("hid_"+idSplit[1]+"_"+idSplit[2]).value = "";
				}
				alert("반영 되었습니다.");
			}else{
				alert("실패 하였습니다.");
			}
	    },  
	    error: function(e){  
	      alert('Error: ' + e.responseText);  
	    }  
	  });
}
</script>
</head>
<body onload="init();">
<form:form commandName="accessSearchVO" name="accessSearchVO" method="post">
<div id="header" style="position:absolute; left:0px;top:expression(eval(document.body.scrollTop+ 0));">
<table id="tableMain01"  width="1150px" height="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top" height="">
		<td>
			<table width="100%" height="" cellpadding="0" cellspacing="0" style="border: 1px solid #cbe0dd; border-collapse: collapse;">
				<tr height="27px">
					<td width="140px" align="center" class="list_header">
							기능 / 권한
						</td>
					<c:forEach var="result" items="${accessColumnList}" varStatus="status">
						<td width="130px" align="center" class="list_header">
							<c:out value="${result.groupName}"/>
						</td>
					</c:forEach>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<table id="tableMain02" width="1150px" height="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top" height="">
		<td>
			<table width="100%" height="" cellpadding="0" cellspacing="0" style="border: 1px solid #cbe0dd; border-collapse: collapse;">
				<tr height="27px">
					<td width="140px" align="center" class="list_header">
							기능 / 권한
						</td>
					<c:forEach var="result" items="${accessColumnList}" varStatus="status">
						<td width="130px" align="center" class="list_header">
							<c:out value="${result.groupName}"/>
						</td>
					</c:forEach>
				</tr>
				<c:forEach var="results" items="${accessDataList}" varStatus="status">
				<tr id='tr_<c:out value="${status.count}"/>' onclick="changeLine('tr_<c:out value="${status.count}"/>', '<c:out value="${status.count}"/>');" onMouseOver="overColor('<c:out value="${status.count}"/>')" onMouseOut="outColor('<c:out value="${status.count}"/>')">
					<td width="" align="left" class="list_value" title='<c:out value="${results.name}"/>'>
						<div style='width:140px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>
						&nbsp;<c:out value="${results.name}"/>
						</div>
					</td>
					<c:forEach var="result" items="${accessColumnList}" varStatus="statu">
						<td width="130px" align="center" class="list_value">
							<c:if test="${results.checkboxFlag == '0'}">
								<input type="hidden" name='hid_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' id='hid_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>'/>
								<c:if test='${results.name == "[기능]권한별메뉴설정"}'>
									<select name='sel_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' id='sel_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' class="detail_value_writable" style="width :87px" onchange="changeMenu(this);">
										<option value="0">-선택-</option>
										<c:forEach var="resultss" items="${accessMenuList}" varStatus="statss">
											<option value='<c:out value="${resultss.id}"/>'><c:out value="${resultss.name}"/></option>
										</c:forEach>
									</select>
								</c:if>
								<c:if test='${results.name != "[기능]권한별메뉴설정"}'>
									<select name='sel_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' id='sel_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' class="detail_value_writable" style="width :90px" onchange="changePolicy(this.name, this.value);">
										<option value="sel">-선택-</option>
										<option value="all">all</option>
										<option value="groupUp">groupUp</option>
										<option value="group">group</option>
										<option value="own">own</option>
									</select>
								</c:if>
							</c:if>
							<c:if test="${results.checkboxFlag != '0'}">
								<input type="hidden" name='hidChk_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' id='hidChk_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>'/>
								<input type="checkbox" name='chk_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>'  id='chk_<c:out value="${results.id}"/>_<c:out value="${result.id}"/>' onclick="chkChangePolicy(this.name);"/>
							</c:if>
						</td>
					</c:forEach>
				</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>
