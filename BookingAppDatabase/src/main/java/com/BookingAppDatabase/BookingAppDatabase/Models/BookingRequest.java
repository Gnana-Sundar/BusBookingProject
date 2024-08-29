package com.BookingAppDatabase.BookingAppDatabase.Models;

import org.springframework.stereotype.Component;

@Component
public class BookingRequest {

	private int movie_id;
	private String showTime;
	private String date;
	private int qty;

	public BookingRequest() {
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

	@Override
	public String toString() {
		return "BookingRequest{" +
				"movie_id=" + movie_id +
				", showTime='" + showTime + '\'' +
				", date='" + date + '\'' +
				", qty=" + qty +
				'}';
	}
}
