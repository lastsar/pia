
import model.Address;
import model.RegisteredUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;
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

@ManagedBean(name="UserController")
@SessionScoped
public class UserController {
    
    private RegisteredUser user;
    
    
    public UserController(){
        user = new RegisteredUser();
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }
    
    public String login(){
        
        //if user is registered put user data in global scope and redirect him to RegisteredUser.xhtml
        return "RegisteredUser";
        //othervise redirect him to Register.xhtml
        
    }
    
    public String register(){
        //if dont have an account register user and redirect him to login page
        //if have account redirect him to login page
        return "RegisteredUser";
    }
    
    
}
