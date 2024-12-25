package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.GeneralTravel;
import com.example.board.DTO.Travel.LeisureSports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeisureSportsRepository extends JpaRepository<LeisureSports, Integer> {
    @Query(value = "SELECT * FROM travel_leisure_sports  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<LeisureSports> myLeisureSportsList(@Param("userSeq") Integer userSeq);
}
