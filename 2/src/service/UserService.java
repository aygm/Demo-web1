package service;
import com.alibaba.fastjson.JSONObject;
import dao.UserDao;
import dao.UserloginlogDao;
import model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DateUtils;
import util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserloginlogDao userloginlogDao;

    /**
     * 添加用户
     * @return
     * @param request
     * @param response
     * @param
     */
    public JSONObject saveUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject res = new JSONObject();
        User user=new User();
        String cellphone=request.getParameter("cellphone");
        String email=request.getParameter("email");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        boolean repeat=userDao.repeat(cellphone,email);
        if(repeat){
            res.put("msg","repeat");
        }else{
            user.setUserName(userName);
            user.setCellphone(cellphone);
            user.setEmail(email);
            user.setPassword(MD5Util.MD5(password));
            user.setCreateTime(DateUtils.getCurrentTime());
            user.setState(1);

            boolean result=userDao.saveUser(user);
            if(result){
                res.put("msg","success");
            }else{
                res.put("msg","error");
            }
        }
        return res;
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 登录
     * @param request
     * @param response
     * @return
     */
    public JSONObject login(HttpServletRequest request, HttpServletResponse response) {
        JSONObject res=new JSONObject();
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        Integer userId=null;
        if(StringUtils.isNoneBlank(account)&&StringUtils.isNoneBlank(password)){
            userId=userDao.getUserId(account,password);
            if(userId!=null){
                HttpSession session=request.getSession();
                //将用户ID存入session
                session.setAttribute("userId", userId);
                //添加登录记录
                boolean result=userloginlogDao.add(userId, DateUtils.getCurrentTime(),getIp(request));
                if(result){
                    res.put("msg","success");
                }else{
                    res.put("mag","error");
                }
            }else {
                res.put("mag","password_error");
            }
        }else {
            res.put("mag","error");
        }
        return res;
    }
}
