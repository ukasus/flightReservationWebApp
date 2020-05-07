package com.example.ujjawal.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ujjawal.entities.flight;
import com.example.ujjawal.repo.FlightRepository;

@Controller
public class flightController {
    @Autowired
    FlightRepository flightRepository;
    
	@RequestMapping("/findFlights")
	public String fingFlights(@RequestParam("from") String from, @RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap modelMap)
	{
		List<flight> flights=flightRepository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights",flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight()
	{
		return "addFlight";
		
	}
	
	

}
