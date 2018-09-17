<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .tableV tr td{
            line-height: 36px;
        }
    </style>
</head>
<body>
<form action="/money/mtm" method="post">
    <input type="hidden" name="fromId" value="${fromId}" />
<table class="tableV">
    <tr>
        <td>转给誰：(ID)</td>
        <td><input type="text" name="toId" /></td>
    </tr>
    <tr>
        <td>钱数：</td>
        <td><input type="text" name="money" value="0" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="radio" value="0" name="gender" checked="checked">测试正常</input>
            <input type="radio" value="1" name="gender">转账失败，事务回滚。</input>
        </td>
    </tr>
    <tr>
        <td colspan="2">模拟错误。在service模拟 int zero = 1/0;//模拟异常</td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="提交" /></td>
    </tr>
</table>
</form>
</body>
</html>