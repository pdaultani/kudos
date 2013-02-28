<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<jsp:include page="header.jsp" />
<body id="home">

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
		<h3>Listing kudos sent and received in your team.</h3>
		<table class="tablesorter" id="kudos_table">
		<thead>
			<th>Kudos sent from</th>
			<th>Kudos sent to </th>
			<th>Content</th>
			<th>Manager Name</th>
			<th>Date sent</th>
		</thead>
		<tbody>
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
		</tbody>
		</table>
		
	</div>
	
</div>

</body>
</html>
