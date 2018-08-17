/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lazar
 */
@Entity
public class Reservation implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch=FetchType.EAGER)
    private RegisteredUser user;
    @ManyToOne(fetch=FetchType.EAGER)
    private IntercityLine line;
    private Boolean approved;
    
    private transient Boolean editable;
    

    public Reservation() {
        this.user = new RegisteredUser();
        this.line = new IntercityLine();
        this.approved = false;
        this.editable = false;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public IntercityLine getLine() {
        return line;
    }

    public void setLine(IntercityLine line) {
        this.line = line;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
    
    
}
