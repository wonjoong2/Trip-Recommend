package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.GeneralTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GeneralTravelRepository extends JpaRepository<GeneralTravel, Integer> {

    @Query(value = "SELECT * FROM travel_general_travel  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<GeneralTravel> myGeneralTravelList(@Param("userSeq") Integer userSeq);


}
