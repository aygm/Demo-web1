<%--
  Created by IntelliJ IDEA.
  User: 51467
  Date: 2020/6/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="basePath" value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"></c:set>

<html>
<head>
    <title>注册</title>
</head>
<body>
<form id="register" method="post">
    <input name="register_mode" type="radio" value="cellphone" checked="checked">手机号
    <input name="register_mode" type="radio" value="email" >邮箱<br/>
    手机号：<input type="cellphone" id="cellphone" name="cellphone" ><br/>
    用户名：<input type="userName" id="userName" name="userName" ><br/>
    邮箱：<input type="email" id="email" name="email" ><br/>
    密码：<input type="password" id="password" name="password" ><br/>
    确认密码：<input type="password" id="password_second" name="password_second" ><br/>
    <button type="submit">注册</button>
    <button type="button"><a href="index.jsp">返回</a></button>
</form>


<script src="${basePath }js/jquery-3.2.1.min.js"></script>
<script src="${basePath }js/popper.min.js"></script>
<script src="${basePath }js/bootstrap.min.js"></script>
<script src="${basePath }js/main.js"></script>
<script src="${basePath }js/jquery.validate.min.js"></script>


<script  type="text/javascript">

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
                    },
                    userName: {
                        required: true
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
                    },
                    userName: {
                        required: "不得为空"
                    }
                }, submitHandler: function () {
                    $.ajax({
                        async: true,
                        data: $("#register").serialize(),
                        dataType: 'json',
                        type: 'POST',
                        url: 'userAdd',
                        success: function (data) {
                            if (data.msg == 'success') {
                                layer.msg('注册成功');
                            } else if (data.msg == 'repeat') {
                                layer.alert('手机号或邮箱重复');
                            } else if (data.msg == 'error') {
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
                    },
                    userName: {
                        required: true
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
                    },
                    userName: {
                        required: "不得为空"
                    }
                }, submitHandler: function () {
                    $.ajax({
                        async: true,
                        data: $("#register").serialize(),
                        dataType: 'json',
                        type: 'POST',
                        url: 'userAdd',
                        success: function (data) {
                            if (data.msg == 'success') {
                                layer.msg('注册成功');
                            } else if (data.msg == 'repeat') {
                                layer.alert('手机号或邮箱重复');
                            } else if (data.msg == 'error') {
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
