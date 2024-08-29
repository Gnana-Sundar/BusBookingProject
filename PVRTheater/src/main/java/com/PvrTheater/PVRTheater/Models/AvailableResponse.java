package com.PvrTheater.PVRTheater.Models;

import org.springframework.stereotype.Component;

@Component
public class AvailableResponse {

    private long movieId;
    private String movie_name;
    private String showTime;
    private double price;
    private int availableTickets;
    private String status;

    public AvailableResponse() {
        super();
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AvailableResponse [movieId=" + movieId + ", movie_name=" + movie_name + ", showTime=" + showTime
                + ", price=" + price + ", availableTickets=" + availableTickets + ", status=" + status + "]";
    }

}
