<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Kudos - Expedia</title>
	<link rel="stylesheet" href="<c:url value="resources/css/sunny/jquery-ui-1.10.1.custom.css"/>"/>
	
	<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
	<link rel="stylesheet" href="<c:url value="resources/css/jquery.dataTables.css"/>"/>
	
	<script type="text/javascript" src="/lux/resources/js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="/lux/resources/js/jquery-ui-1.10.1.custom.js"></script>
	<script type="text/javascript" src="/lux/resources/js/application.js"></script>
	<script type="text/javascript" src="/lux/resources/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="/lux/resources/js/dataTables.pagination.js"></script>
</head>
<div id="header">
	<div class="left_div"><h2> Kudos!
	<img src="<c:url value='/resources/images/icon_goodjob.gif'/>"/>
	</h2>
	</div>	
	<div class="right_div"><h2> Welcome ${username}! </h2></div>
	
</div>
</html>