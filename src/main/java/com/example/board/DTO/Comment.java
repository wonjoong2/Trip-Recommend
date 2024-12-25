package com.example.board.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "travel_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_seq")
    private int commentSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_seq")
    @JsonBackReference
    private Board board;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "create_dt")
    private LocalDateTime createDt;

    // Getters and Setters
    public int getCommentSeq() {
        return commentSeq;
    }

    public void setCommentSeq(int commentSeq) {
        this.commentSeq = commentSeq;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentSeq=" + commentSeq +
                ", board=" + (board != null ? board.getBoardSeq() : "null") +
                ", userId='" + userId + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", createDt=" + createDt +
                '}';
    }
}
