package com.example.board.service.impl;

import com.example.board.DTO.Board;
import com.example.board.mapper.BoardRepository;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> BoardList() {
        return boardRepository.BoardList();
    }

    @Override
    public List<Board> BoardDetail(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));
        return boardRepository.BoardDetail(boardSeq);
    }
//
    @Override
    public int CheckBoardCnt(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));
        return boardRepository.CheckBoardCnt(boardSeq);
    }

    @Override
    public int BoardCntUpdate(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));
        Integer boardCnt = (Integer) params.get("boardCnt");

        Board board = boardRepository.findById(boardSeq)
                .orElseThrow(() -> new RuntimeException("Board not found with boardSeq: " + boardSeq));
        board.setBoardCnt(boardCnt);
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getBoardSeq();
    }


    @Override
    public int InsertBoard(Map<String, Object> params) {
        Board board = new Board();
        board.setBoardId((String) params.get("id"));
        board.setBoardTitle((String) params.get("title"));
        board.setBoardContent((String) params.get("content"));
        board.setBoardCnt(0);
        board.setBoardCreateDt(LocalDateTime.now());
        board.setBoardCreateId((String) params.get("boardId"));
        Board savedBoard = boardRepository.save(board);

        return savedBoard.getBoardSeq();
    }

    @Override
    public int BoardModifyCheck(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));
        String boardId = (String) params.get("boardId");

        return boardRepository.BoardModifyCheck(boardSeq, boardId);
    }

    @Override
    public int UpdateBoard(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));

        Board board = boardRepository.findById(boardSeq)
                .orElseThrow(() -> new RuntimeException("Board not found with boardSeq: " + boardSeq));

        board.setBoardTitle((String) params.get("boardTitle"));
        board.setBoardContent((String) params.get("boardContent"));
        board.setBoardId((String) params.get("boardId"));

        Board savedBoard = boardRepository.save(board);
        return savedBoard.getBoardSeq();
    }

    @Override
    public Map<String, Object> SelectBoardList(Map<String, Object> params) {

        String searchTitle = (String) params.get("searchTitle");

        List<Board> list = boardRepository.SelectBoardList(searchTitle);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        return map;

    }

    @Override
    public int deleteBoard(List<Integer> boardSeqs) {
        boardRepository.deleteAllById(boardSeqs);
        return boardSeqs.size();
    }

}
