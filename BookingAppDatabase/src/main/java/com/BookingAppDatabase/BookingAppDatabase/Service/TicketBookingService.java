package com.BookingAppDatabase.BookingAppDatabase.Service;

import com.BookingAppDatabase.BookingAppDatabase.Models.AvailableRequest;
import com.BookingAppDatabase.BookingAppDatabase.Models.AvailableResponse;
import com.BookingAppDatabase.BookingAppDatabase.Models.BookingRequest;
import com.BookingAppDatabase.BookingAppDatabase.Models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketBookingService {

    @Autowired
    RestTemplate restTemplate;
    ArrayList<Movies> movies = new ArrayList<Movies>();

    public List<Movies> getMovies(String theat_name) {
        String url;
        if (theat_name.equals("pvr")) {
            url = "http://localhost:8080/"+theat_name;
        }else {
            url = "http://localhost:8081/"+theat_name;
        }
        movies = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Movies>>() {
        }).getBody();

        return movies;
    }

    public List<AvailableResponse> getAvailableResponse(String theat_name, AvailableRequest avlRq) {
        ArrayList<AvailableResponse> avlResponse = new ArrayList<AvailableResponse>();

        String rq_url;
        if (theat_name.equals("pvr")) {
            rq_url = "http://localhost:8080/" + theat_name + "/" + avlRq.getMovie_id() + "/" + avlRq.getDate() + "/" + avlRq.getQty();
        }else {
            rq_url = "http://localhost:8081/"+theat_name+"/"+avlRq.getMovie_id()+"/"+avlRq.getDate()+"/"+avlRq.getQty();
        }

        avlResponse = restTemplate.exchange(rq_url, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<AvailableResponse>>() {
        }).getBody();

        return avlResponse;
    }

    public String getBookingResponse(String theat_name, BookingRequest bookRq) {
        String status = null;

        String rq_url;
        if (theat_name.equals("pvr")) {
            rq_url = "http://localhost:8080/"+theat_name+"/"+bookRq.getMovie_id()+"/"+bookRq.getDate()+"/"+bookRq.getQty()+"/"+bookRq.getShowTime();
        }else {
            rq_url = "http://localhost:8081/"+theat_name+"/"+bookRq.getMovie_id()+"/"+bookRq.getDate()+"/"+bookRq.getQty()+"/"+bookRq.getShowTime();
        }

        status = restTemplate.exchange(rq_url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();

        return status;
    }

}
