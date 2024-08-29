package com.inoxtheater.Repository;

import com.inoxtheater.Models.BookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingResponse, Integer>{

}
