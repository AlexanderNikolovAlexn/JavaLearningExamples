package com.samodeika.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory;

        try {
            factory = new Configuration().configure().addAnnotatedClass(Person.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        PersonDAO dao = new PersonDAO();

        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            System.out.println("Started transaction!");
            tx = session.beginTransaction();
            Integer empID1 = dao.addPerson(session, "Alex Nikolov", 28);
            tx.commit();
            System.out.println("Committed! Received id: " + empID1);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
