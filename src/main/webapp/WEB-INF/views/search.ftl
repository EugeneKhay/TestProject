<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mobileOperator</title>
</head>
<body>
<h1>Client</h1>
<p>Information about client</p>
<ol>
    <li>Name: ${firstName}</a></li>
    <li>Surname: ${lastName}</li>
    <li>BirthDate: ${birthDate}</li>
    <li>Passport: ${passportData}</li>
    <li>Address: ${address}</li>
    <li>E-mail: ${email}</li>
    <li>Password: ${password}</li>
    <li>
        <ul>
            Contracts:
            <#list contract as item>
                <li>${item}</li>
            </#list>
        </ul>
    </li>
</ol>
</body>
</html>