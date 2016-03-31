package com.samodeika.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        PersonDAOImpl dao = new PersonDAOImpl();

        Session session = dao.getSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            System.out.println("Started transaction!");
            tx = session.beginTransaction();
            Integer empID1 = dao.addPerson(session, "Yavor Nikolov", 36);
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
