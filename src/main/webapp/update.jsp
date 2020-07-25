<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/7/25
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改员工</title>
</head>
<body>
<div id="addForm">

</div>


<script src="js/jquery-3.4.1.js"></script>
<script>
    $(selectById())
    function selectById(){
        var queryString = getQueryString("id");
        $.ajax({
            url:"/Employee/"+queryString,
            method:"get",
            success:function (data) {
                var datas= data.data;
                $("#addForm").empty()
                // $("#name").val("qq")
                var gender=datas.gender
               if (gender==1){
                   sg="员工性别<input  type=\"radio\" checked =\"checked\" name=\"gender\"  value=\"1\">男\n" +
                       "<input  type=\"radio\"  name=\"gender\"  value=\"2\">女"
               }else if (gender==2){
                   sg="员工性别<input  type=\"radio\"  name=\"gender\"  value=\"1\">男\n" +
                       "<input  type=\"radio\" checked =\"checked\" name=\"gender\"  value=\"2\">女"
               }
                var  s="<form id='update'>\n" +
                    "    <input type=\"hidden\" name=\"id\"  id=\"id\" value="+datas.id+">\n" +
                    "    员工姓名:<input type=\"text\" name=\"name\" placeholder=\"员工姓名\" id=\"name\" value="+datas.name+" >\n" +
                    "    <br>\n" +sg+
                     "    <br>\n" +
                    "    员工年龄<input type=\"text\" name=\"age\" placeholder=\"员工年龄\" value="+datas.age+">\n" +
                    "    <br>\n" +
                    "    员工地址<input type=\"text\" name=\"address\" placeholder=\"员工地址\" value="+datas.address+">\n" +
                    "    <br>\n" +
                    "    <input type=\"button\" value=\"修改用户\" onclick=\"update()\">\n" +
                    "\n" +
                    "</form>"
                $("#addForm").append(s)
            }
        })
    }

   function getQueryString(name){
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return unescape(r[2]); return null;
    }
    function update() {
        var data = $("#update").serialize();
        $.ajax({
            url:"/Employeesss",
            method:"post",
            data:data,

            success:function (data) {
                 window.location.href="/";
            }
        })
    }
</script>
</body>
</html>
