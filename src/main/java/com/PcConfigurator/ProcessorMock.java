/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jehan & Chethika
 */
public class ProcessorMock {

    private List<Processor> Processors;

    private static ProcessorMock instance = null;

    public static ProcessorMock getInstance() {
        if (instance == null) {
            instance = new ProcessorMock();
        }
        return instance;
    }

    public ProcessorMock() {
        Processors = new ArrayList<Processor>();
        Processors.add(new Processor(1, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, "
                + "you may be already thinking about getaways for next year. Consider "
                + "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport"));
        Processors.add(new Processor(2, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or "
                + "a local business—your Google Assistant should be able to help. And starting "
                + "today, it’s getting better at helping you, if you’re looking for nearby services "
                + "like an electrician, plumber, house cleaner and more"));
        Processors.add(new Processor(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices "
                + "that use technology like the Google Assistant. And with the availability of maker-friendly "
                + "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action "
                + "and adding voice to their Internet of Things (IoT) projects."));
        Processors.add(new Processor(4, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as "
                + "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful "
                + "sidekick to tell you more about what’s around you, right on your Pixel."));
        Processors.add(new Processor(5, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. "
                + "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant."));
    }

    // return all Processors
    public List<Processor> fetchProcessors() {
        return Processors;
    }

    // return Processor by id
    public Processor getProcessorById(int id) {
        for (Processor b : Processors) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search Processor by text
    public List<Processor> searchProcessors(String searchTerm) {
        List<Processor> searchedProcessors = new ArrayList<Processor>();
        for (Processor b : Processors) {
            if (b.getTitle().toLowerCase().contains(searchTerm.toLowerCase())
                    || b.getContent().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedProcessors.add(b);
            }
        }

        return searchedProcessors;
    }

    // create Processor
    public Processor createProcessor(int id, String title, String content) {
        Processor newProcessor = new Processor(id, title, content);
        Processors.add(newProcessor);
        return newProcessor;
    }

    // update Processor
    public Processor updateProcessor(int id, String title, String content) {
        for (Processor b : Processors) {
            if (b.getId() == id) {
                int ProcessorIndex = Processors.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                Processors.set(ProcessorIndex, b);
                return b;
            }

        }

        return null;
    }

    // delete Processor by id
    public boolean delete(int id) {
        int ProcessorIndex = -1;
        for (Processor b : Processors) {
            if (b.getId() == id) {
                ProcessorIndex = Processors.indexOf(b);
                continue;
            }
        }
        if (ProcessorIndex > -1) {
            Processors.remove(ProcessorIndex);
        }
        return true;
    }
}
