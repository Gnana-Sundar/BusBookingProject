package com.inoxtheater.Service;

import com.inoxtheater.File.CreatePdf;
import com.inoxtheater.Models.AvailableResponse;
import com.inoxtheater.Models.BookingResponse;
import com.inoxtheater.Models.Movies;
import com.inoxtheater.Repository.BookingRepository;
import com.inoxtheater.Repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {
    @Autowired
    MoviesRepository moviesRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CreatePdf createPdf;
    public List<Movies> getMovies() {
        return moviesRepository.findAll();
    }

    public List<AvailableResponse> getAvailableRequest(long movie_id,String date,int qty) {

        List<Movies> movies = moviesRepository.findAll();
        AvailableResponse availableResponse = new AvailableResponse();
        List<AvailableResponse> avlResponse = new ArrayList<AvailableResponse>();

        for (Movies movie : movies) {
            if (movie_id==movie.getMovie_id() && date.equals(movie.getDate())) {
                availableResponse.setMovieId(movie.getMovie_id());
                availableResponse.setMovie_name(movie.getMovie_name());
                availableResponse.setPrice(movie.getPrice());
                availableResponse.setShowTime(movie.getTime());
                availableResponse.setAvailableTickets(movie.getNumberOfSeats());
                if (qty <= movie.getNumberOfSeats()) {
                    availableResponse.setStatus("available");
                } else {
                    availableResponse.setStatus("Number of Available Qty = " + movie.getNumberOfSeats() + ". Please reduce the qty");
                }
                break;
            }
        }
        avlResponse.add(availableResponse);

        return avlResponse;
    }

    public String getBookingRequest(int movie_id,String date,int qty,String show_time) {

        BookingResponse bookingResponse = new BookingResponse();
        Movies movie = moviesRepository.findById(movie_id).orElse(null);
        BookingResponse status = null;

        if (movie == null) {
            return "Invalid Movie Id";
        }

        if (!date.equals(movie.getDate())) {
            return "Invalid Movie Date";
        }

        if (!show_time.equals(movie.getTime())) {
            return "Invalid Movie Time";
        }

        if (qty > movie.getNumberOfSeats()) {
            return "Invalid Qty";
        }
        bookingResponse.setBooking_id(getNextBookingId());
        bookingResponse.setMovie_id(movie.getMovie_id());
        bookingResponse.setDate(movie.getDate());
        bookingResponse.setShowTime(movie.getTime());
        bookingResponse.setQty(qty);
        bookingResponse.setAmount(qty * movie.getPrice());
        status = bookingRepository.save(bookingResponse);

        if (status != null) {
            DecreaseQty(movie_id,date,qty,show_time);
            createPdf.createPdf(getNextBookingId());
            createPdf.createTxtFile(getNextBookingId());
            return "Booking Successfully";
        } else {
            return "Booking Failed";
        }
    }


    public int getNextBookingId() {
        List<BookingResponse> bookingRs = bookingRepository.findAll();

        int maxId = 0;
        for (BookingResponse booking : bookingRs) {
            if (booking.getBooking_id() > maxId) {
                maxId = booking.getBooking_id();
            }
        }
        return maxId + 1;
    }



    public void DecreaseQty(long movie_id,String date,int qty,String show_time) {
		List<Movies> moviesList = moviesRepository.findAll();

		for (Movies movie : moviesList) {
            if (movie_id == movie.getMovie_id() && date.equals(movie.getDate()) && show_time.equals(movie.getTime()) && qty<=movie.getNumberOfSeats()) {
				Movies movies = new Movies();
				movies.setMovie_id(movie.getMovie_id());
				movies.setMovie_name(movie.getMovie_name());
				movies.setDate(movie.getDate());
				movies.setTime(movie.getTime());
				movies.setPrice(movie.getPrice());
				movies.setNumberOfSeats(movie.getNumberOfSeats() - qty);
				moviesRepository.save(movies);
			}
		}
	}
}
