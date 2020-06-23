package dao;

import model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.MD5Util;

@Repository
public class UserDao {
    @Autowired
    private CommonDao commonDao;

    /**
     * 用户注册
     * @param u
     * @return
     */
    public boolean saveUser(User u){
        try{
            commonDao.save(u);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取用户ID
     * @param account
     * @param password
     * @return
     */
    public Integer getUserId(String account, String password) {
        Integer userId=null;
        String hql="from User ";
        if(account.contains("@")){
            hql+=" where email='"+account+"'";
        }
        else{
            hql=" where cellphone='"+account+"'";
        }
        hql+=" and password='"+ MD5Util.MD5(password)+"'";
        User user=(User)commonDao.queryEntity(hql);
        return user.getUserId();
    }

    /**
     * 判断手机号或邮箱是否重复
     * @param cellphone
     * @param email
     * @return
     */
    public boolean repeat(String cellphone, String email) {
        String hql="from User ";
        if(StringUtils.isNoneBlank(email)){
            hql+=" where email='"+email+"'";
        }
        else if(StringUtils.isNoneBlank(cellphone)){
            hql=" where cellphone='"+cellphone+"'";
        }
        User user=(User)commonDao.queryEntity(hql);
        if(user==null){
            return false;
        }else{
            return true;
        }
    }
}
