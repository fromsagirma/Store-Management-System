<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<style>
.login-box {
    width: 350px;
    margin: 120px auto;
    padding: 25px;
    background: white;
    border-radius: 8px;
}
.login-box h2 {
    text-align: center;
}
.login-box input, .login-box button {
    width: 100%;
    margin-top: 10px;
}
.error {
    color: red;
    text-align: center;
    margin-top: 10px;
}
</style>
</head>
<body>

<div class="login-box">
    <h2>Store Management Login</h2>

    <form action="login" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <div class="error">${error}</div>
</div>

</body>
</html>
