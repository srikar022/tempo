<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="container">


<form:form method="POST" modelAttribute="userForm1" action="cpassword" class="form-signin">
  <h2 class="form-heading">Change Password</h2>
<div class="form-group mb-3">

<form:input type="text"  class="form-control"  placeholder="User Name" name="uname" path="uname"/>

</div>
<div class="mb-3">

<form:input type="password" class="form-control"  placeholder="Old Password" name="opwd" path="opwd" />

</div>
<div class="form-group mb-3">

<form:input type="password"  class="form-control" placeholder="New Password" name="npwd" path="npwd"/>

</div>
<div class="form-group mb-3">

<form:input type="password"   class="form-control" Placeholder="Confirm Password" name="pwd" path="pwd"/>

</div>
 <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
</div>
</body>
</html>