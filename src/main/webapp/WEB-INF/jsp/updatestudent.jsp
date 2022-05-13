<%--
  Created by IntelliJ IDEA.
  User: 李寻欢
  Date: 2022/5/8
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>UPDATESTUDENT2</h2>
<form action="${pageContext.request.contextPath }/update" method="post">
    <table border="0" align="center" width="40%" style="margin-left: 100px">
        <tr>
            <td width="100px">id</td>
            <td width="40%">
                <input type="text" name="id" value="${Stu.id}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td width="100px">姓名</td>
            <td width="40%">
                <input type="text" name="name" value="${Stu.name}">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男" id="male" value="${gender}">
                <label for="male">男</label>
                <input type="radio" name="gender" value="女" id="female" value="${gender}">
                <label for="female">女</label>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age" value="${Stu.age}"/>
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <input type="text" name="phone" id="phone" value="${Stu.phone}"/>
            </td>
        </tr>
        <tr>
            <td>班级</td>
            <td>
                <input type="text" name="cla" id="cla" value="${Stu.cla}"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="修改"/>
            </td>
        </tr>
    </table>
</form>
${msg}
</body>
</html>
