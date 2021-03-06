package com.brs.hibernate.utils;

import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.metamodel.EntityType;
import java.util.Set;

/**
 * @author Rajasekhar
 */
public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY;
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtils.class);
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            SESSION_FACTORY = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            //There is a problem
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    private static void shutdown() {
        if (SESSION_FACTORY != null && !SESSION_FACTORY.isClosed()) {
            SESSION_FACTORY.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    //Just for testing purposes.
    public static void main(final String[] args) {
        final Session session = openSession();
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("Querying all the managed entities...");
                SessionFactory sessionFactory = session.getSessionFactory();
                Metamodel metamodel = sessionFactory.getMetamodel();
                Set<EntityType<?>> entities = metamodel.getEntities();
                for (EntityType entityType : entities) {
                    final String entityName = entityType.getName();
                    final Query query = session.createQuery("from " + entityName);
                    logger.debug("Executing: " + query.getQueryString());
                    for (Object object : query.list()) {
                        logger.debug("  " + object);
                    }
                }
            }
        } finally {
            closeSession(session);
            shutdown();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }
}