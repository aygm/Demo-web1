package controller;

import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping("userAdd")
    public void userAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject res = userService.saveUser(request, response);
        response.getWriter().write(res.toJSONString());
    }

    //登录
    @RequestMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject res = userService.login(request, response);
        response.getWriter().write(res.toJSONString());
    }
}
