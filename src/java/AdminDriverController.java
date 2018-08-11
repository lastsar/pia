
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Driver;
import model.Driver;
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
@ManagedBean(name="AdminDriverController")
@SessionScoped
public class AdminDriverController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private Driver driver;
    private List<Driver> allDrivers;
    
    public AdminDriverController(){
        this.driver = new Driver();
        
        Session session = sessionFactory.getSession();
        
        String hql = "from Driver";
        Query query = session.createQuery(hql);
        this.allDrivers = query.list();
        
        session.close();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Driver> getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(List<Driver> allDrivers) {
        this.allDrivers = allDrivers;
    }

    public void edit(Driver driver){
        driver.setEditable(true);
    }
    
    public void cancelEdit(Driver driver){
        driver.setEditable(false);
    }
    
    public void update(Driver driver){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(driver);
        session.getTransaction().commit();
        session.close();
        allDrivers.set(allDrivers.indexOf(driver), driver);
        driver.setEditable(false);
    }
    
    public void delete(Driver driver){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(driver);
        session.getTransaction().commit();
        session.close();
        allDrivers.remove(driver);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(driver);
        session.getTransaction().commit();
        session.close();
        allDrivers.add(driver);
    }
    
}
