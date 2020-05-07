package com.example.ujjawal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ujjawal.dto.ReservationUpdateRequest;
import com.example.ujjawal.entities.reservation;
import com.example.ujjawal.repo.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	@Autowired
	ReservationRepository reservationRepository;
	
    @RequestMapping("/reservations/{id}")
    public reservation findReservation(@PathVariable("id")Long id)
     {
	    return reservationRepository.findById(id).get();
	  
     }
    @RequestMapping("/reservations")
    public reservation updateReservation(@RequestBody ReservationUpdateRequest request)
    {
    	reservation reservation=reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		
    	return reservationRepository.save(reservation);
    	
    	
    }
}
