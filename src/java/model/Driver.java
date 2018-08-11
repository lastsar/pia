/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
public class Driver implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String firstName;
    private String lastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirdth;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date driverLicenseIssueYear;
    private transient Boolean editable;

    public Driver() {
        this.editable = false;
    }

    public Driver(String firstName, String lastName, Date dateOfBirdth, Date driverLicenseIssueYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirdth = dateOfBirdth;
        this.driverLicenseIssueYear = driverLicenseIssueYear;
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

    public Date getDateOfBirdth() {
        return dateOfBirdth;
    }

    public void setDateOfBirdth(Date dateOfBirdth) {
        this.dateOfBirdth = dateOfBirdth;
    }

    public Date getDriverLicenseIssueYear() {
        return driverLicenseIssueYear;
    }

    public void setDriverLicenseIssueYear(Date driverLicenseIssueYear) {
        this.driverLicenseIssueYear = driverLicenseIssueYear;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
    
}
