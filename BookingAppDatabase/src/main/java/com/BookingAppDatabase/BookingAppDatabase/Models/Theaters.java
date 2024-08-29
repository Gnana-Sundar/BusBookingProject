package com.BookingAppDatabase.BookingAppDatabase.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theaters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theat_id;
	private String theat_name,theat_location;
	
	public Theaters() {
		super();
	}

	public int getTheat_id() {
		return theat_id;
	}

	public void setTheat_id(int theat_id) {
		this.theat_id = theat_id;
	}

	public String getTheat_name() {
		return theat_name;
	}

	public void setTheat_name(String theat_name) {
		this.theat_name = theat_name;
	}

	public String getTheat_location() {
		return theat_location;
	}

	public void setTheat_location(String theat_location) {
		this.theat_location = theat_location;
	}

	@Override
	public String toString() {
		return "Theaters [theat_id=" + theat_id + ", theat_name=" + theat_name + ", theat_location=" + theat_location
				+ "]";
	}

	
}
