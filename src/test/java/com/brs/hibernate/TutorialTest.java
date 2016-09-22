package com.brs.hibernate;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;

/**
 * @author Rajasekhar
 */
public class TutorialTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @After
    public void tearDown() throws Exception {
        HibernateUtils.shutdown();
    }
}