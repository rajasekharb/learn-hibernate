package com.brs.hibernate.entity.set;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.brs.hibernate.TestUtils.retrieveObjects;
import static org.junit.Assert.assertNotNull;

/**
 * @author Rajasekhar
 */
public class SetTest {

    private static final Logger logger = LoggerFactory.getLogger(SetTest.class);

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Showroom showroom = new Showroom();

        showroom.setLocation("Delhi");
        showroom.setManager("Scott");

        Set<Car> set = new HashSet<>();

        /*Now duplicates wont be stored*/
        set.add(new Car("Ford", "silver"));
        set.add(new Car("Ford", "silver"));
        set.add(new Car("Ford", "silver"));
        set.add(new Car("Ford", "Green"));

        showroom.setCars(set);

        Serializable serializable = session.save(showroom);
        logger.info("Saved with id {} ", serializable);

        transaction.commit();
        HibernateUtils.closeSession(session);

        assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom", Showroom.class);
    }
}