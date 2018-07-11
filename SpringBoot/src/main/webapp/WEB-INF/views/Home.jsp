<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/frameworks/jquery_min-3.3.1.js"></script>
<link rel="stylesheet" href="css/manualStyles.css"></link>
</head>
<body>
	<h1>This is Spring boot Application</h1><br>
	<h2><c:out value="${message}"></c:out></h2>
	<br>
	<a href="viewOrders.htm">view Orders</a>
</body>
</html>