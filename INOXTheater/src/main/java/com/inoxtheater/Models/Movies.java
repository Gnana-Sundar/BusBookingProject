package com.inoxtheater.Models;

import jakarta.persistence.*;

@Entity
@Table
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;
    private String date;
    private String movie_name;
    private String time;
    private double price;
    private int numberOfSeats;

    public Movies() {
        super();
    }

    public Movies(long movie_id, String date, String movie_name, String time, double price, int numberOfSeats) {
        this.movie_id = movie_id;
        this.date = date;
        this.movie_name = movie_name;
        this.time = time;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
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

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_id=" + movie_id +
                ", date='" + date + '\'' +
                ", movie_name='" + movie_name + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
