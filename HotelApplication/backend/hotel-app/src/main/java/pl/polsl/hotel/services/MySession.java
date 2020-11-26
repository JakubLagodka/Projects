package pl.polsl.hotel.services;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class MySession {
    protected final SessionFactory factory;
    protected final org.hibernate.Session session;

    public MySession() {
        Configuration configuration = new Configuration().configure();

        this.factory = configuration.buildSessionFactory();
        this.session = factory.openSession();
    }
}
