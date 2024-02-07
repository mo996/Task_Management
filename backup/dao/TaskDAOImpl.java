package com.daaeboul.taskmanagementsystem.dao;

import com.daaeboul.taskmanagementsystem.model.Task;
import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Task save(Task task) {
        return entityManager.merge(task);
    }

    @Override
    public Task findById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> theQuery = entityManager.createQuery("From Task", Task.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Task> findByTitle(String title) {
        TypedQuery<Task> theQuery = entityManager.createQuery("From User Where title=:theData", Task.class);
        theQuery.setParameter("theData", title);
        return theQuery.getResultList();
    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        TypedQuery<Task> theQuery = entityManager.createQuery("From User Where status=:theData", Task.class);
        theQuery.setParameter("theData", status);
        return theQuery.getResultList();
    }

    @Override
    public List<Task> findByDueDate(LocalDate date) {
        TypedQuery<Task> query = entityManager.createQuery("FROM Task WHERE dueDate = :date", Task.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<Task> findByUser(User user) {
        TypedQuery<Task> query = entityManager.createQuery("FROM Task WHERE user = :user", Task.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
    }
}
