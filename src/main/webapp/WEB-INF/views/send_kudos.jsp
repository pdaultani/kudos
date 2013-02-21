<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script type="text/javascript" src="/lux/resources/js/jquery-ui-1.10.1.custom.min.js"></script>
	<script type="text/javascript" src="/lux/resources/js/jquery-ui-1.10.1.custom.js"></script>
	<script type="text/javascript" src="/lux/resources/js/jquery-1.9.1.js"></script>
	
	<script type="text/javascript">
	    var jq = jQuery.noConflict();
	</script>
	<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body>
<div id="header">
	<div class="left_div"><h2> Kudos  </h2></div>	
	<div class="right_div"><h2> Welcome ${username}! </h2></div>
	
</div>
<div id="wrapper">

	<div id="sidebar">
	<ul>
	<div id="navigation">
		<li><a href="<c:url value="/" />" id="my_team">My team</a></li>
		<li><a href="<c:url value="/send_kudos" />" id="send_kudos_link">Send Kudos</a></li>
		<li><a href="<c:url value="/" />" id="download_kudos">Download</a></li>
		</div>
	</ul>
	</div>
	<div id="content">
	
	

<div id="send_kudos">
<h3>Send kudos to your colleagues!</h3>
	<p>
		<div id="kudos_sent"></div>
	</p>
	Send kudos to: <br/>
	<input id="kudos_sent_from" value="${username}" type="text" size="17" /> - 
	<input id="kudos_sent_to" type="text" size="17" />
	<p> 
		Message: <textarea name="kudos_content" id="kudos_content" rows="5"></textarea>
		 
	</p>
	<br/>
	<input type="submit" value="Send kudos!" onclick="send_kudos()" /> <br/>
	
</div>


<script type="text/javascript"> 

function send_kudos() {
	jq(function() {
		
		jq.post("/lux/send_kudos",
					{ 	kudos_sent_to:  jq("#kudos_sent_to").val(),
						kudos_sent_from:  jq("#kudos_sent_from").val(),
						kudos_content: jq('#kudos_content').val() },
						function(data){
							// data contains the result
							jq("#kudos_sent").css("display","block");
							jq("#kudos_sent").show();
							jq("#kudos_sent").html(data);
					});
	});
}

</script>
</div>
	
</div>
</body>
</html>