<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Product</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
 <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

   <marquee>     <h2>Welcome ${pageContext.request.userPrincipal.name}  </h2></marquee>
<h2><a style="float:right" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>

</div>
<div class="form-group" align="center">	
		<h1> New Claim</h1>
		<br/>
	<form:form action="save" method="post"  modelAttribute="productForm" novalidate="novalidate" class="form-signin">
     <table>
			<tr>
				<td> Name:</td>
				<td><form:input class="form-control" path="name" placeholder="Name" /></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><form:input class="form-control" path="Category" placeholder="Category" /></td>
				<%-- <font color="red"><form:errors path="age" /></font> --%>
			</tr>
			<tr>
				<td>Start date:</td>
				<td><form:input type="date" class="form-control" placeholder="Start Date" path="startDate" /></td>
			</tr>
			<tr>
				<td>End date:</td>
				<td><form:input type="date" class="form-control" placeholder="End Date" path="EndDate" /></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><form:input class="form-control" placeholder="Amount" path="price" /></td>
			</tr>
			
		</table><br>
		&nbsp;&nbsp;&nbsp;&nbsp;
<td><input type="submit" class="btn btn-lg btn-primary " value="Claim Money" /></td>
		&nbsp;&nbsp;		<td><input type="reset" class="btn btn-lg btn-danger " value="Cancel" /></td>
			
      </form:form>
</div>

</body>
</html>