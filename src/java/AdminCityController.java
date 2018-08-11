
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
 */
@ManagedBean(name="AdminCityController")
@SessionScoped
public class AdminCityController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private City city;
    private List<City> allCities;
    
    public AdminCityController(){
        this.city = new City();
        Session session = sessionFactory.getSession();
        
        String hql = "from City";
        Query query = session.createQuery(hql);
        this.allCities = query.list();
        
        session.close();
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public List<City> getAllCities() {
        return allCities;
    }

    public void setAllCities(List<City> allCities) {
        this.allCities = allCities;
    }
    
    public void edit(City city){
        city.setEditable(true);
    }
    
    public void cancelEdit(City city){
        city.setEditable(false);
    }
    
    public void update(City city){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(city);
        session.getTransaction().commit();
        session.close();
        allCities.set(allCities.indexOf(city), city);
        city.setEditable(false);
    }
    
    public void delete(City city){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(city);
        session.getTransaction().commit();
        session.close();
        allCities.remove(city);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        allCities.add(city);
    }
    
}
