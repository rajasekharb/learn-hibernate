package com.brs.hibernate.entity.list;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Rajasekhar
 */
public class ShowroomTest {

    private static final Logger logger = LoggerFactory.getLogger(ShowroomTest.class);

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Showroom showroom = new Showroom();

        showroom.setLocation("Delhi");
        showroom.setManager("Scott");

        List<Car> list = new ArrayList<>();

        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "silver"));

        showroom.setCars(list);

        Serializable serializable = session.save(showroom);
        logger.info("Saved with id {} ", serializable);

        transaction.commit();
        HibernateUtils.closeSession(session);

        assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Showroom> showrooms = session.createQuery("from Showroom", Showroom.class).list();
        logger.info(showrooms.toString());

        transaction.commit();
        HibernateUtils.closeSession(session);
    }
}