<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/student/update" method="post">
    <input type="hidden" name="id" value="${student.id}" />
<table>
    <tr>
        <td><input type="text" name="name" value="${student.name}" /></td>
    </tr>
    <tr>
        <td><input type="text" name="age" value="${student.age}" /></td>
    </tr>
    <tr>
        <td><input type="text" name="money" value="${student.money}" /></td>
    </tr>
    <tr>
        <td><input type="submit" value="提交" /></td>
    </tr>
</table>
</form>
</body>
</html>