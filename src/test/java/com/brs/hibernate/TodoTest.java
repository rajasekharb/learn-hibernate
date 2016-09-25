package com.brs.hibernate;

import com.brs.hibernate.entity.Todo;
import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rajasekhar
 */
public class TodoTest {

    private static final Logger logger = LoggerFactory.getLogger(TodoTest.class);

    @Test
    public void insertTest() throws Exception {
        //begin
        Session session = HibernateUtils.openSession();

        //begin
        Transaction transaction = session.getTransaction();
        transaction.begin();

        //save
        Serializable serializable = session.save(new Todo("Keep learning", "Learn hibernate 5.2.2.Final"));

        //commit
        transaction.commit();

        //close
        HibernateUtils.closeSession(session);

        Assert.assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        //begin
        Session session = HibernateUtils.openSession();

        //begin
        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Todo> list = session.createQuery("from Todo", Todo.class).list();
        Assert.assertNotNull(list);
        logger.info(list.toString());
    }
}