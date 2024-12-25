package com.example.board.mapper;

import com.example.board.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT COUNT(*) FROM TRAVEL_USER WHERE USER_ID = :userId", nativeQuery = true)
    int IdCheck(@Param("userId") String userId);
    Optional<User> findByUserId(String userId);
    @Query(value = "SELECT COUNT(*) FROM TRAVEL_USER WHERE USER_ID = :userId", nativeQuery = true)
    int loginIdCheck(@Param("userId") String userId);
    @Query(value = "SELECT USER_PWD FROM TRAVEL_USER WHERE USER_ID = :userId", nativeQuery = true)
    String loginPwdCheck(@Param("userId") String userId);

    @Query(value = "SELECT * FROM TRAVEL_USER WHERE USER_ID = :userId", nativeQuery = true)
    List<User> userDetail(@Param("userId") String userId);

    @Query(value = "SELECT USER_SEQ FROM TRAVEL_USER WHERE USER_ID = :userId", nativeQuery = true)
    String userSeqCheck(@Param("userId") String userId);
}
