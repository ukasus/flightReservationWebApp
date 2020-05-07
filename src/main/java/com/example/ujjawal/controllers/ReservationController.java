package com.example.ujjawal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ujjawal.dto.ReservationRequest;
import com.example.ujjawal.entities.flight;
import com.example.ujjawal.entities.reservation;
import com.example.ujjawal.repo.FlightRepository;
import com.example.ujjawal.services.ReservationService;

@Controller
public class ReservationController {
	@Autowired
    FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap)
	{
		 Optional<flight> Flight=flightRepository.findById(flightId);
		 flight flight=Flight.get();
		 
		modelMap.addAttribute("flight",flight);
		
		return "completeReservation";
		
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap)
	{
		reservation reservation=reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation created successfully and the id is"+reservation.getId());
		return "reservationConfirmation";
		
	}
	

}
