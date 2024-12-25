package com.example.board.DTO;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "travel_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 생성
	@Column(name = "user_seq") // DB 컬럼 이름
	private int userSeq;

	@Column(name = "user_id", nullable = false, unique = true) // 컬럼 매핑
	private String userId;

	@Column(name = "user_nickname")
	private String userNickname;

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Column(name = "user_pwd", nullable = false)
	private String userPwd;

	@Column(name = "user_nm")
	private String userNm;

	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_postcode")
	private String userPostcode;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_address1")
	private String userAddress1;

	@Column(name = "user_address2")
	private String userAddress2;

	@Column(name = "create_id")
	private String createId;

	@Column(name = "update_id")
	private String updateId;

	@Column(name = "create_dt", updatable = false)
	private LocalDateTime createDt;

	@Column(name = "update_dt")
	private LocalDateTime updateDt;



	// Getters and Setters
	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPostcode() {
		return userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2() {
		return userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public LocalDateTime getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}

	public LocalDateTime getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		return "User{" +
				"userSeq=" + userSeq +
				", userId='" + userId + '\'' +
				", userNickname='" + userNickname + '\'' +
				", userPwd='" + userPwd + '\'' +
				", userNm='" + userNm + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userPostcode='" + userPostcode + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userAddress1='" + userAddress1 + '\'' +
				", userAddress2='" + userAddress2 + '\'' +
				", createId='" + createId + '\'' +
				", updateId='" + updateId + '\'' +
				", createDt=" + createDt +
				", updateDt=" + updateDt +
				'}';
	}
}
