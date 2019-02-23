<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mobileOperator</title>
</head>
<body>
<h1>Add new client</h1>
<p>Information about new client:</p>
<div>
    <form method="post" action="/add">
        <p><input type="text" name="firstName" placeholder="firstName"></p>
        <p><input type="text" name="lastName" placeholder="lastName"></p>
        <p><input type="text" name="birthDate" placeholder="YYYY MM DD"></p>
        <p><input type="text" name="passportData" placeholder="passportData"></p>
        <p><input type="text" name="address" placeholder="address"></p>
        <p><input type="text" name="email" placeholder="email"></p>
        <p><input type="text" name="password" placeholder="password"></p>
        <p><button type="submit" value="OK">Add new client</button></p>
    </form>
</div>
</body>
</html>