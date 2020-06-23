package service;

import dao.UserloginlogDao;
import model.Userloginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserloginlogService {
    @Autowired
    private UserloginlogDao userloginlogDao;

    public void getList(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        Integer userId=(Integer)session.getAttribute("userId");
        List<Userloginlog> list=userloginlogDao.getList(userId);
        request.setAttribute("list",list);
    }
}
