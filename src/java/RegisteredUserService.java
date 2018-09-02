
import java.util.ArrayList;
import java.util.List;
import model.RegisteredUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lazar
 */

public class RegisteredUserService {
    
    private RegisteredUser exampleRegisteredUser;
    private RegisteredUser editRegisteredUser;
    private RegisteredUser newRegisteredUser;
    private List<RegisteredUser> registeredUsers;
    private List<RegisteredUser> allRegisteredUsers;
    
    private Service<RegisteredUser> service;
    
    
    public RegisteredUserService(){    
        this.service = new Service();
        
        this.exampleRegisteredUser = new RegisteredUser();
        this.editRegisteredUser = new RegisteredUser();
        this.newRegisteredUser = new RegisteredUser();
        this.registeredUsers = new ArrayList<>();
        this.allRegisteredUsers = service.getAll("from RegisteredUser");
    }

    public RegisteredUser getExampleRegisteredUser() {
        return exampleRegisteredUser;
    }

    public void setExampleRegisteredUser(RegisteredUser exampleRegisteredUser) {
        this.exampleRegisteredUser = exampleRegisteredUser;
    }

    public List<RegisteredUser> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<RegisteredUser> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public RegisteredUser getEditRegisteredUser() {
        return editRegisteredUser;
    }

    public void setEditRegisteredUser(RegisteredUser editRegisteredUser) {
        this.editRegisteredUser = editRegisteredUser;
    }

    public RegisteredUser getNewRegisteredUser() {
        return newRegisteredUser;
    }

    public void setNewRegisteredUser(RegisteredUser newRegisteredUser) {
        this.newRegisteredUser = newRegisteredUser;
    }

    public List<RegisteredUser> getAllRegisteredUsers() {
        return allRegisteredUsers;
    }

    public void setAllRegisteredUsers(List<RegisteredUser> allRegisteredUsers) {
        this.allRegisteredUsers = allRegisteredUsers;
    }
    
    public void edit(RegisteredUser registeredUser){
        this.editRegisteredUser.setEditable(false);
        this.editRegisteredUser = registeredUser;
        this.editRegisteredUser.setEditable(true);
    }
    
    public void update(){
        this.service.update(this.editRegisteredUser);
        this.editRegisteredUser.setEditable(false);
        this.editRegisteredUser = new RegisteredUser();
    }

    public void delete(RegisteredUser registeredUser){
        this.service.delete(registeredUser, this.allRegisteredUsers);
    }
    
    public void save(){
        this.service.save(this.newRegisteredUser, this.allRegisteredUsers);
        this.newRegisteredUser = new RegisteredUser();
    }
    
    public void setByExample(){
        this.registeredUsers = this.service.getByExample(this.exampleRegisteredUser);
    }
    
    public RegisteredUser find(String username){
        for(RegisteredUser user:allRegisteredUsers){
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }
    
    public RegisteredUser find(String username, String password){
        for(RegisteredUser user:allRegisteredUsers){
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    
}
