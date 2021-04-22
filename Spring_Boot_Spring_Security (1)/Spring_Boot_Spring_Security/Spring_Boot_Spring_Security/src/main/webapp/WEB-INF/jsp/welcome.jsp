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

    <title>Global Claims System</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .table {
   margin: auto;
   width: 50%; 
}
    </style>
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
<marquee>     <h2>Welcome ${pageContext.request.userPrincipal.name}  </h2></marquee>
        <h2>  <a style="float: right" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>

</div>
<div align="center">	
	<h1>Global Claims System</h1>
	<div>
		<h3><a href="new">Claim Money</a></h3>
	</div>
	
	<br/><br/>	
	<table class="table table-stripped">
		<thead>
			<tr>
				<th>Claim ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Amount</th>	
					<th>Status</th>		
					<th>Payment Status</th>	
				<th>RM Actions</th>	
				<th>EhPay action</th>			
			
			</tr>
		</thead>
		<c:forEach var="product" items="${plist}">
		<tbody>
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.category}</td>
			<td>${product.startDate}</td>
			<td>${product.endDate}</td>
			<td>${product.price}</td>
			<td>${product.status}</td>
			<td>${product.payment}</td>
			<td><a href="/Approve/${product.id}">Approve</a> 
            <a href="/Reject/${product.id}">Reject</a></td>
            <td> <a href="/Pay/${product.id}">Pay</a></td> 
		</tr>
		</tbody>
		</c:forEach>
	</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
