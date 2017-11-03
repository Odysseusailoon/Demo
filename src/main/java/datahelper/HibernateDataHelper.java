package datahelper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import util.ResultMessage;

import javax.persistence.PersistenceException;
import java.util.ArrayList;

public class HibernateDataHelper<T> implements DataHelper<T> {
    private SessionFactory sessionFactory;
    private Session session;
    private Class<T> type;
    public HibernateDataHelper(Class<T> type) {
        this.type=type;
        Configuration configuration = new Configuration();
        sessionFactory = configuration.configure().buildSessionFactory();
    }

    /**
     * 初始化Session
     */
    private void setUpSession() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    /**
     * 提交事务及关闭session
     */
    private void commitAndClose() {
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public ResultMessage save(Object o) {
        try {
            setUpSession();
            session.save(o);
            commitAndClose();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return ResultMessage.EXIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMessage.FAILED;
        }
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList getAll() {
        setUpSession();
        Query query =session.createQuery("from Demo");
        ArrayList<T> arrayList = (ArrayList<T>) query.list();
        session.close();
        return arrayList;
    }
}
