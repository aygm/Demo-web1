<%--
  Created by IntelliJ IDEA.
  User: 51467
  Date: 2020/6/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form id="register" method="post">
    <input name="register_mode" type="radio" value="cellphone" checked="checked">手机号
    <input name="register_mode" type="radio" value="email" >邮箱<br/>
    手机号：<input type="cellphone" id="cellphone" name="cellphone" ><br/>
    邮箱：<input type="email" id="email" name="email" ><br/>
    密码：<input type="password" id="password" name="password" ><br/>
    确认密码：<input type="password" id="password_second" name="password_second" ><br/>
    <button type="submit">注册</button>
    <button type="button"><a href="index.jsp">返回</a></button>
</form>

<%--<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath() %>/tools/layer/layer.js"></script>--%>
<script src="<%=basePath %>js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath %>js/popper.min.js"></script>
<script src="<%=basePath %>js/bootstrap.min.js"></script>
<script src="<%=basePath %>js/main.js"></script>
<script src="<%=basePath %>js/jquery.validate.min.js"></script>


<script  type="text/javascript">
    $("input[name=register_mode]").click(function(){
        var register_mode = $(this).val();
        if(register_mode=="cellphone"){
            $("#cellphone").show();
            $("#email").hide();
        }else if(register_mode=="email"){
            $("#cellphone").hide();
            $("#email").show();
        }
    });
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写手机号码");
    $(function(){
        var register_mode = $("input[name=register_mode]").val();
        if(register_mode=="cellphone") {
            $("#register").validate({
                rules: {
                    cellphone: {
                        required : true,
                        minlength: 11,
                        isMobile: true
                    },
                    password: {
                        required: true,
                        minlength: 8
                    },
                    password_second: {
                        required: true,
                        minlength: 8,
                        equalTo: "#password"
                    }
                },
                messages: {
                    cellphone: {
                        required : "不能为空",
                        minlength: "不能小于11个字符",
                        isMobile: "请正确填写手机号码"
                    },
                    password: {
                        required: "不能为空",
                        minlength: "密码长度不得小于8"
                    },
                    password_second: {
                        required: "不能为空",
                        minlength: "密码长度不得小于8",
                        equalTo: "两次输入不一致"
                    }
                }, submitHandler: function () {
                    $.ajax({
                        async: true,
                        data: $("#login").serialize(),
                        dataType: 'json',
                        type: 'POST',
                        url: 'login',
                        success: function (data) {
                            if (data.msg == 'success') {
                                layer.msg('登录成功', {time: 2000}, function (index) {
                                    window.location.href = 'index';
                                });
                            } else if (data.msg == 'password_error') {
                                layer.alert('账号或密码错误');
                            } else {
                                layer.alert('出错！');
                            }
                        }
                    });
                }
            });
        }
        else if(register_mode=="email") {
            $("#register").validate({
                rules: {
                    email: {
                        required: true
                    },
                    password: {
                        required: true,
                        minlength: 8
                    },
                    password_second: {
                        required: true,
                        minlength: 8,
                        equalTo: "#password"
                    }
                },
                messages: {
                    email: {
                        required: "不能为空"
                    },
                    password: {
                        required: "不能为空",
                        minlength: "密码长度不得小于8"
                    },
                    password_second: {
                        required: "不能为空",
                        minlength: "密码长度不得小于8",
                        equalTo: "两次输入不一致"
                    }
                }, submitHandler: function () {
                    $.ajax({
                        async: true,
                        data: $("#login").serialize(),
                        dataType: 'json',
                        type: 'POST',
                        url: 'login',
                        success: function (data) {
                            if (data.msg == 'success') {
                                layer.msg('登录成功', {time: 2000}, function (index) {
                                    window.location.href = 'index';
                                });
                            } else if (data.msg == 'password_error') {
                                layer.alert('账号或密码错误');
                            } else {
                                layer.alert('出错！');
                            }
                        }
                    });
                }
            });
        }
    })




</script>
</body>
</html>
