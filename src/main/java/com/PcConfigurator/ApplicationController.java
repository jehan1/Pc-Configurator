/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PcConfigurator;

import com.PcConfigurator.supplierclasses.Processor;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jehan & Chethika
 */
@RestController
public class ApplicationController {
    
    @Autowired
    ProcessorRepo processorRespository;

    @GetMapping(path="/Processor")
    public @ResponseBody Iterable<Processor> index(){
        return processorRespository.findAll();
    }
   
    @PostMapping(path="/Processor/Search")
    public List<Processor> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
            return processorRespository.findByNameContaining(searchTerm);
    }
    

//    @GetMapping("/Processor/{id}")
//    public Processor show(@PathVariable String id){
//        int ProcessorId = Integer.parseInt(id);
//        return processorRespository.getOne(ProcessorId);
//    }
//
//   // @PostMapping("/Processor/search")
//   // public List<Processor> search(@RequestBody Map<String, String> body){
//    //    String searchTerm = body.get("text");
//     //   return processorRespository.findByTitleContainingOrContentContaining
//     //   (searchTerm, searchTerm, searchTerm);
//    //}
//
//    @PostMapping("/Processor")
//    public Processor create(@RequestBody Map<String, String> body){
//        int id = Integer.parseInt(body.get("id"));
//        String name = body.get("name");
//        String content = body.get("content");
//        return processorRespository.save(new Processor());
//    }
//
////    @PutMapping("/Processor/{id}")
////    public Processor update(@PathVariable String id, @RequestBody Map<String, String> body){
////        int ProcessorId = Integer.parseInt(id);
////        Processor pro = processorRespository.findOne(ProcessorId);   
////        String title = body.get("title");
////        String content = body.get("content");
////        return processorRespository.save(pro);
////    }
////
////    @DeleteMapping("Processor/{id}")
////    public boolean delete(@PathVariable String id){
////        int ProcessorId = Integer.parseInt(id);
////        processorRespository.delete(ProcessorId);
////        return true;
////        
////    }
}
