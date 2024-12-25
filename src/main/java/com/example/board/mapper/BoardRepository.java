package com.example.board.mapper;

import com.example.board.DTO.Board;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.user")
    List<Board> BoardList();

    @Query(value = "SELECT * FROM travel_board WHERE board_seq = :boardSeq", nativeQuery = true)
    List<Board> BoardDetail(@Param("boardSeq") Integer boardSeq);

    @Query(value = "SELECT BOARD_CNT FROM travel_board WHERE board_seq = :boardSeq", nativeQuery = true)
    int CheckBoardCnt(@Param("boardSeq") Integer boardSeq);

    @Query(value = "SELECT COUNT(*) FROM travel_board WHERE board_seq = :boardSeq AND BOARD_CREATE_ID = :boardId", nativeQuery = true)
    int BoardModifyCheck(@Param("boardSeq") Integer boardSeq, @Param("boardId") String boardId);

    @Query(value = "SELECT * FROM travel_board WHERE board_title LIKE %:searchTitle%", nativeQuery = true)
    List<Board> SelectBoardList(@Param("searchTitle") String searchTitle);
}
