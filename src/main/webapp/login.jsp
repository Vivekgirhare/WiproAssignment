<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="register" method="post">

        <label for="fullName">Full name:</label><br/>
        <input type="text" id="fullName" name="fullName" required/><br/><br/>

        <label for="email">E-mail:</label><br/>
        <input type="email" id="email" name="email" required/><br/><br/>

        <label for="password">Password:</label><br/>
        <input type="password" id="password" name="password" required/><br/><br/>

        <label for="birthday">Birthday (yyyy-mm-dd):</label><br/>
        <input type="date" id="birthday" name="birthday" required pattern="\d{4}-\d{2}-\d{2}" /><br/><br/>

        <label>Gender:</label><br/>
        <input type="radio" id="male" name="gender" value="Male" required/>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female" required/>
        <label for="female">Female</label><br/><br/>

        <label for="profession">Profession:</label><br/>
        <select id="profession" name="profession" required>
            <option value="">--Select--</option>
            <option value="Developer">Developer</option>
            <option value="Designer">Designer</option>
            <option value="Manager">Manager</option>
            <option value="Other">Other</option>
        </select><br/><br/>

        <input type="checkbox" id="married" name="married" value="Yes" />
        <label for="married">Married?</label><br/><br/>

        <button type="submit">Register</button>

    </form>
</body>
</html>
