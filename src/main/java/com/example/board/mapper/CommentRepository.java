package com.example.board.mapper;

import com.example.board.DTO.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM travel_comment WHERE board_seq = :boardSeq", nativeQuery = true)
    List<Comment> commentList(@Param("boardSeq") Integer boardSeq);

}
