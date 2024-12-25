package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.GeneralTravel;
import com.example.board.DTO.Travel.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LodgingRepository extends JpaRepository<Lodging,Integer> {
    @Query(value = "SELECT * FROM travel_lodging  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<Lodging> myLodgingList(@Param("userSeq") Integer userSeq);
}
