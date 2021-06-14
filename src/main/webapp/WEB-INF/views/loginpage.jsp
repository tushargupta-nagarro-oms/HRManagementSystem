<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>

<body>
    <div class="container mt-5">

        <form action="signin" method="post">
            <div class="from-group text-center">
                <h1>Login</h1>
            </div>

            <div class="from-group">
                <label for="labelusername">username</label>
                <input type="text" class="form-control" name="username" id="labelusername" minlength="5" maxlength="50" required>
            </div>
            <div class="from-group">
                <label for="labelpassword">Password</label>
                <input type="password" class="form-control" name="password" id="labelpassword" minlength="5" maxlength="50" required>
            </div>
            <div class="form-group mt-2 text-center">
                <input type="submit" class="btn btn-success" value="login">
            </div>

        </form>

    </div>
</body>

</html>