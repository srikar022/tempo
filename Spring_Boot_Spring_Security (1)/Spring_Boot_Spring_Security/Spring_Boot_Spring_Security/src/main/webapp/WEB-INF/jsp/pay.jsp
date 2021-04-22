<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Payslip</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .table {
   margin: auto;
   width: 50%; 
}
    </style>
</head>
<body>

<div align="center">	
	<h1>Global Claims System</h1>

	<h3>Payslip</h3>
	<br/><br/>	
	<table class="table table-stripped">
	
		<tbody>
		<tr>
		<td>Claim ID</td>
			<td>${pay.id}</td></tr>
			<tr><td>name</td>
			<td>${pay.name}</td></tr>
			<tr><td>Category</td>
			<td>${pay.category}</td></tr>
			<tr><td>Start Date</td>
			<td>${pay.startDate}</td></tr>
			<tr><td>End Date</td>
			<td>${pay.endDate}</td></tr>
			<tr><td>Amount</td>
			<td>${pay.price}</td></tr>
			<tr><td>Status</td>
			<td>${pay.status}</td></tr>
			

		</tbody>
	
	</table>
</div>
<div class="container" align="center">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h3> <a onclick="document.forms['logoutForm'].submit()">Back to Home Page</a></h3>

    </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
