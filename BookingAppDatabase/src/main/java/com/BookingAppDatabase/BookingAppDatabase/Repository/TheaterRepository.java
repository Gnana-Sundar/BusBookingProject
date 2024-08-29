package com.BookingAppDatabase.BookingAppDatabase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookingAppDatabase.BookingAppDatabase.Models.Theaters;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theaters, Integer>{

}
