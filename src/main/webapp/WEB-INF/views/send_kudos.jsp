<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp" />
<body>
<div id="wrapper">
	<div id="content" style="clear:both;width:900px;">
	
	<div id="sidebar">
		<ul id="menu">
			<li><a href="<c:url value="/" />" id="my_team">My team</a></li>
			<li><a href="<c:url value="/send_kudos" />" id="send_kudos_link">Send Kudos</a></li>
			<li><a href="<c:url value="/download_kudos_pdf" />" id="download_kudos">Download</a></li>
	
		</ul>
	</div>
	<br/>
	<div id="send_kudos">
		<h3>Send kudos to your colleagues!</h3>
		<p>
			<div class="ui-widget" style="display:none;">
				<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
				<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				<strong>Kudos Sent!</strong></p>
				</div>
			</div>
			<div id="kudos_sent" title="Successfully sent."></div>
		</p>
		Send kudos to: <br/>
			<input id="kudos_sent_from" value="${username}" type="text" size="17" /> - 
			<input id="kudos_sent_to" type="text" size="17" />
			<p> 
				Message: <br/>
					<textarea name="kudos_content" id="kudos_content" rows="4" cols="25"></textarea>
			</p>
			<br/>
			<input type="submit" value="Send kudos!" onclick="send_kudos()" /> <br/>
	
		</div>
		
	</div>
</div>
</body>
</html>