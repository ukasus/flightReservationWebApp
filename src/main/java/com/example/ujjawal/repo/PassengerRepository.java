package com.example.ujjawal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ujjawal.entities.passenger;


public interface PassengerRepository extends JpaRepository<passenger, Long> {

}
