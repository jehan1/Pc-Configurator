/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan 
 */
@Entity
@Table(name="monitors")
public class Monitors extends Parts{
    @NotNull
    private boolean vga;
    @NotNull
    private boolean hdmi;
    @NotNull
    private boolean dvi;
    @NotNull
    private boolean display;
    @NotNull
    private int hertz;

    public Monitors(){}

    public Monitors(boolean vga, boolean hdmi, boolean dvi, boolean display, int hertz, int id, String name) {
        super(id, name);
        this.vga = vga;
        this.hdmi = hdmi;
        this.dvi = dvi;
        this.display = display;
        this.hertz = hertz;
    }
 
    public boolean isVga() {
        return vga;
    }

    public void setVga(boolean vga) {
        this.vga = vga;
    }

    public boolean isHdmi() {
        return hdmi;
    }

    public void setHdmi(boolean hdmi) {
        this.hdmi = hdmi;
    }

    public boolean isDvi() {
        return dvi;
    }

    public void setDvi(boolean dvi) {
        this.dvi = dvi;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public int getHertz() {
        return hertz;
    }

    public void setHertz(int hertz) {
        this.hertz = hertz;
    }
  
}
