package com.example.board.controller;


import com.example.board.DTO.Board;
import com.example.board.mapper.BoardRepository;
import com.example.board.service.BoardService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDateTime;
import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class BoardControllerTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    EntityManager em;


    /**
     * @Method Name : BoardRegisterTest
     * @작성일 : 2024. 12. 11.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Register Test
     * @param
     * @return
     */
    @Test
    public void BoardRegisterTest() throws Exception{
        //given
        Board board = new Board();
        board.setBoardSeq(100);
        board.setBoardId("100");
        board.setBoardTitle("100");
        board.setBoardContent("100");
        board.setBoardCnt(0);
        board.setBoardCreateDt(LocalDateTime.now());
        board.setBoardCreateId("100");
        //when
        Board savedBoard = boardRepository.save(board);
        em.flush();
        //then
        assertEquals("100", savedBoard.getBoardId());
        assertEquals("100", savedBoard.getBoardTitle());
        assertEquals("100", savedBoard.getBoardContent());
    }

    /**
     * @Method Name : UpdateBoardTest
     * @작성일 : 2024. 12. 11.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Update Test
     * @param
     * @return
     */
    @Test
    public void UpdateBoardTest() throws Exception{
        //given
        Board board = new Board();
        //현재 board_seq 가 2인 데이터의 board_cnt 는 1
        board.setBoardSeq(2);
        HashMap<String,Object> params = new HashMap<>();
        params.put("boardSeq", String.valueOf(board.getBoardSeq()));
        //when
        int rateCnt = boardService.CheckBoardCnt(params);
        //then
        assertEquals(1, rateCnt);
    }
}
