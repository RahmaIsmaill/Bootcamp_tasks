<!DOCTYPE html>
<html>
<head>
    <title>Submission Result</title>
    <style>
        .result-box {
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
            display: inline-block;
        }

        h3 {
            color: #28a745;
            margin-bottom: 20px;
        }



    </style>
</head>
<body>
<div class="result-box">
    <h3>Data submitted successfully!</h3>

    <table>
        <tr>
            <td>First Name:</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td>${user.dob}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${user.city}</td>
        </tr>
    </table>
</div>
</body>
</html>
