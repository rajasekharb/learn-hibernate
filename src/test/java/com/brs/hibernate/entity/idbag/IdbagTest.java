package com.brs.hibernate.entity.idbag;

import com.brs.hibernate.TestUtils;
import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajasekhar
 */
public class IdbagTest {
    @Test
    public void insertTest() throws Exception {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Showroom showroom = new Showroom();

        showroom.setManager("Mary");
        showroom.setLocation("Bombay");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Rolls Royce", "White"));

        showroom.setCars(cars);
        session.save(showroom);

        session.getTransaction().commit();
        HibernateUtils.closeSession(session);
    }

    @Test
    public void retrieveTest() throws Exception {
        TestUtils.retrieveObjects("t_showroom_idbag", Showroom.class);
    }
}


