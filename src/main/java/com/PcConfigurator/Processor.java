/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name="processor")
public class Processor extends Parts  {
   
    private String speed;
    private String socket;
    
    public Processor(){}
    
    public Processor(int id, String name, String speed, String socket ) {
        super(id, name);
        this.setSpeed(speed);
        this.setSocket(socket);
    }
  
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    
    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    //@Override
   /* public String toString() {
        return "Processor{" +
                "id=" + id +
                ", title='" + name + '\'' +
                ", Speed='" + speed + '\'' + ", Socket='" + socket + '\'' +
                '}';
    }*/
}
