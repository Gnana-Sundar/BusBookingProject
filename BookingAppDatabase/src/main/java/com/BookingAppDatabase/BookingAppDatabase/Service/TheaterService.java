package com.BookingAppDatabase.BookingAppDatabase.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BookingAppDatabase.BookingAppDatabase.Models.Theaters;
import com.BookingAppDatabase.BookingAppDatabase.Repository.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	TheaterRepository theaterRepository;

	public List<Theaters> getTheater() {
		return theaterRepository.findAll();
	}

	public String insertTheater(Theaters theater) {
		Theaters theaters = new Theaters();
		theaters.setTheat_id(theater.getTheat_id());
		theaters.setTheat_name(theater.getTheat_name());
		theaters.setTheat_location(theater.getTheat_location());
		Theaters status = theaterRepository.save(theater);

		if (status != null) {
			return "Insert Successfully";
		} else {
			return "Insert Failed";
		}
	}

	public String deleteTheater(int id) {
		Optional<Theaters> theater = theaterRepository.findById(id);
		if (theater.isPresent()) {
			theaterRepository.deleteById(id);
			return "Delete Successfully";
		} else {
			return "Theater not found";
		}
	}

}
