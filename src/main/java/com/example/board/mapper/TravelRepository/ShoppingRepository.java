package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.GeneralTravel;
import com.example.board.DTO.Travel.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingRepository extends JpaRepository<Shopping,Integer> {
    @Query(value = "SELECT * FROM travel_shopping  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<Shopping> myShoppingList(@Param("userSeq") Integer userSeq);
}
