package com.example.ujjawal.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.example.ujjawal.abstractentities.abstractItems;

@Entity
public class reservation extends abstractItems {
	private long id;
	private boolean checkedIn;
	private int numberOfBags;
	@OneToOne
	private passenger passenger;
	@OneToOne
	private flight flight;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(passenger passenger) {
		this.passenger = passenger;
	}
	public flight getFlight() {
		return flight;
	}
	public void setFlight(flight flight) {
		this.flight = flight;
	}
	
	
	
	

}
