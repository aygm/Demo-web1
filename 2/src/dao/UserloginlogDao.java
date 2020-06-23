package dao;

import model.Userloginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.DateUtils;

import java.util.List;

@Repository
public class UserloginlogDao {
    @Autowired
    private CommonDao commonDao;

    /**
     * 根据用户ID获取登录记录列表
     * @param userId
     * @return
     */
    public List<Userloginlog> getList(Integer userId) {
        String hql="from Userloginlog where userId="+userId;
        List<Userloginlog> list=commonDao.queryList(hql);
        return list;
    }

    /**
     * 添加登录记录
     * @param userId
     * @param currentTime
     * @param ip
     * @return
     */
    public boolean add(Integer userId, String currentTime, String ip) {
        try{
            Userloginlog log=new Userloginlog();
            log.setLoginId(userId);
            log.setLoginTime(currentTime);
            log.setLoginIp(ip);
            commonDao.save(log);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
