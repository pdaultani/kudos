<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Kudos - Expedia</title>
	<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
</head>
<body id="home">
<div id="header">
	<div class="left_div"><h2> Kudos  </h2></div>	
	<div class="right_div"><h2> Welcome ${username}! </h2></div>
	
</div>
<div id="wrapper">

	<div id="sidebar">
	<ul>
	<div id="navigation">
		<li><a href="<c:url value="/" />" id="my_team">My team</a></li>
		<li><a href="<c:url value="/send_kudos" />" id="send_kudos">Send Kudos</a></li>
		<li><a href="<c:url value="/" />" id="download_kudos">Download</a></li>
		</div>
	</ul>
	</div>
	</div>
	</body>
</html>