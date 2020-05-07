package com.example.ujjawal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ujjawal.entities.reservation;

public interface ReservationRepository extends JpaRepository<reservation, Long> {
	
	

}
