package com.PvrTheater.PVRTheater.Controller;

import com.PvrTheater.PVRTheater.Models.AvailableResponse;
import com.PvrTheater.PVRTheater.Models.Movies;
import com.PvrTheater.PVRTheater.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("/pvr")
    public List<Movies> getMovieResponse(){
        return moviesService.getMovies();
    }

    @GetMapping("/pvr/{movie_id}/{date}/{qty}")
    public List<AvailableResponse> getMovieRequestResponse(@PathVariable long movie_id,@PathVariable String date,@PathVariable int qty){
        return moviesService.getAvailableRequest(movie_id,date,qty);
    }

    @GetMapping("/pvr/{movie_id}/{date}/{qty}/{show_time}")
    public String getMovieBookingResponse(@PathVariable int movie_id,@PathVariable String date,@PathVariable int qty,@PathVariable String show_time){

        return moviesService.getBookingRequest(movie_id,date,qty,show_time);
    }
}
