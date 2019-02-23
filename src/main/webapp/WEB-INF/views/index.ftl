<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mobileOperator</title>
</head>
<body>
<h1>Welcome to mobileOperator</h1>
<p>Information about</p>
<ul>
    <li><a href="/contract"> Contracts </a></li>
    <li><a href="/option"> Options </a></li>
    <li><a href="/tariff"> Tariffs </a></li>
    <p></p>
    <li><a href="/add"> ADD </a></li>
</ul>

<div>
    List of existing clients:
    <ul>
        <#list exist as item>
            <li>${item}</li>
        </#list>
    </ul>
</div>

<div>
    <form method="post" action="/search">
        <p><input type="text" name="firstName" placeholder="Search"></p>
    </form>
</div>


</body>
</html>