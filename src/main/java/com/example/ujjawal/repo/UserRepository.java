package com.example.ujjawal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ujjawal.entities.user;

public interface UserRepository extends JpaRepository<user, Long> {

	user findByEmail(String email);

}
