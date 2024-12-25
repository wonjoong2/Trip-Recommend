package com.example.board.controller;

import com.example.board.DTO.User;
import com.example.board.mapper.UserRepository;
import com.example.board.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    /**
     * @Method Name : IdCheckTest
     * @작성일 : 2024. 12. 11.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Login 하기 전 ID 존재여부 확인 Test
     * @param
     * @return
     */
    @Test
    public void IdCheckTest() throws Exception{
        //given
        User user = new User();
        user.setUserId("admin");
        HashMap<String,Object> params = new HashMap<>();
        params.put("userId",user.getUserId());
        //when
        int IdCheck = userService.IdCheck(params);
        //then
        assertEquals(1, IdCheck);
    }

    /**
     * @Method Name : UserRegisterTest
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : User Register Test
     * @return
     */
    @Test
//    @Rollback(false)
    public void UserRegisterTest() {
        //given
        User user = new User();
        user.setUserId("hongking3");
        user.setUserNickname("홍킹3");
        user.setUserPwd("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
        user.setUserNm("홍진호");
        user.setUserPhone("01022222222");
        user.setUserPostcode("06035");
        user.setUserEmail("kong@gmail.com");
        user.setUserAddress1("서울 강남구 가로수길 5 (신사동)");
        user.setUserAddress2("101-2201");
        user.setCreateDt(LocalDateTime.now());
        user.setCreateId("admin");
        //when
        User saveUser = userRepository.save(user);
        //then
        assertEquals("hongking3",saveUser.getUserId());
        assertEquals("홍킹3",saveUser.getUserNickname());

    }


}