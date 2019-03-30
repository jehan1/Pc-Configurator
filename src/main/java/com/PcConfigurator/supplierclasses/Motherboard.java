/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator.supplierclasses;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * This is the Entity class for the Motherboard table
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
    
   /**
    * Initialise the motherboard object
    * @param maxMemory maximum memory capacity of the motherboard
    * @param noMemoryPorts number of memory lanes
    * @param noExpansionSlots number of PCIE expansion slots
    * @param onBoardGraphics if the motherboard contains on board graphics
    * @param molexConnectors no of molex connectors the mother board need
    * @param noSataPorts number of SATA ports available 
    * @param noUsbHeaders Number of USB headers available
    * @param processorSocket processor socket of the motherboard
    * @param caseSize mother board size
    * @param memoryType memory type of the motherboard
    */
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

    /**
     * empty constructor for the persistence model
     */
    public Motherboard() {}

    /**
     * 
     * @return the maximum memory supported by the motherboard
     */
    public int getMaxMemory() {
        return maxMemory;
    }

    /**
     * Set the maximum memory
     * @param maxMemory the maximum memory supported by the motherboard
     */
    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    /**
     * 
     * @return the number of memory ports
     */
    public int getNoMemoryPorts() {
        return noMemoryPorts;
    }

    /**
     * Sets the number of memory ports
     * @param noMemoryPorts 
     */
    public void setNoMemoryPorts(int noMemoryPorts) {
        this.noMemoryPorts = noMemoryPorts;
    }

    /**
     * 
     * @return the number of PCI lanes available
     */
    public int getNoExpansionSlots() {
        return noExpansionSlots;
    }

    /**
     * Sets the number of expansion slots
     * @param noExpansionSlots 
     */
    public void setNoExpansionSlots(int noExpansionSlots) {
        this.noExpansionSlots = noExpansionSlots;
    }

    /**
     * 
     * @return if the motherboard contains on board graphics
     */
    public boolean isOnBoardGraphics() {
        return onBoardGraphics;
    }

    /**
     * set if the motherboards has on board graphics
     * @param onBoardGraphics 
     */
    public void setOnBoardGraphics(boolean onBoardGraphics) {
        this.onBoardGraphics = onBoardGraphics;
    }

    /**
     * 
     * @return the no of molex connectors
     */
    public MolexConnectors getMolexConnectors() {
        return molexConnectors;
    }

    /**
     * Sets the number of molex connectors
     * @param molexConnectors 
     */
    public void setMolexConnectors(MolexConnectors molexConnectors) {
        this.molexConnectors = molexConnectors;
    }

    /**
     * 
     * @return no of SATA ports available
     */
    public int getNoSataPorts() {
        return noSataPorts;
    }

    /**
     * Sets the number of SATA ports
     * @param noSataPorts 
     */
    public void setNoSataPorts(int noSataPorts) {
        this.noSataPorts = noSataPorts;
    }

    /**
     * 
     * @return No of USB headers of the 
     */
    public int getNoUsbHeaders() {
        return noUsbHeaders;
    }

    /**
     * Sets the number of USB headers
     * @param noUsbHeaders 
     */
    public void setNoUsbHeaders(int noUsbHeaders) {
        this.noUsbHeaders = noUsbHeaders;
    }

    /**
     * 
     * @return The processor socket of the motherboard
     */
    public ProcessorSocket getProcessorSocket() {
        return processorSocket;
    }

    /**
     * Sets the processor socket
     * @param processorSocket 
     */
    public void setProcessorSocket(ProcessorSocket processorSocket) {
        this.processorSocket = processorSocket;
    }

    /**
     * 
     * @return The motherboard size
     */
    public CaseSize getCaseSize() {
        return caseSize;
    }

    /**
     * Sets the motherboard size
     * @param caseSize 
     */
    public void setCaseSize(CaseSize caseSize) {
        this.caseSize = caseSize;
    }

    /**
     * 
     * @return the memory type
     */
    public MemoryType getMemoryType() {
        return memoryType;
    }

    /**
     * Sets the memory type
     * @param memoryType 
     */
    public void setMemoryType(MemoryType memoryType) {
        this.memoryType = memoryType;
    }

    /**
     * 
     * @return List of M.2 Ports
     */
    public List<MotherboardPortM> getPortM() {
        return portM;
    }

    /**
     * Sets the list of M.2 Ports
     * @param portM 
     */
    public void setPortM(List<MotherboardPortM> portM) {
        this.portM = portM;
    }

    /**
     * 
     * @return LIst of PCI Lanes of the motherboard
     */
    public List<MotherboardPciLanes> getPciLanes() {
        return pciLanes;
    }

    /**
     * Sets the list of PCI lanes of the motherboard
     * @param pciLanes 
     */
    public void setPciLanes(List<MotherboardPciLanes> pciLanes) {
        this.pciLanes = pciLanes;
    }

    /**
     * 
     * @return List of on board video ports
     */
    public List<MotherboardVideoPorts> getVideoPorts() {
        return videoPorts;
    }

    /**
     * Sets the list of video ports
     * @param videoPorts 
     */
    public void setVideoPorts(List<MotherboardVideoPorts> videoPorts) {
        this.videoPorts = videoPorts;
    }

}
