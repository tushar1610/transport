package com.assignment.transport.controller;

import com.assignment.transport.entity.Load;
import com.assignment.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping("/load")
    public String saveLoad(@RequestBody Load payload){
        return transportService.saveLoad(payload);
    }

    @GetMapping("/load")
    public List<Load> getLoadList(@RequestParam String shipperId){
        return transportService.getLoadList(shipperId);
    }

    @GetMapping("/load/{loadId}")
    public Load getLoadByLoadId(@PathVariable Long loadId){
        return transportService.getLoadByLoadId(loadId);
    }

    @PutMapping("/load/{loadId}")
    public Load updateLoadByLoadId(@PathVariable Long loadId, @RequestBody Load payload){
        return transportService.updateLoadByLoadId(loadId, payload);
    }

    @DeleteMapping("/load/{loadId}")
    public void deleteLoadByLoadId(@PathVariable Long loadId){
        transportService.deleteLoadByLoadId(loadId);
    }

}
