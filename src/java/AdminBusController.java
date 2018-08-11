
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Bus;
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
@ManagedBean(name="AdminBusController")
@SessionScoped
public class AdminBusController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private Bus bus;
    private List<Bus> allBusses;
    
    public AdminBusController(){
        this.bus = new Bus();
        Session session = sessionFactory.getSession();
        
        String hql = "from Bus";
        Query query = session.createQuery(hql);
        this.allBusses = query.list();
        
        session.close();
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public List<Bus> getAllBusses() {
        return allBusses;
    }

    public void setAllBusses(List<Bus> allBusses) {
        this.allBusses = allBusses;
    }

    public void edit(Bus bus){
        bus.setEditable(true);
    }
    
    public void cancelEdit(Bus bus){
        bus.setEditable(false);
    }
    
    public void update(Bus bus){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(bus);
        session.getTransaction().commit();
        session.close();
        allBusses.set(allBusses.indexOf(bus), bus);
        bus.setEditable(false);
    }
    
    public void delete(Bus bus){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(bus);
        session.getTransaction().commit();
        session.close();
        allBusses.remove(bus);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(bus);
        session.getTransaction().commit();
        session.close();
        allBusses.add(bus);
    }
    
    
}
