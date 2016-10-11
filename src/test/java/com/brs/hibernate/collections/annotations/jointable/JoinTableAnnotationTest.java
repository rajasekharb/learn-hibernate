package com.brs.hibernate.collections.annotations.jointable;

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
public class JoinTableAnnotationTest {
    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Mercedes", "White"));
        cars.add(new Car("BMW", "Black"));

        Showroom showroom = new Showroom("Hyderabad", "Amar", cars);

        Serializable serializable = session.save(showroom);

        transaction.commit();
        HibernateUtils.closeSession(session);
        Assert.assertNotNull(serializable);
    }

    @Test
    public void retrieveTest() throws Exception {
        retrieveObjects("t_showroom_annotation_join_table", Showroom.class);
    }
}