/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Lazar
 */

public class Driver implements Serializable {
    
    private String firstName;
    private String lastName;
    private Date dateOfBirdth;
    private Date driverLicenseIssueDate;
    private List<Line> lines;

    public Driver(String firstName, String lastName, Date dateOfBirdth, Date driverLicenseIssueDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirdth = dateOfBirdth;
        this.driverLicenseIssueDate = driverLicenseIssueDate;
        this.lines = new ArrayList<>();
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

    public Date getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    public void setDriverLicenseIssueDate(Date driverLicenseIssueDate) {
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
    
    

}
