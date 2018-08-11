
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */
public class SessionFactory {
    private static final org.hibernate.SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    
    public Session getSession(){
        Session session = SESSION_FACTORY.openSession();
        return session;
    }
}
