package com.example.board.service.impl;

import com.example.board.DTO.Board;
import com.example.board.DTO.Comment;
import com.example.board.mapper.CommentRepository;
import com.example.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> commentList(Map<String, Object> params) {
        Integer boardSeq = Integer.parseInt((String) params.get("boardSeq"));
        return commentRepository.commentList(boardSeq);
    }

    @Override
    public int commentRegister(Map<String, Object> params) {
        Comment comment = new Comment();

        comment.setCommentContent((String) params.get("commentContent"));
        comment.setUserId((String) params.get("userId"));
        comment.setCreateDt(LocalDateTime.now());

        Board board = new Board();
        board.setBoardSeq(Integer.parseInt((String) params.get("boardSeq")));
        comment.setBoard(board);

        Comment saveComment = commentRepository.save(comment);

        return saveComment.getCommentSeq();
    }
}
