package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserloginlogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserloginlogController {
    @Autowired
    private UserloginlogService userloginlogService;

    //前往登录记录列表
    @RequestMapping("UserloginlogList")
    public ModelAndView UserloginlogList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        //获取登录记录列表
        userloginlogService.getList(request,response);
        mav.setViewName("/userloginlog_list.jsp");
        return mav;
    }
}
