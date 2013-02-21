<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Kudos - Expedia</title>
	<link rel="stylesheet" href="<c:url value="resources/css/sunny/jquery-ui-1.10.1.custom.css"/>"/>
	
	<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
	
	<script type="text/javascript" src="/lux/resources/js/jquery-1.9.1.js"></script>
	
	<script type="text/javascript" src="/lux/resources/js/jquery-ui-1.10.1.custom.js"></script>
	
	
	
	<script>
	$(function() {
		$("#menu").menu();
	});
	</script>
	
</head>
<body id="home">

<div id="wrapper">
<div id="header">
	<div class="left_div"><h2> Kudos  </h2></div>	
	<div class="right_div"><h2> Welcome ${username}! </h2></div>
	
</div>
	<div id="content" style="clear:both;width:900px;">
	
	<div id="sidebar">
		<ul id="menu">
			<li><a href="<c:url value="/" />" id="my_team">My team</a></li>
			<li><a href="<c:url value="/send_kudos" />" id="send_kudos_link">Send Kudos</a></li>
			<li><a href="<c:url value="/" />" id="download_kudos">Download</a></li>
	
		</ul>
	</div>
	<br/>
		<h3>Listing kudos sent and received in your team.</h3>
		<table class="kudos_content">
			<th>Kudos sent from</th>
			<th>Kudos sent to </th>
			<th>Content</th>
			<th>Manager Name</th>
			<th>Date sent</th>
			
		<c:forEach items="${kudos}" var="k">
		<tr>
			<c:forEach items="${k.getUsers()}" var="u">
				<td><c:out value="${u.username}" /></td>
		
			</c:forEach>
			<td><c:out value="${k.kudosContent}" /></td>
			<c:forEach items="${k.getTeams()}" var="team">
				<td><c:out value="${team.manager}" /></td>
		
			</c:forEach>
			<td><c:out value="${k.dateSent}" /></td>	
			
		</tr>
		</c:forEach>
		</table>
	</div>
	
</div>

</body>
</html>
