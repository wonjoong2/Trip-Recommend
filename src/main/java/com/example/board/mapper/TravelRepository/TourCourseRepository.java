package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.GeneralTravel;
import com.example.board.DTO.Travel.TourCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourCourseRepository extends JpaRepository<TourCourse, Integer> {
    @Query(value = "SELECT * FROM travel_tour_course  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<TourCourse> myTourCourseList(@Param("userSeq") Integer userSeq);
}
