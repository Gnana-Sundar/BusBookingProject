package com.BookingAppDatabase.BookingAppDatabase.Models;

import org.springframework.stereotype.Component;

@Component
public class BookingResponse {

	private int booking_id;
	private int theat_id;
	private int movie_id;
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

	public int getTheat_id() {
		return theat_id;
	}

	public void setTheat_id(int theat_id) {
		this.theat_id = theat_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
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
		return "BookingResponse [booking_id=" + booking_id + ", theat_id=" + theat_id + ", movie_id=" + movie_id
				+ ", date=" + date + ", showTime=" + showTime + ", qty=" + qty + ", amount=" + amount + "]";
	}
}
