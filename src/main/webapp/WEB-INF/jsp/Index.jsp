<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: 李寻欢
  Date: 2022/5/8
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Index</h2>
当前用户：${USER.username}
<a href="${pageContext.request.contextPath}/logout">退出</a>
<br>
<a href="${pageContext.request.contextPath}/toaddStudent">添加</a>
    <table align="center" width="800px"  >
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>电话号码</td>
            <td>班级</td>
            <td>进行操作</td>
        </tr>

        <c:forEach items="${list}" var="Stu">
            <tr>
                <td>${Stu.id}</td>
                <td>${Stu.name}</td>
                <td>${Stu.gender}</td>
                <td>${Stu.age}</td>
                <td>${Stu.phone}</td>
                <td>${Stu.cla}</td>
                <td><a href="toupdate?id=${Stu.id}">修改</a>
                    <a href="delete?id=${Stu.id}">删除</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
