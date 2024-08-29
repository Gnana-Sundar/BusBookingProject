package com.BookingAppDatabase.BookingAppDatabase.Controller;

import java.util.List;

import com.BookingAppDatabase.BookingAppDatabase.Models.*;
import com.BookingAppDatabase.BookingAppDatabase.Service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.BookingAppDatabase.BookingAppDatabase.Service.TheaterService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/theaters")
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	@Autowired
	TicketBookingService ticketBookingService;

	@GetMapping("/getTheaters")
	public String getInsertResponse(Model model) {
		List<Theaters> theatersList = theaterService.getTheater();
		model.addAttribute("theaters", theatersList);
		return "theaters/index";
	}

	@GetMapping("/getMovies/{theat_name}")
	public String getMovies(@PathVariable String theat_name,Model model){
		List<Movies> moviesList =  ticketBookingService.getMovies(theat_name.toLowerCase());
		model.addAttribute("movies", moviesList);
		return "theaters/movies";
	}

	@PostMapping("/getMovies/{theat_name}/booking")
	public String getBookingResponse(@PathVariable String theat_name, @ModelAttribute  BookingRequest bookingRequest,Model model, RedirectAttributes redirectAttributes){
		String status =  ticketBookingService.getBookingResponse(theat_name.toLowerCase(),bookingRequest);
		model.addAttribute("bookingRequest", bookingRequest);

		if (status.equals("Booking Successfully")) {
			redirectAttributes.addFlashAttribute("message", "Booking Successfully...");
			return "redirect:/theaters/getTheaters";
		}

		redirectAttributes.addFlashAttribute("message", status);
		return "redirect:/theaters/getMovies/"+theat_name;
	}















	@PostMapping("/insTheater")
	public String getInsertResponse(@RequestBody Theaters theaters){
		return theaterService.insertTheater(theaters);
	}
	@DeleteMapping("/deleteTheater/{id}")
	public String getDeleteResponse(@PathVariable int id){
		return theaterService.deleteTheater(id);
	}
}
