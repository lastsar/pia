/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Lazar
 */

@Entity
public class RegisteredUser implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @Embedded
    private Address address;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirdth;
    private String phoneNumber;
    private String category;
    private String email;

    public RegisteredUser() {
    }

    public RegisteredUser(String firstName, String lastName, String userName, String password, Address address, Date dateOfBirdth, String phoneNumber, String category, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.dateOfBirdth = dateOfBirdth;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirdth() {
        return dateOfBirdth;
    }

    public void setDateOfBirdth(Date dateOfBirdth) {
        this.dateOfBirdth = dateOfBirdth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
