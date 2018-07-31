
import model.Address;
import model.RegisteredUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

@ManagedBean
@SessionScoped
public class Controller {
    
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    
    public void register(){
        
        RegisteredUser user = new RegisteredUser();
        
        try {
            String firstName = "Lazar";
            String lastName = "Pejic";
            String userName = "laki95";
            String password = "programer";
            
            String municipality = "Uzice";
            String city = "Uzice";
            String street = "Ratarska 69/39";
            Address address = new Address(municipality, city, street);
            String sDate = "31/12/1998";
            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            String phoneNumber = "065/936-6398";
            String category =  "Student";
            String email = "pejiclazar95@gmail.com";
            
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(userName);
            user.setPassword(password);
            user.setAddress(address);
            user.setDateOfBirdth(date);
            user.setPhoneNumber(phoneNumber);
            user.setCategory(category);
            user.setEmail(email);
            
            

            
        } catch (ParseException ex) {//invalid input
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    

    
}
