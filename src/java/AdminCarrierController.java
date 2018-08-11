
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Carrier;
import model.Carrier;
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
@ManagedBean(name="AdminCarrierController")
@SessionScoped
public class AdminCarrierController {
    
    private SessionFactory sessionFactory = new SessionFactory();
    
    private Carrier carrier;
    private List<Carrier> allCarriers;
    
    public AdminCarrierController(){
        this.carrier = new Carrier();
        Session session = sessionFactory.getSession();
        
        String hql = "from Carrier";
        Query query = session.createQuery(hql);
        this.allCarriers = query.list();
        
        session.close();
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public List<Carrier> getAllCarriers() {
        return allCarriers;
    }

    public void setAllCarriers(List<Carrier> allCarriers) {
        this.allCarriers = allCarriers;
    }

    public void edit(Carrier carrier){
        carrier.setEditable(true);
    }
    
    public void cancelEdit(Carrier carrier){
        carrier.setEditable(false);
    }
    
    public void update(Carrier carrier){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.update(carrier);
        session.getTransaction().commit();
        session.close();
        allCarriers.set(allCarriers.indexOf(carrier), carrier);
        carrier.setEditable(false);
    }
    
    public void delete(Carrier carrier){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(carrier);
        session.getTransaction().commit();
        session.close();
        allCarriers.remove(carrier);
    }
    
    public void save(){
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.save(carrier);
        session.getTransaction().commit();
        session.close();
        allCarriers.add(carrier);
    }
   
    
}
