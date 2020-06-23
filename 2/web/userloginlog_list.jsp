<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 51467
  Date: 2020/6/23
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录记录</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>登陆时间</th>
            <th>登录IP</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userLoginLogList }" var="loginLog" varStatus="status">
            <tr>
                <td>${loginLog.loginTime }</td>
                <td>${loginLog.loginIp }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
