package com.PvrTheater.PVRTheater.Models;

import jakarta.persistence.*;
@Entity
@Table(name = "booking")
public class BookingResponse {
	@Id
	private int booking_id;
	private long movie_id;
	private String date;
	private String showTime;
	private int qty;
	private double amount;
	
	public BookingResponse() {
		super();
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(long movie_id) {
		this.movie_id = movie_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BookingResponse{" +
				"booking_id=" + booking_id +
				", movie_id=" + movie_id +
				", date='" + date + '\'' +
				", showTime='" + showTime + '\'' +
				", qty=" + qty +
				", amount=" + amount +
				'}';
	}
}
