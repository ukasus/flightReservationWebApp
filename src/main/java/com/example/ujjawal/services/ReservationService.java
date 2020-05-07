package com.example.ujjawal.services;

import org.springframework.stereotype.Component;

import com.example.ujjawal.dto.ReservationRequest;
import com.example.ujjawal.entities.reservation;
@Component
public interface ReservationService {
	public reservation bookFlight(ReservationRequest request );

}
