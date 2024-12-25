package com.example.board.service;

import com.example.board.DTO.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<Board> BoardList();
    List<Board> BoardDetail(Map<String, Object> params);
    int CheckBoardCnt(Map<String, Object> params);
    int BoardCntUpdate(Map<String, Object> params);
    int InsertBoard(Map<String, Object> params);
    int BoardModifyCheck(Map<String, Object> params);
    int UpdateBoard(Map<String, Object> params);
    Map<String, Object> SelectBoardList(Map<String, Object> params);
    int deleteBoard(List<Integer> boardSeqs);
}
