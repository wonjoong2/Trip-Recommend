package com.example.board.mapper.TravelRepository;

import com.example.board.DTO.Travel.Food;
import com.example.board.DTO.Travel.GeneralTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {
    @Query(value = "SELECT * FROM travel_food  WHERE USER_SEQ = :userSeq", nativeQuery = true)
    List<Food> myFoodList(@Param("userSeq") Integer userSeq);
}
