	<%@page pageEncoding="utf-8" %>
	<script src="../jquery/js/jquery.jpanelmenu.min.js"></script>
	<script src="../jquery/js/jRespond.min.js"></script>
	<script>
    <!--
    //-->
 	</script>
	<style>
        #modal { display: none;}
        
        #menu_list
        {
			list-style:none; padding:0px; margin:0px; width:175px; height:27px; 
		}
		
		#menu_list a { selector-dummy:expression(this.hideFocus=true);
		}
		
		#menu_list a img{ width:175px; height:27px; border:0px;
		}
		
		#menu_top_list
        {
			list-style:none; padding:0px; margin:0px; width:175px; height:32px; 
		}
		
		#menu_top_list a { 	selector-dummy:expression(this.hideFocus=true); 
		}
		
		
		#menu_top_list a img{ width:175px; height:32px; border:0px;
		}
		/*
		
		#menu_top_list li a span{ display:block; margin-bottom:15px;
		padding-top: 8px; padding-left:14px; cursor:hand; 
		}
		*/
		
		.menu_bar { background:url(<c:url value='/images/bg/bg_menu_slide_hide.gif' />) no-repeat; 
			cursor:hand; position: absolute;position: fixed; top: 0px; height: 100%; width:36px; z-index: 1;
		}
		
		#menu_bar a { width:36px; height:height: 100%; 	selector-dummy:expression(this.hideFocus=true);}
		
		.menu_top ul { list-style:none; background:url('../images/bg/bg_menu_top.gif'); 
						width:155px; height:165px;  margin:0; padding:0; font-family:돋움;  
						font-size:11px; color:#e6f1f7; font-weight:bold;clear:both;margin:0 auto; padding-left:17px;"
		}
		
		.menu_top li { height: 18px;	}
			
    </style>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/jquery.pageslide.css'/>"/>
    
    <div id="menu" class="menu_bar" style="">
   		<a href="#modal" class="second" style="" ><span>
   		<table width="34px" height="100%">
   		<tr>
   			<td></td>
   		</tr>
   		</table>
   		</span></a>
    </div>
    
    <!-- 
    <a href="#modal" class="second" style="" onclick="changeImage();">
	<table id="menu" width="37px" height="100%" background="<c:url value='/images/bg/bg_menu_slide_hide.gif' />" >
	<tr>
		<td height="100%">
			&nbsp;
		</td>
	</tr>
	</table>
	</a>
     --> 
   	<div id="modal" >
   		<div class="menu_top" >
   		<ul>
   			<li style="height:60px;"></li>
   			<li style="height:18px;">로그인날짜 : <c:out value="${sessionScope.login_date}" /></li>
   			<li style="height:18px;">로그인시간 : <c:out value="${sessionScope.login_time}" /></li>
   		</ul>
   		</div>
   		
   		<div class="accordionButton" id="recordMenu" >
   	    <ul id = "menu_top_list" >
       		<li><a href="#" >
       		<span id="first_level_menu" >
       			<img src="<c:url value='/images/menu/menu_head_record.gif' />">
       		</span></a></li>
		</ul>
		</div>
		
		<div class="accordionContent" style="display:none;">
		<!-- 
		<ul id="menu_list" style="display: <c:out value="${sessionScope.recordManageAuth}"/>;">
			<li >
			<a href="<c:url value='/record/recordManageMain.do'/>">
			<span id="second_level_menu" >
				<img class="button" src="<c:url value='/images/menu/menu_record.gif' />">
			</span></a></li>
		</ul> -->
		<ul id="menu_list" style="display: <c:out value="${sessionScope.linkCallManageAuth}"/>;">
			<li >
			<a href="<c:url value='/record/linkCallManageMain.do'/>">
			<span id="second_level_menu" >
				<img class="button" src="<c:url value='/images/menu/menu_record.gif' />">
			</span></a></li>
		</ul>
		</div>
		
		<div class="accordionButton" id="monitorMenu">
   	    <ul id = "menu_top_list" >
       		<li><a href="#" >
       		<span id="first_level_menu" >
       			<img src="<c:url value='/images/menu/menu_head_monitor.gif' />">
       		</span></a></li>
		</ul>
		</div>
		
		<div class="accordionButton" id="systemMenu">
		<ul id = "menu_top_list" >
       		<li><a href="#" >
       		<span id="first_level_menu" >
       			<img src="<c:url value='/images/menu/menu_head_system.gif' />">
       		</span></a></li>
		</ul>
		</div>
		
		<div class="accordionContent" style="display:none;">
		<ul id="menu_list" style="display: <c:out value="${sessionScope.userManageAuth}"/>;">
			<li><a href="<c:url value='/system/userManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_user.gif' />"></span></a></li>
			
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.groupManageAuth}"/>;">
			<li><a href="<c:url value='/system/groupManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_group.gif' />"></span></a></li>
			
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.codeManageAuth}"/>;">
			<li><a href="<c:url value='/system/codeManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_code.gif' />"></span></a></li>
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.gradeManageAuth}"/>;">
			<li><a href="<c:url value='/system/gradeManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_grade.gif' />"></span></a></li>
			
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.accessManageAuth}"/>;">
			<li><a href="<c:url value='/system/accessManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_access.gif' />"></span></a></li>
			
		</ul>
		</div>
		
		<div class="accordionButton" id="reportMenu">
		<ul id = "menu_top_list" >
       		<li><a href="#" >
       		<span id="first_level_menu" >
       			<img style="height:33px;" src="<c:url value='/images/menu/menu_head_report.gif' />">
       		</span></a></li>
		</ul>
		</div>
		
		<div class="accordionContent" style="display:none;">
		<ul id="menu_list" style="display: <c:out value="${sessionScope.reportManageAuth}"/>;">
			<li><a href="<c:url value='/report/reportManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_call_report.gif' />"></span></a></li>
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.reportHourlyManageAuth}"/>;">
			<li><a href="<c:url value='/report/reportHourlyManageMain.do'/>">
				<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_time_report.gif' />"></span></a></li>
		</ul>
		<ul id="menu_list" style="display: <c:out value="${sessionScope.reportDurationManageAuth}"/>;">
			<li><a href="<c:url value='/report/reportDurationManageMain.do'/>">
			<span id="second_level_menu" ><img class="button" src="<c:url value='/images/menu/menu_duration_report.gif' />"></span></a></li>
		</ul>
		
		</div>
		<!-- 
       <a href="javascript:$.pageslide.close()" onclick="changeImage();">Close</a></p>
        -->
    </div>
    <script>
    //document.getElementById("menu1").style.display = "";
        /* Slide to the left, and make it model (you'll have to call $.pageslide.close() to close) */
        
        $(document).ready(function() {
        	if('<c:out value="${sessionScope.recordManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.linkCallManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.goodCallManageAuth}"/>' == "none"){
        		$('#recordMenu').css({'display':'none'});
        	}
        	
        	if('<c:out value="${sessionScope.moniterManageAuth}"/>' == "none"){
        		$('#monitorMenu').css({'display':'none'});
        	}
        	
        	if('<c:out value="${sessionScope.userManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.groupManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.codeManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.configAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.gradeManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.accessManageAuth}"/>' == "none"){
        		$('#systemMenu').css({'display':'none'});
        	}
        	
        	if('<c:out value="${sessionScope.reportManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.reportHourlyManageAuth}"/>' == "none" && 
        			'<c:out value="${sessionScope.reportDurationManageAuth}"/>' == "none" &&
        			'<c:out value="${sessionScope.linkageReportManageAuth}"/>' == "none" &&
        			'<c:out value="${sessionScope.linkageReportHourlyManageAuth}"/>' == "none" &&
        			'<c:out value="${sessionScope.linkageReportDurationManageAuth}"/>' == "none"){
        		$('#reportMenu').css({'display':'none'});
        	}
        });
    </script>