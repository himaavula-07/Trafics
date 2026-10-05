package com.acet.smarttraffic.config;
import com.acet.smarttraffic.model.*;
import com.acet.smarttraffic.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataSeeder {
 @Bean CommandLineRunner seed(AmbulanceRepository a, TrafficSignalRepository s){
  return args -> {
   if(s.count()==0){
    s.save(new TrafficSignal("Signal 1","Main Road","RED",false));
    s.save(new TrafficSignal("Signal 2","Hospital Road","RED",false));
    s.save(new TrafficSignal("Signal 3","Market Road","RED",false));
   }
   if(a.count()==0){
    a.save(new Ambulance("AMB-101","Main Road","City Hospital","Main Road -> Hospital Road","WAITING"));
   }
  };
 }
}
