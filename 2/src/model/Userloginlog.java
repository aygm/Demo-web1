package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Userloginlog {
    private int loginId;
    private int userId;
    private String loginTime;
    private String loginIp;

    @Id
    @Column(name = "login_id", nullable = false)
    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login_time", nullable = false, length = 11)
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "login_ip", nullable = false)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userloginlog that = (Userloginlog) o;
        return loginId == that.loginId &&
                userId == that.userId &&
                loginIp == that.loginIp &&
                Objects.equals(loginTime, that.loginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, userId, loginTime, loginIp);
    }
}
