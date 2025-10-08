<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <p>An app to calculate the Age </p>

    <form action="processForm" method="post" class="d-flex gap-2" >
        <input type="text" name="year" placeholder="year">
        <input type="text" name="month" placeholder="month">
        <input type="text" name="day"  placeholder="day">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
</html>

