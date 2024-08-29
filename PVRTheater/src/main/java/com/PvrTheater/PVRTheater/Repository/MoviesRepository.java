package com.PvrTheater.PVRTheater.Repository;

import com.PvrTheater.PVRTheater.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}
