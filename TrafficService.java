package com.acet.smarttraffic.service;
import com.acet.smarttraffic.model.*;
import com.acet.smarttraffic.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class TrafficService {
  private final AmbulanceRepository ambulances; private final TrafficSignalRepository signals;
  public TrafficService(AmbulanceRepository a, TrafficSignalRepository s){ambulances=a;signals=s;}
  public List<Ambulance> allAmbulances(){return ambulances.findAll();}
  public List<TrafficSignal> allSignals(){return signals.findAll();}
  public Ambulance createAmbulance(Ambulance a){
    a.setStatus("WAITING");
    return ambulances.save(a);
  }
  public TrafficSignal updatePriority(Long id, boolean priority){
    TrafficSignal s=signals.findById(id).orElseThrow();
    s.setPriority(priority); s.setState(priority ? "GREEN" : "RED");
    return signals.save(s);
  }
  public Map<String,Object> prioritize(Long ambulanceId){
    Ambulance a=ambulances.findById(ambulanceId).orElseThrow();
    String route=a.getRoute()==null||a.getRoute().isBlank() ? a.getCurrentLocation()+" -> "+a.getDestination() : a.getRoute();
    a.setStatus("PRIORITY_ACTIVE"); ambulances.save(a);
    List<TrafficSignal> all=signals.findAll();
    all.forEach(s -> {
      boolean match=route.toLowerCase().contains(s.getLocation()==null?"":s.getLocation().toLowerCase());
      s.setPriority(match); s.setState(match ? "GREEN" : "RED");
    });
    signals.saveAll(all);
    Map<String,Object> out=new LinkedHashMap<>();
    out.put("ambulance",a); out.put("route",route);
    out.put("prioritySignals",all.stream().filter(TrafficSignal::isPriority).toList());
    out.put("message","Priority route activated successfully");
    return out;
  }
}
