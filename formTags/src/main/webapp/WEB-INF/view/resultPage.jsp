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
            <td>role:</td>
            <td>${user.role}</td>
        </tr>
        <tr>
            <td>country:</td>
            <td>${user.country}</td>
        </tr>
        <tr>
            <td>programmingLanguage:</td>
            <td>${user.programmingLanguage}</td>
        </tr>
        <tr>
            <td>operatingSystems:</td>
            <td>${user.operatingSystems}</td>
        </tr>
    </table>
</div>
</body>
</html>
