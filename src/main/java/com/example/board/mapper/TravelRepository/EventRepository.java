package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.Event;
import com.example.board.DTO.Travel.GeneralTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query(value = "SELECT * FROM travel_event  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<Event> myEventList(@Param("userSeq") Integer userSeq);
}
