package com.example.board.service;

import com.example.board.DTO.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int InsertUser(Map<String, Object> params);
    int IdCheck(Map<String, Object> params);
    int loginIdCheck(Map<String, Object> params);
    String loginPwdCheck(Map<String, Object> params);
    int userUpdatePw(Map<String, Object> params);
    List<User> userDetail(String userId);
    int UpdateUser(Map<String, Object> params);
    String userSeqCheck(String userId);
}
