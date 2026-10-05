package com.acet.smarttraffic.controller;
import com.acet.smarttraffic.model.*;
import com.acet.smarttraffic.service.TrafficService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:5173")
public class TrafficController {
  private final TrafficService service;
  public TrafficController(TrafficService service){this.service=service;}
  @GetMapping("/ambulances") public List<Ambulance> ambulances(){return service.allAmbulances();}
  @PostMapping("/ambulances") public Ambulance create(@Valid @RequestBody Ambulance a){return service.createAmbulance(a);}
  @GetMapping("/signals") public List<TrafficSignal> signals(){return service.allSignals();}
  @PutMapping("/signals/{id}/priority")
  public TrafficSignal priority(@PathVariable Long id,@RequestParam boolean enabled){return service.updatePriority(id,enabled);}
  @PostMapping("/ambulances/{id}/prioritize") public Map<String,Object> prioritize(@PathVariable Long id){return service.prioritize(id);}
}
