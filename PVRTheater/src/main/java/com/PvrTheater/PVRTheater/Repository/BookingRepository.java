package com.PvrTheater.PVRTheater.Repository;

import com.PvrTheater.PVRTheater.Models.BookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingResponse, Integer>{
}
