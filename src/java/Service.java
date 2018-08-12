
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.City;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 * @param <T>
 */

public class Service<T> {
    
    private final SessionFactory sessionFactory = new SessionFactory();
    
    
    public List<T> getAll(String hql){
        Session session = sessionFactory.getSession();
        Query query = session.createQuery(hql);
        List<T> entities = query.list();
        session.close();
        return entities;
    }
    
    public void update(T entity, List<T> entities){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        entities.set(entities.indexOf(entity), entity);
    }
    
    public void delete(T entity, List<T> entities){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
        entities.remove(entity);
    }
    
    public void save(T entity, List<T> entities){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        entities.add(entity);
    }
    
}