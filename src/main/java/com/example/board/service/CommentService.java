package com.example.board.service;

import com.example.board.DTO.Comment;
import java.util.List;
import java.util.Map;

public interface CommentService {

    List<Comment> commentList(Map<String, Object> params);

    int commentRegister(Map<String, Object> params);
}
