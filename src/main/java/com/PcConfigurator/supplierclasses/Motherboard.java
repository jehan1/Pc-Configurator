/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jehan
 */
@Entity
@Table(name ="motherboard")
public class Motherboard extends Parts {
    
   @NotNull
   @Column(name ="max_memory")
   private int maxMemory;
   
   @NotNull
   @Column(name ="no_of_memory_slots")
   private int noMemoryPorts;
   
   @NotNull
   @Column(name ="expansion_slots")
   private int noExpansionSlots;
   
   @NotNull
   @Column(name ="onboard_graphics")
   private boolean onBoardGraphics;
   
   @ManyToOne
   @JoinColumn(name = "molex_connector")
   private MolexConnectors molexConnectors;
   
   @NotNull
   @Column(name ="no_sata_ports")
   private int noSataPorts;
   
   @NotNull
   @Column(name ="no_usb_headers")
   private int noUsbHeaders;
   
   @ManyToOne
   @JoinColumn(name = "processor_socket_id")
   private ProcessorSocket processorSocket;
   
   @ManyToOne
   @JoinColumn(name = "case_size_id")
   private CaseSize caseSize;
   
   @ManyToOne
   @JoinColumn(name = "memory_type_id")
   private MemoryType memoryType;

    public Motherboard(int maxMemory, int noMemoryPorts, int noExpansionSlots, 
            boolean onBoardGraphics, MolexConnectors molexConnectors, 
            int noSataPorts, int noUsbHeaders, ProcessorSocket processorSocket,
            CaseSize caseSize, MemoryType memoryType) {
        this.maxMemory = maxMemory;
        this.noMemoryPorts = noMemoryPorts;
        this.noExpansionSlots = noExpansionSlots;
        this.onBoardGraphics = onBoardGraphics;
        this.molexConnectors = molexConnectors;
        this.noSataPorts = noSataPorts;
        this.noUsbHeaders = noUsbHeaders;
        this.processorSocket = processorSocket;
        this.caseSize = caseSize;
        this.memoryType = memoryType;
    }

    public Motherboard() {}

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getNoMemoryPorts() {
        return noMemoryPorts;
    }

    public void setNoMemoryPorts(int noMemoryPorts) {
        this.noMemoryPorts = noMemoryPorts;
    }

    public int getNoExpansionSlots() {
        return noExpansionSlots;
    }

    public void setNoExpansionSlots(int noExpansionSlots) {
        this.noExpansionSlots = noExpansionSlots;
    }

    public boolean isOnBoardGraphics() {
        return onBoardGraphics;
    }

    public void setOnBoardGraphics(boolean onBoardGraphics) {
        this.onBoardGraphics = onBoardGraphics;
    }

    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }

    public int getNoSataPorts() {
        return noSataPorts;
    }

    public void setNoSataPorts(int noSataPorts) {
        this.noSataPorts = noSataPorts;
    }

    public int getNoUsbHeaders() {
        return noUsbHeaders;
    }

    public void setNoUsbHeaders(int noUsbHeaders) {
        this.noUsbHeaders = noUsbHeaders;
    }

    public ProcessorSocket getProcessorSocket() {
        return processorSocket;
    }

    public void setProcessorSocket(ProcessorSocket processorSocket) {
        this.processorSocket = processorSocket;
    }

    public CaseSize getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(CaseSize caseSize) {
        this.caseSize = caseSize;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }
   
    @JsonManagedReference
    @OneToMany(
        mappedBy = "motherboard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<MotherboardVideoPorts> videoPorts;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "motherboard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<MotherboardPciLanes> pciLanes;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "motherboard",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<MotherboardPortM> portM;

    public List<MotherboardPortM> getPortM() {
        return portM;
    }

    public void setPortM(List<MotherboardPortM> portM) {
        this.portM = portM;
    }
 
    public List<MotherboardPciLanes> getPciLanes() {
        return pciLanes;
    }

    public void setPciLanes(List<MotherboardPciLanes> pciLanes) {
        this.pciLanes = pciLanes;
    }
    
    public List<MotherboardVideoPorts> getVideoPorts() {
        return videoPorts;
    }

    public void setVideoPorts(List<MotherboardVideoPorts> videoPorts) {
        this.videoPorts = videoPorts;
    }

}
