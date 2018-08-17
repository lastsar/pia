
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
    
    private RegisteredUser editRegisteredUser;
    private RegisteredUser newRegisteredUser;
    private List<RegisteredUser> allRegisteredUsers;
    
    private Service<RegisteredUser> service;
    
    
    public RegisteredUserService(){    
        this.service = new Service();
        this.editRegisteredUser = new RegisteredUser();
        this.newRegisteredUser = new RegisteredUser();
        this.allRegisteredUsers = service.getAll("from RegisteredUser");
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
    
    public List<RegisteredUser> getByExample(RegisteredUser registeredUser){
        List<RegisteredUser> registeredUsers = this.service.getByExample(registeredUser);
        return registeredUsers;
    }
    
}
