
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<div align="center">
    <table border="1">
        <thead >
        <tr align="center">
            <td> 员工编号</td><td> 员工姓名</td><td> 员工性别</td><td> 员工年龄</td><td> 员工地址</td><td> 操作</td>
        </tr>
        </thead>
        <tbody id="tbodys">

        </tbody>
        <tr>
            <td>
                <a href="add.jsp">添加员工</a> <a href="#">修改员工</a>
            </td>
        </tr>
    </table>
</div>
<script src="js/jquery-3.4.1.js"></script>
<script>
    $(selectAll())

    function selectAll(){
        $.ajax({
            url:"/Employees",
            method:"get",
            success:function (data) {
                var datas= data.data;
                $("#tbodys").empty()
                for(var k = 0;k < datas.length;k++){
                    var p = datas[k];
                    if (p.gender==1){
                        gender='男'
                    }else {
                        gender='女'
                    }
                    var s=" <tr>\n" +
                        "                <td>"+p.id+"</td>\n" +
                        "                <td>"+p.name+"</td>\n" +
                        "                <td>"+gender+"</td>\n" +
                        "                <td>"+p.age+"</td>\n" +
                        "                <td>"+p.address+"</td>\n" +
                        "                <td><a href='#' onclick='dele("+p.id+")'>删除</a>&nbsp;<a href=\"update.jsp?id="+p.id+"\">编辑</a></td>\n" +
                        "            </tr>";
                    $("#tbodys").append(s)
                }

            }
        })
    }

    function dele(id) {
        $.ajax({
            url: "/Employee/"+id,
            method: "post",
            data: {_method: "DELETE"},
            success(){
                selectAll()
            }
        })
    }
</script>
</body>
</html>
