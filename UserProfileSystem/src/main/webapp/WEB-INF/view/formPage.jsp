<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div class="form-container">
    <h2>Create Your Account</h2>

    <form action="processForm" method="post">
        <div class="form-group">
            <label>First Name</label>
            <input type="text" name="firstName" placeholder="Enter your firstName" required>
        </div>

        <div class="form-group">
            <label>Last Name</label>
            <input type="text" name="lastName" placeholder="Enter your lastName" required>
        </div>

        <div class="form-group">
            <label>Email Address</label>
            <input type="email" name="email" placeholder="Enter your email" required>
        </div>

        <div class="form-group">
            <label>Date of Birth</label>
            <input type="date" placeholder="DD-MM-YYYY" name="dateOfBirth" required>
        </div>

        <div class="form-group">
            <label>City</label>
            <input type="text" name="city" placeholder="Enter your lastName" required>
        </div>

        <button type="submit" class="btn-submit">Register</button>


    </form>
</div>
</body>
</html>