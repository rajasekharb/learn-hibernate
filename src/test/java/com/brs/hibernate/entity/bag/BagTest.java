package com.brs.hibernate.entity.bag;

import com.brs.hibernate.TestUtils;
import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajasekhar
 */
public class BagTest {

    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Showroom showroom = new Showroom();

        showroom.setManager("Scott");
        showroom.setLocation("Delhi");
        List<Car> cars = new ArrayList<>();
        showroom.setCars(cars);
        cars.add(new Car("Toyota", "White"));

        session.save(showroom);

        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void retrieveTest() throws Exception {
        TestUtils.retrieveObjects("t_showroom_map", Showroom.class);
    }
}