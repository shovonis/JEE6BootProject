package net.therap.dao.impl;


import net.therap.dao.UserDao;
import net.therap.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "userDaoImpl")
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public User getUser(String userName, String password) {
        User user = null;

        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM  User user WHERE user.userName=:userName" +
                " AND user.password=:password", User.class);

        query.setParameter("userName", userName);
        query.setParameter("password", password);
        try {
            user = query.getSingleResult();
        } catch (NoResultException exception) {
            System.err.println("Error ");
        }
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }
}
