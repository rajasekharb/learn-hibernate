package com.brs.hibernate;

import com.brs.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class TestUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

    /*
        Used as common way of retrieving all the entities. Simple "select * from"
     */
    public static <T> void retrieveObjects(String entityName, Class<T> clazz) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        NativeQuery<T> nativeQuery = session.createNativeQuery("select * from " + entityName, clazz);

        List<T> objects = nativeQuery.getResultList();

        logger.info(objects.toString());

        transaction.commit();
        HibernateUtils.closeSession(session);
    }
}
