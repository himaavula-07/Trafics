package com.acet.smarttraffic.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class TrafficSignal {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotBlank private String signalName;
  private String location;
  private String state = "RED";
  private boolean priority;
  public TrafficSignal(){}
  public TrafficSignal(String signalName,String location,String state,boolean priority){
    this.signalName=signalName;this.location=location;this.state=state;this.priority=priority;
  }
  public Long getId(){return id;} public String getSignalName(){return signalName;}
  public void setSignalName(String v){signalName=v;} public String getLocation(){return location;}
  public void setLocation(String v){location=v;} public String getState(){return state;}
  public void setState(String v){state=v;} public boolean isPriority(){return priority;}
  public void setPriority(boolean v){priority=v;}
}
