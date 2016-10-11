package com.brs.hibernate.collections.annotations;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.brs.hibernate.TestUtils.retrieveObjects;

/**
 * @author Rajasekhar
 */
public class OneToManyUsingForeignKeyTest {

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Skoda", "White"));
        cars.add(new Car("Benz", "Black"));

        Showroom showroom = new Showroom("Delhi", "scott", cars);

        Serializable serializable = session.save(showroom);

        transaction.commit();
        HibernateUtils.closeSession(session);
        Assert.assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom", Showroom.class);
    }
}