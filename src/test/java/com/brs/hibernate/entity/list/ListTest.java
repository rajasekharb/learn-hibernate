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

import static com.brs.hibernate.TestUtils.retrieveObjects;
import static org.junit.Assert.assertNotNull;

/**
 * @author Rajasekhar
 */
public class ListTest {

    private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Showroom showroom = new Showroom();

        showroom.setLocation("Delhi");
        showroom.setManager("Scott");

        List<Car> list = new ArrayList<>();

        /*List allows duplicates*/
        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "silver"));
        list.add(new Car("Ford", "green"));

        showroom.setCars(list);

        Serializable serializable = session.save(showroom);
        logger.info("Saved with id {} ", serializable);

        transaction.commit();
        HibernateUtils.closeSession(session);

        assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom_list", Showroom.class);
    }
}