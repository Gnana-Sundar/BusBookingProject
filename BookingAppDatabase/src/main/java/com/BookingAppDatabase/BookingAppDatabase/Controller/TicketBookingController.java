package com.BookingAppDatabase.BookingAppDatabase.Controller;

import java.util.List;

import com.BookingAppDatabase.BookingAppDatabase.Models.*;
import com.BookingAppDatabase.BookingAppDatabase.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BookingAppDatabase.BookingAppDatabase.Service.TicketBookingService;

@RestController
public class TicketBookingController {
	@Autowired
    TheaterService theaterService;
    @Autowired
    TicketBookingService ticketBookingService;

    @GetMapping("/BookMyShow")
    public List<Theaters> getResponse(){
        return theaterService.getTheater();
    }

    @GetMapping("/BookMyShow/{theat_name}")
    public List<Movies> getResponse(@PathVariable String theat_name){
        return ticketBookingService.getMovies(theat_name);
    }

    @PostMapping("/BookMyShow/{theat_name}")
    public List<AvailableResponse> getMovieResponse(@PathVariable String theat_name, @RequestBody AvailableRequest availableRequest){
        return ticketBookingService.getAvailableResponse(theat_name,availableRequest);
    }

    @PostMapping("/BookMyShow/{theat_name}/booking")
    public String getBookingResponse(@PathVariable String theat_name, @RequestBody BookingRequest bookingRequest){
        return ticketBookingService.getBookingResponse(theat_name,bookingRequest);
    }

}
