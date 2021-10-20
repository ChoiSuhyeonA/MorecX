<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!doctype html>
<html lang="en">
<head>
  	<title>jQuery PageSlide Demo</title>
  	<!--  The jquery.pageslide.css stylesheet has the class that you'll need on your page -->
  	<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery.pageslide.css' />" />
  	<style>
  	
  	    body { 
        	background: #f4f4f4;
        	font: 14px/18px "HelveticaNeue", "Helvetica Neue", Helvetica, Arial, sans-serif;
        	color: #666; 
        	-webkit-font-smoothing: antialiased; /* Fix for webkit rendering */
        	-webkit-text-size-adjust: none;
        }

        a, a:visited { color: #C30; text-decoration: none; border-bottom: 1px dotted #C30; }
        a:hover { color: #900; border-bottom-style: solid; }

        p { margin-bottom: 20px; }

        #content {
            width: 940px;
            padding: 10px;
            margin: 0 auto;
        }
            #content h1 { color: #333; line-height: 1em; }
            #content ul { padding-left: 0; list-style: none; }
                #content ul li { margin-bottom: 20px; }

        #modal { display: none; }
            #modal a { background: #CCC; color: #333; font-weight: bold; padding: 5px 10px; border: none; }
            #modal a:hover { background: #aaa; } 

        pre { border: 1px solid #CCC; background-color: #EEE; color: #333; padding: 10px 20px; }
        
    </style>
</head>
<body>
    <div id="content">
        <h1>PageSlide Basic Demo</h1>
        <p>Below are a couple examples of how the plugin works:</p>
        <ul>
            <li>
                <a href="1_secondary.html" class="first">Slide to the right, and load content from a secondary page.</a>
                <pre>
&lt;a href=&quot;_secondary.html&quot; class=&quot;first&quot;&gt;Link text&lt;/a&gt;
&lt;script&gt;
    $(&quot;a.first&quot;).pageslide();
&lt;/script&gt;
                </pre>
            </li>
            <li>
                <a href="#modal" class="second">Slide to the left, and display hidden content from this page in a modal pane.</a>
                <pre>
&lt;a href=&quot;#modal&quot; class=&quot;second&quot;&gt;Link text&lt;/a&gt;
&lt;div id=&quot;modal&quot; style=&quot;display:none&quot;&gt;
    &lt;h2&gt;Modal&lt;/h2&gt;
    &lt;a href=&quot;javascript:$.pageslide.close()&quot;&gt;Close&lt;/a&gt;
&lt;/div&gt;
&lt;script&gt;
    $(&quot;.second&quot;).pageslide({ direction: &quot;left&quot;, modal: true });
&lt;/script&gt;
                </pre>
            </li>
            <li>
                <a href="javascript:$.pageslide({ direction: 'left', href: '_secondary.html' })">Open the page programatically.</a>
                <pre>
&lt;a href=&quot;javascript:$.pageslide({ direction: &#39;left&#39;, href=&#39;_secondary.html&#39; })&quot;&gt;Link text&lt;/a&gt;
                </pre>
            </li>
        </ul>
        <div id="modal">
            <h2>Modal</h2>
            <p>This slide uses "modal" option set to "true". When using a modal pageslide, clicking on the main window will not close the window. You must explicitly call <code>$.pageslide.close()</code>.</p>
            <p><a href="javascript:$.pageslide.close()">Close</a></p>
        </div>
    </div>
    <script src="<c:url value='/jquery/js/jquery-1.9.0.js' />"></script>
    <script src="<c:url value='/jquery/js/jquery.pageslide.js' />"></script>
    <script>
        /* Default pageslide, moves to the right */
        $(".first").pageslide();
        
        /* Slide to the left, and make it model (you'll have to call $.pageslide.close() to close) */
        $(".second").pageslide({ direction: "right", modal: true });
    </script>
</body>
</html>
