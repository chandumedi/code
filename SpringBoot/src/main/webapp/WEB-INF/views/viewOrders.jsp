<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="https://boot.com/jsps/taglib/mytags" prefix="mn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Home.jsp"></jsp:include>
	<h1>These are List of ordered items....</h1>
	<br>
	<table>
		<tbody>
			<c:forEach items="${orderlist}" var="items">
				<tr>
					<td>${items.itemCode}</td>
					<td>${items.quantity}</td>
					<c:set var = "balance" value = "${items.price}" />
					<fmt:setLocale value = "en_US"/>
					<td><fmt:formatNumber value="${balance}" type="currency" /></td>
					<td><a href="" onclick="showCustomerDetails()" style="color: aqua;">${items.branded}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Number Formatting Example</h2>
	<mn:formatNumber number="100050.574" format="#,###.00" />
	<br>
	<br>
	<mn:formatNumber number="1234.567" format="$# ###.00" />
	<br>
	<br>
</body>
</html>