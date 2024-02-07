package com.daaeboul.taskmanagementsystem.dao;

import com.daaeboul.taskmanagementsystem.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("From User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User save(User user) {
        User dbUser = entityManager.merge(user);
        return dbUser;
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public List<User> findByUsername(String username) {
        TypedQuery<User> theQuery = entityManager.createQuery("From User Where username=:theData", User.class);
        theQuery.setParameter("theData", username);
        return theQuery.getResultList();
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
