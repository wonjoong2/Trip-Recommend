package com.example.board.service.impl;

import com.example.board.DTO.User;
import com.example.board.mapper.UserRepository;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int IdCheck(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        return userRepository.IdCheck(userId);
    }

    @Override
    public int userUpdatePw(Map<String, Object> params) {
        String userId = (String) params.get("userId");

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Board not found with boardSeq: " + userId));

        user.setUserPwd((String) params.get("userNewPw"));
        user.setUpdateId((String) params.get("userId"));
        user.setUpdateDt(LocalDateTime.now());

        User userUpdate = userRepository.save(user);
        return userUpdate.getUserSeq();
    }

    @Override
    public List<User> userDetail(String userId) {
        return userRepository.userDetail(userId);
    }

    @Override
    public int UpdateUser(Map<String, Object> params) {
        Integer userSeq = Integer.parseInt((String) params.get("userSeq"));
        User user = userRepository.findById(userSeq)
                .orElseThrow(() -> new RuntimeException("Board not found with boardSeq: " + userSeq));

        user.setUserPwd((String) params.get("userPwd"));
        user.setUserPhone((String) params.get("userPhone"));
        user.setUserPostcode((String) params.get("userPostcode"));
        user.setUserEmail((String) params.get("userEmail"));
        user.setUserAddress1((String) params.get("userAddress1"));
        user.setUserAddress2((String) params.get("userAddress2"));

        User updateUser = userRepository.save(user);
        return updateUser.getUserSeq();
    }

    @Override
    public String userSeqCheck(String userId) {
        return userRepository.userSeqCheck(userId);
    }

    @Override
    public int loginIdCheck(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        return userRepository.loginIdCheck(userId);
    }

    @Override
    public String loginPwdCheck(Map<String, Object> params) {
        String userId = (String) params.get("userId");
        return userRepository.loginPwdCheck(userId);
    }
    @Override
    public int InsertUser(Map<String, Object> params) {
        User user = new User();
        user.setUserId((String) params.get("userId"));
        user.setUserNickname((String) params.get("userNickname"));
        user.setUserPwd((String) params.get("userPwd"));
        user.setUserNm((String) params.get("userNm"));
        user.setUserPhone((String) params.get("userPhone"));
        user.setUserPostcode((String) params.get("userPostcode"));
        user.setUserEmail((String) params.get("userMail"));
        user.setUserAddress1((String) params.get("userAddress1"));
        user.setUserAddress2((String) params.get("userAddress2"));
        user.setCreateDt(LocalDateTime.now());
        user.setCreateId((String) params.get("userId"));

        User saveUser = userRepository.save(user);
        return saveUser.getUserSeq();
    }

}
