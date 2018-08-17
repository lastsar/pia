
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.City;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

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
    
    public void update(T entity){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
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
    
    public List<T> getByExample(T entity){
        Session session = sessionFactory.getSession();
        Example example = Example.create(entity);
        Criteria criteria = session.createCriteria(entity.getClass()).add(example);
        List<T> entities = (List<T>) criteria.list();
        session.close();
        
        return entities;
    }
    
}
