<%--
  Created by IntelliJ IDEA.
  User: 51467
  Date: 2020/6/23
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"></c:set>

<html>
  <head>
    <title>登录</title>
    </head>
  <body>
  <form id="login" method="post">
    账户：<input type="text" id="account" name="account" autofocus="autofocus" placeholder="邮箱/手机号"><br/>
    密码：<input type="password" id="password" name="password" placeholder="密码"><br/>
    <button type="submit">登录</button>
    <button type="button"><a href="register.jsp">注册</a></button>
  </form>

  </body>

  <script src="${basePath }js/jquery-3.2.1.min.js"></script>
  <script src="${basePath }js/popper.min.js"></script>
  <script src="${basePath }js/bootstrap.min.js"></script>
  <script src="${basePath }js/main.js"></script>
  <script src="${basePath }js/jquery.validate.min.js"></script>

  <script type="text/javascript">
      $("#login").validate({
        rules : {
          account : "required",
          password : "required"
        },
        messages : {
          account : "账户不能为空",
          password : "密码不能为空"
        },
        submitHandler:function(){
          $.ajax({
            async:true,
            data:$("#login").serialize(),
            dataType:'json',
            type:'POST',
            url:'login',
            success:function(data){
              if(data.msg=='success'){
                layer.msg('登录成功',{time:2000}, function(index){
                  window.location.href='index';
                });
              }else if(data.msg=='password_error'){
                layer.alert('账号或密码错误');
              }else{
                layer.alert('出错！');
              }
            }
          });
        }
      });
  </script>
</html>
