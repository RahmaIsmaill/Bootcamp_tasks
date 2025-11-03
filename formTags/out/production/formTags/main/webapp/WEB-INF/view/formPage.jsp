<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">Create Your Account</h2>

        <form:form action="processForm" method="post" modelAttribute="user">

            <div class="mb-3">
                <label class="form-label">Role</label>
                <form:input path="role" type="text" cssClass="form-control" placeholder="Enter your role"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <form:password path="password" cssClass="form-control" placeholder="Enter your password"/>
            </div>

            <div class="mb-3">
                <label class="form-label">Country</label>
                <form:select path="country" cssClass="form-select">
                    <form:option value="" label="Select Country"/>
                    <form:option value="egypt" label="Egypt"/>
                    <form:option value="usa" label="USA"/>
                    <form:option value="uk" label="UK"/>
                </form:select>
            </div>

            <div class="mb-3">
                <label class="form-label d-block">Programming Language</label>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="programmingLanguage" value="java" cssClass="form-check-input"/>
                    <label class="form-check-label">Java</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="programmingLanguage" value="python" cssClass="form-check-input"/>
                    <label class="form-check-label">Python</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton path="programmingLanguage" value="c++" cssClass="form-check-input"/>
                    <label class="form-check-label">C++</label>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label d-block">Operating Systems</label>
                <div class="form-check form-check-inline">
                    <form:checkbox path="operatingSystems" value="linux" cssClass="form-check-input"/>
                    <label class="form-check-label">Linux</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:checkbox path="operatingSystems" value="windows" cssClass="form-check-input"/>
                    <label class="form-check-label">Windows</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:checkbox path="operatingSystems" value="macos" cssClass="form-check-input"/>
                    <label class="form-check-label">macOS</label>
                </div>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary w-50">Submit</button>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>
