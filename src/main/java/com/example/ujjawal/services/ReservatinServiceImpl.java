package com.example.ujjawal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ujjawal.dto.ReservationRequest;
import com.example.ujjawal.entities.flight;
import com.example.ujjawal.entities.passenger;
import com.example.ujjawal.entities.reservation;
import com.example.ujjawal.repo.FlightRepository;
import com.example.ujjawal.repo.PassengerRepository;
import com.example.ujjawal.repo.ReservationRepository;
import com.example.ujjawal.util.PDFGenerator;
@Component
public class ReservatinServiceImpl implements ReservationService {
    @Autowired
    FlightRepository flightRepository;
    
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    PDFGenerator pdfGenerator;
    
    @Autowired
    ReservationRepository reservationRepository;
    
	@Override
	public reservation bookFlight(ReservationRequest request) {
		
		Long flightId=request.getFlightId();
        Optional<flight> Flight=flightRepository.findById(flightId);
        flight flight=Flight.get();
        
        passenger passenger=new passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        
        passenger savedPassenger=passengerRepository.save(passenger);
        
        reservation reservation=new reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        
        reservation savedReservation=reservationRepository.save(reservation);
		
        pdfGenerator.generateItinerary(savedReservation, "C:\\Users\\ujjaw\\desktop\\reservation"+savedReservation.getPassenger().getEmail()+".pdf");        
        return savedReservation;
	}

}
