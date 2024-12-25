package com.example.board.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "travel_board")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_seq")
	private int boardSeq;

	@Column(name = "board_id", nullable = false)
	private String boardId;

	@Column(name = "board_title", nullable = false)
	private String boardTitle;

	@Column(name = "board_content", nullable = false)
	private String boardContent;

	@Column(name = "board_cnt", nullable = false)
	private int boardCnt;

	@Column(name = "board_create_dt")
	private LocalDateTime boardCreateDt;

	@Column(name = "board_update_dt")
	private LocalDateTime boardUpdateDt;

	@Column(name = "board_create_id")
	private String boardCreateId;

	@Column(name = "board_update_id")
	private String boardUpdateId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "board_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private User user;

	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Comment> comments;

	// Getters and Setters
	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardCnt() {
		return boardCnt;
	}

	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

	public LocalDateTime getBoardCreateDt() {
		return boardCreateDt;
	}

	public void setBoardCreateDt(LocalDateTime boardCreateDt) {
		this.boardCreateDt = boardCreateDt;
	}

	public LocalDateTime getBoardUpdateDt() {
		return boardUpdateDt;
	}

	public void setBoardUpdateDt(LocalDateTime boardUpdateDt) {
		this.boardUpdateDt = boardUpdateDt;
	}

	public String getBoardCreateId() {
		return boardCreateId;
	}

	public void setBoardCreateId(String boardCreateId) {
		this.boardCreateId = boardCreateId;
	}

	public String getBoardUpdateId() {
		return boardUpdateId;
	}

	public void setBoardUpdateId(String boardUpdateId) {
		this.boardUpdateId = boardUpdateId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Board{" +
				"boardSeq=" + boardSeq +
				", boardId='" + boardId + '\'' +
				", boardTitle='" + boardTitle + '\'' +
				", boardContent='" + boardContent + '\'' +
				", boardCnt=" + boardCnt +
				", boardCreateDt=" + boardCreateDt +
				", boardUpdateDt=" + boardUpdateDt +
				", boardCreateId='" + boardCreateId + '\'' +
				", boardUpdateId='" + boardUpdateId + '\'' +
				", user=" + (user != null ? user.toString() : "null") +
				", comments=" + (comments != null ? comments.size() : 0) +
				'}';
	}
}
