package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommonDao extends HibernateDaoSupport {
    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 保存实体类
     * @param entity
     */
    @Transactional(readOnly=false)
    public void save(Object entity) {
        this.getHibernateTemplate().save(entity);
    }

    /**
     * 更新实体类
     * @param entity
     */
    @Transactional(readOnly=false)
    public void update(Object entity) {
        this.getHibernateTemplate().update(entity);
    }

    /**
     * 根据主键ID获取数据
     * @param entityClass
     * @param id
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Transactional(readOnly=true)
    public Object get(Class entityClass, Integer id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    /**
     * 通过HQL查询实体对象
     * @param hql
     * @return
     */
    @Transactional(readOnly=true)
    public Object queryEntity(String hql) {
        Session session = null;
        Object object = null;
        try {
            session = this.currentSession();
            Query query = session.createQuery(hql);
            if (query!=null) {
                object = query.uniqueResult();
            }
        } catch (Exception e) {
            throw e;
        }
        return object;
    }

    /**
     * 通过HQL查询实体对象列表
     * @param hql
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Transactional(readOnly=true)
    public List queryList(String hql) {
        Session session = null;
        List list = null;
        try {
            session = this.currentSession();
            Query query = session.createQuery(hql);
            if (query!=null) {
                list = query.list();
            }
        } catch (Exception e) {
            throw e;
        }
        return list;
    }


}
