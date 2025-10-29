<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <style>
        .error {
            color: #dc3545;
            font-size: 0.9rem;
        }
    </style>
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">User Form</h2>

        <form:form action="processForm" method="post" modelAttribute="user">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <form:input path="userName" type="text" cssClass="form-control" placeholder="Enter your username"/>
                <form:errors path="userName" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Email Address</label>
                <form:input path="email" type="email" cssClass="form-control" placeholder="Enter your email"/>
                <form:errors path="email" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <form:password path="password" cssClass="form-control" placeholder="Enter your password"/>
                <form:errors path="password" cssClass="error"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Confirm Password</label>
                <form:password path="confirmPassword" cssClass="form-control" placeholder="Re-enter your password"/>
                <form:errors path="confirmPassword" cssClass="error"/>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary w-50">Submit</button>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>
