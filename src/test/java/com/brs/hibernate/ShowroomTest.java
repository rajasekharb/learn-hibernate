package com.brs.hibernate;

import com.brs.hibernate.entity.Car;
import com.brs.hibernate.entity.Showroom;
import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajasekhar
 */
public class ShowroomTest {
    @Test
    public void testCarInsert() throws Exception {
        Session session = HibernateUtils.openSession();

        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Car> list = new ArrayList<Car>();
        list.add(new Car("Toyota", "White"));
        list.add(new Car("Toyota", "Green"));

        Showroom showroom = new Showroom();
        showroom.setLocation("Hyderabad");
        showroom.setManager("Scott");
        showroom.setCarList(list);

        session.save(showroom);
        transaction.commit();
        HibernateUtils.closeSession(session);
    }
}
