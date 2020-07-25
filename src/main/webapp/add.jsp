<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Hello World!</h2>
<form id="addForm" action="/Employee" method="post">
    <table border="1">
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="name" placeholder="员工姓名"><font>${employee.name}</font></td>
        </tr>
        <tr>
            <td>员工性别</td>
            <td>
                <input  type="radio" checked ="checked" name="gender" value="1">男

                <input  type="radio"  name="gender" value="2">女

            </td>
        </tr>
        <tr>
            <td>员工年龄</td>
            <td><input type="text" name="age" placeholder="员工年龄">
                <font>${employee.age}</font></td>
        </tr>
        <tr>
            <td>员工地址</td>
            <td><input type="text" name="address" placeholder="员工地址">
                <font>${employee.address}</font></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加用户" onclick="add()">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
