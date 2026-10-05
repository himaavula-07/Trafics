package com.acet.smarttraffic.repository;
import com.acet.smarttraffic.model.TrafficSignal;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TrafficSignalRepository extends JpaRepository<TrafficSignal,Long> {}
