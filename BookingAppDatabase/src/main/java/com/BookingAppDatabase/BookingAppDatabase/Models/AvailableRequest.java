package com.BookingAppDatabase.BookingAppDatabase.Models;

import org.springframework.stereotype.Component;

@Component
public class AvailableRequest {
	private int movie_id;
	private String date;
	private int qty;

	public AvailableRequest() {
		super();
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "AvailableRequest{" +
				"movie_id=" + movie_id +
				", date='" + date + '\'' +
				", qty=" + qty +
				'}';
	}
}
