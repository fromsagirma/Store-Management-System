<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Login</title>
<link rel="stylesheet" href="assets/css/style.css">
<style>
.login-box {
    width: 350px;
    margin: 120px auto;
    padding: 25px;
    background: white;
    border-radius: 8px;
}
.login-box h2 { text-align: center; }
.login-box input, .login-box button, .login-box select {
    width: 100%;
    margin-top: 10px;
    padding: 10px;
}
.error { color: red; text-align: center; margin-top: 10px; }
</style>
</head>
<body>

<div class="login-box">
    <h2>Store Management Login</h2>

    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email Address" required>

        <input type="password" name="password" placeholder="Password" required>
        <select name="role" required>
            <option value="">-- Select Role --</option>
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>
        <button type="submit">Login</button>
    </form>

    <div class="error">${error}</div>
</div>
<p>Don’t have an account? <a href="signup.jsp">Sign up</a></p>

</body>
</html>
