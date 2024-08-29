package com.BookingAppDatabase.BookingAppDatabase.Repository;

import com.BookingAppDatabase.BookingAppDatabase.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}
