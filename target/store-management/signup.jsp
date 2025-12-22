<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>

<h2>Create Account</h2>

<form action="signup" method="post">
   <input type="email" name="email" placeholder="Email Address" required>

    <input type="password" name="password" placeholder="Password" required><br>

    <select name="role" required>
        <option value="">Select Role</option>
        <option value="admin">Admin</option>
        <option value="user">User</option>
    </select><br>

    <button type="submit">Sign Up</button>
</form>

<p style="color:red">${error}</p>
<p>Already have an account? <a href="login.jsp">Login</a></p>

</body>
</html>
