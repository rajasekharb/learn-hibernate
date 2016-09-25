package com.brs.hibernate.entity.array;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

import static com.brs.hibernate.TestUtils.retrieveObjects;

/**
 * @author Rajasekhar
 */
public class ArrayTest {
    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Showroom showroom = new Showroom();
        showroom.setLocation("Delhi");
        showroom.setManager("Scott");

        Car[] cars = new Car[]{new Car("Skoda", "White"), new Car("Benz", "Black")};

        showroom.setCars(cars);

        Serializable serializable = session.save(showroom);

        transaction.commit();
        HibernateUtils.closeSession(session);
        Assert.assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom_array", Showroom.class);
    }
}