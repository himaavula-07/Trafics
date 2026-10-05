package com.acet.smarttraffic.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Ambulance {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank private String ambulanceId;
  @NotBlank private String currentLocation;
  @NotBlank private String destination;
  private String route;
  private String status = "WAITING";
  public Ambulance() {}
  public Ambulance(String ambulanceId,String currentLocation,String destination,String route,String status){
    this.ambulanceId=ambulanceId; this.currentLocation=currentLocation; this.destination=destination;
    this.route=route; this.status=status;
  }
  public Long getId(){return id;} public String getAmbulanceId(){return ambulanceId;}
  public void setAmbulanceId(String v){ambulanceId=v;} public String getCurrentLocation(){return currentLocation;}
  public void setCurrentLocation(String v){currentLocation=v;} public String getDestination(){return destination;}
  public void setDestination(String v){destination=v;} public String getRoute(){return route;}
  public void setRoute(String v){route=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
