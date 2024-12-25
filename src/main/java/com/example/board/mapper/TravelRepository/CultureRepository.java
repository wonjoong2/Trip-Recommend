package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.Culture;
import com.example.board.DTO.Travel.GeneralTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CultureRepository extends JpaRepository<Culture, Integer> {

    @Query(value = "SELECT * FROM travel_culture  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<Culture> myCultureList(@Param("userSeq") Integer userSeq);
}
