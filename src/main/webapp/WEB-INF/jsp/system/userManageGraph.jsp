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
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery-ui-1.10.0.custom.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/jquery/css/jquery.jqplot.min.css'/>"/>
<title>MorecX</title>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery-ui-1.10.0.custom.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jquery.jqplot.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/excanvas.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.pointLabels.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.barRenderer.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.categoryAxisRenderer.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/jqplot.pieRenderer.min.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/util.js' />"></script>
<script type="text/javascript" src = "<c:url value='/jquery/js/common.js' />"></script>

<script type="text/javascript">
$(document).ready(function(){
	$.jqplot.config.enablePlugins = true;
    
	/* 첫번째 카운트 그래프 */
	<c:if test="${fn:length(list) != 0}">
	var s1 = [];
    var ticks = [];
    var i=0;
    
    <c:forEach var="result" items="${list}" varStatus="status">
		s1[i] = <c:out value="${result.totalCall}"/>;
		ticks[i] = '<c:out value="${result.callDate}"/>';
		i++;
	</c:forEach>
	
    plot1 = $.jqplot('chart1', [s1], {
        // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
        animate: !$.jqplot.use_excanvas,
        title:{text : '통화건수',
    		fontSize: 15	
    	},
    	// Provide a custom seriesColors array to override the default colors.       
    	seriesColors:['#2fb2cd'],
        seriesDefaults:{
            renderer:$.jqplot.BarRenderer,
            pointLabels: { show: true }
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks
            },
            yaxis: {
            	tickRenderer: $.jqplot.CanvasAxisTickRenderer,
            	tickOptions: { formatString : '%d'}
            	/*
            	tickRenderer: $.jqplot.CanvasAxisTickRenderer,
            	tickOptions: {
            	    formatter: function(format, value){
            	        return MillisecondsToDuration(value);
            		}
           		}
            	*/
            
            },
        highlighter: { 
        	show: true,
        	sizeAdjust: 7.5
    	},
    	cursor: {
	    	show: true,
	    	zoom: true,
	    	tooltipLocation: 'sw'
    	}
        }
    });

/*     $('#chart1').bind('jqplotDataClick', 
        function (ev, seriesIndex, pointIndex, data) {
            $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
        }
    ); */
    
    /* 두번째 시간 그래프 */
   	var s2 = [];
    var s3 = [];
    var ticks2 = [];
    var j = 0;
    
    <c:forEach var="result" items="${list}" varStatus="status">
		s2[j] = <c:out value="${result.totalDuration}"/>;
		s3[j] = <c:out value="${result.aveg}"/>;
		ticks2[j] = '<c:out value="${result.callDate}"/>';
		j++;
	</c:forEach> 
	
    
    plot2 = $.jqplot('chart2', [s2, s3], {
    	animate: !$.jqplot.use_excanvas,
    	title:{text : '통화시간, 평균시간',
    		fontSize: 15	
    	},
    	
    	// Provide a custom seriesColors array to override the default colors.       
    	seriesColors:['#ffae00', '#327acb'],
        seriesDefaults: {
            renderer:$.jqplot.BarRenderer,
            pointLabels: { show: true }
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks2
            },
	        yaxis: {
	        	tickRenderer: $.jqplot.CanvasAxisTickRenderer,
	        	tickOptions: {
	        	    formatter: function(format, value){
	        	        return MillisecondsToDuration(value);
	        		}
	       		}
	        }
        }
    });
    </c:if>
    /* $('#chart2').bind('jqplotDataHighlight', 
        function (ev, seriesIndex, pointIndex, data) {
            $('#info2').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
        }
    );
        
    $('#chart2').bind('jqplotDataUnhighlight', 
        function (ev) {
            $('#info2').html('Nothing');
        }
    ); */
	
});

function MillisecondsToDuration(inTime) {
    var hour = parseInt(inTime / 3600);
	var minute = parseInt(inTime % 3600 / 60);
	var second = parseInt(inTime % 60);
	
	if (hour < 10){
		hour = "0" + hour.toString();
	}
	if (minute < 10){
		minute = "0" + minute.toString();
	}
	if (second < 10){
		second = "0" + second.toString();
	}

    return $.jqplot.sprintf('%02d:%02d:%02d', hour, minute, second);        
}
</script>
</head>
<body>
<table width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top" height="">
		<td>
			<table width="100%" height="" cellpadding="0" cellspacing="0" style="border: 1px solid #cbe0dd; border-collapse: collapse;">
				<tr>
					<c:if test="${fn:length(list) == 0}">
						<td colspan="2" width="" class="list_header">항목</td>
					</c:if>
					<c:if test="${fn:length(list) != 0}">
						<td width="" class="list_header">항목</td>
					</c:if>
					<c:forEach var="result" items="${list}" varStatus="status">
						<td width="" class="list_header">&nbsp;
							<c:out value="${result.callDate}"/>
						</td>
					</c:forEach>	
				</tr>
				<tr height="24px" id="tr_<c:out value="${status.count + cnt}"/>">
					<td align="center" class="list_value">
						통화건수
					</td>
					<c:if test="${fn:length(list) == 0}">
						<td rowspan="4" align="center" class="list_value"><spring:message code='common.nodata.message' /></td>
					</c:if>	
					<c:forEach var="result" items="${list}" varStatus="status">
					<td align="right" class="list_value">
						<c:out value="${result.totalCall}"/>&nbsp;										
					</td>
					</c:forEach>	
				</tr>
				<tr height="24px" id="tr_<c:out value="${status.count + cnt}"/>">
					<td align="center" class="list_value">
						통화시간
					</td>
					<c:forEach var="result" items="${list}" varStatus="status">
					<td align="right" class="list_value">
					<script language="javascript">
						document.write(convertDuration('<c:out value="${result.totalDuration}"/>'));
					</script>&nbsp;						
					</td>
					</c:forEach>	
				</tr>
				<tr height="24px" id="tr_<c:out value="${status.count + cnt}"/>">
					<td align="center" class="list_value">
						평균시간
					</td>
					<c:forEach var="result" items="${list}" varStatus="status">
					<td align="right" class="list_value">
						<script language="javascript">
							document.write(convertDuration('<c:out value="${result.aveg}"/>'));
						</script>&nbsp;						
					</td>
					</c:forEach>	
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
		    <div id="chart1" style="width:810px; height:150px;"></div>
		</td>
	</tr>
	<tr>
		<td>
		    <div id="chart2" style="width:810px; height:200px;"></div>
		</td>
	</tr>
</table>
</body>
</html>
