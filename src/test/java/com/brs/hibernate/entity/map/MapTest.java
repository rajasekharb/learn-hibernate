package com.brs.hibernate.entity.map;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.brs.hibernate.TestUtils.retrieveObjects;
import static org.junit.Assert.assertNotNull;

/**
 * @author Rajasekhar
 */
public class MapTest {
    private static final Logger logger = LoggerFactory.getLogger(MapTest.class);

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Showroom showroom = new Showroom();

        showroom.setLocation("Delhi");
        showroom.setManager("Scott");

        Map<String, Car> cars = new HashMap<>();

        Car silver = new Car("Ford", "silver");
        Car green = new Car("Ford", "green");

        cars.put("Tiger", silver);
        cars.put("King", green);
        showroom.setCars(cars);

        Serializable serializable = session.save(showroom);
        logger.info("Saved with id {} ", serializable);

        transaction.commit();
        HibernateUtils.closeSession(session);

        assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom_map", Showroom.class);
    }
}