/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jehan & Chethika
 */
@RestController
public class ApplicationController {
    
    ProcessorMock processorMock = ProcessorMock.getInstance();

    @GetMapping("/Processor")
    public List<Processor> index(){
        return processorMock.fetchProcessors();
    }

    @GetMapping("/Processor/{id}")
    public Processor show(@PathVariable String id){
        int ProcessorId = Integer.parseInt(id);
        return processorMock.getProcessorById(ProcessorId);
    }

    @PostMapping("/Processor/search")
    public List<Processor> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return processorMock.searchProcessors(searchTerm);
    }

    @PostMapping("/Processor")
    public Processor create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return processorMock.createProcessor(id, title, content);
    }

    @PutMapping("/Processor/{id}")
    public Processor update(@PathVariable String id, @RequestBody Map<String, String> body){
        int ProcessorId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return processorMock.updateProcessor(ProcessorId, title, content);
    }

    @DeleteMapping("Processor/{id}")
    public boolean delete(@PathVariable String id){
        int ProcessorId = Integer.parseInt(id);
        return processorMock.delete(ProcessorId);
    }
}
