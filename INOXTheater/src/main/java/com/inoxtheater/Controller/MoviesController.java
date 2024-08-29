package com.inoxtheater.Controller;

import com.inoxtheater.Models.AvailableResponse;
import com.inoxtheater.Models.Movies;
import com.inoxtheater.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("/inox")
    public List<Movies> getMovieResponse(){
        return moviesService.getMovies();
    }

    @GetMapping("/inox/{movie_id}/{date}/{qty}")
    public List<AvailableResponse> getMovieRequestResponse(@PathVariable long movie_id,@PathVariable String date,@PathVariable int qty){
        return moviesService.getAvailableRequest(movie_id,date,qty);
    }

    @GetMapping("/inox/{movie_id}/{date}/{qty}/{show_time}")
    public String getMovieBookingResponse(@PathVariable int movie_id,@PathVariable String date,@PathVariable int qty,@PathVariable String show_time){
        return moviesService.getBookingRequest(movie_id,date,qty,show_time);
    }
}
