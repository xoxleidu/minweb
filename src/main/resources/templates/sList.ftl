<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript">



    </script>
</head>
<body>
<table>
    <tr>
        <form action="/student/query" method="post">
            <td>名字: <input type="text" name="name" id="name" /></td>
            <#--<td>年龄: <input type="text" name="age" /></td>
            <td>资产: <input type="text" name="money" /></td>-->
            <td><input type="submit" value="搜索" /></td>
        </form>
    </tr>
</table>
<br/>
<a href="/list.html">添加</a>
<br/>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>存款</th>
        <th>操作</th>
    </tr>
    <#list sList as s>
    <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.age}</td>
        <td>${s.money}</td>
        <td><a href="/money/mtmView/${s.id}">转账</a> || <a href="/student/find/${s.id}">修改</a> || <a href="/student/delete?id=${s.id}">删除</a> </td>
    </tr>
    </#list>
</table>
</body>
</html>