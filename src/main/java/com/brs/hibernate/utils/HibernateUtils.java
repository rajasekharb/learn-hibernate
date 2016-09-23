package com.brs.hibernate.utils;

import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.metamodel.EntityType;
import java.util.Set;

/**
 * @author Rajasekhar
 */
public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY;
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

    public static Session getOpenSession() {
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

    public static void main(final String[] args) {
        final Session session = getOpenSession();
        try {
            System.out.println("Querying all the managed entities...");
            SessionFactory sessionFactory = session.getSessionFactory();
            Metamodel metamodel = sessionFactory.getMetamodel();
            Set<EntityType<?>> entities = metamodel.getEntities();
            for (EntityType entityType : entities) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("Executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }
}