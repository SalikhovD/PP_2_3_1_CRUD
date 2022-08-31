package main.hiber.dao;

import main.hiber.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(User.class, id));
    }

    @Override
    public void saveOrUpdate(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = entityManager.unwrap(Session.class);
        TypedQuery<User> query = session.createQuery("from User");
        return query.getResultList();
    }


    @Override
    public User getUser(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void dropTable(String tableName) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "DROP TABLE  IF EXISTS " + tableName;
        session.createSQLQuery(sql).executeUpdate();
    }
}
