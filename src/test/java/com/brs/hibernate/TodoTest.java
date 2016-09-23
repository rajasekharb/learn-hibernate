package com.brs.hibernate;

import com.brs.hibernate.entity.Todo;
import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author Rajasekhar
 */
public class TodoTest {

    @Test
    public void insertTest() {
        //begin
        Session openSession = HibernateUtils.openSession();

        //begin
        Transaction transaction = openSession.getTransaction();
        transaction.begin();

        //save
        openSession.save(new Todo("Keep learning", "Learn hibernate 5.2.2.Final"));

        //commit
        transaction.commit();

        //close
        HibernateUtils.closeSession(openSession);
    }
}