package com.example.ujjawal.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ujjawal.entities.flight;
import com.example.ujjawal.entities.user;

public interface FlightRepository extends JpaRepository<flight, Long> {

	@Query("from flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<flight> findFlights(@Param("departureCity")String from,@Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);
	
	

}
 