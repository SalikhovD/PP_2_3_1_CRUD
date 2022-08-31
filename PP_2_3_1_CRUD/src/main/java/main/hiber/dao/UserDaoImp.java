package main.hiber.dao;

import main.hiber.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
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
    public List<User> listUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }
}
