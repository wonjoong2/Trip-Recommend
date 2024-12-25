package com.example.board.controller;

import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     * @Method Name : LoginPage
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Index Page
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String LoginPage(Model model) {
        return "/board/index";
    }
    /**
     * @Method Name : UserRegisterPage
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : User Register View
     * @param model
     * @return
     */
    @RequestMapping("/user/UserRegister")
    public String UserRegisterPage(Model model) {
        return "/user/UserRegister";
    }

    /**
     * @Method Name : IdCheck
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Login 하기 전 ID 존재여부 확인
     * @param params
     * @return
     */
    @RequestMapping(value = "/user/IdCheck", method = RequestMethod.POST)
    @ResponseBody
    public int IdCheck(@RequestParam Map<String, Object> params) {
        int result = userService.IdCheck(params);
        return result;
    }

    /**
     * @Method Name : encryptSHA256
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : PW 암호화(SHA256)
     * @return
     */
    private String encryptSHA256(String str) {
        String SHA = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // 예외 처리
            SHA = null;
        }
        return SHA;
    }

    /**
     * @Method Name : UserRegister
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : User Register
     * @return
     */
    @RequestMapping(value = "/user/UserRegister", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int UserRegister(@RequestParam Map<String, Object> params) {
        int result = 0;
        String pwd = (String) params.get("userPwd");
        String encryptedPwd = encryptSHA256(pwd);
        params.put("userPwd", encryptedPwd);
        result = userService.InsertUser(params);

        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleException(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }

    /**
     * @Method Name : login
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Login
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam Map<String, Object> params, HttpSession session) throws Exception {

        int idCheck = userService.loginIdCheck(params);
        if(idCheck<1){
            throw new Exception("존재하지 않는 ID입니다.");
        }
        String userPwd = (String) params.get("userPwd");
        String encryptedPwd = encryptSHA256(userPwd);
        String pwdCheck = userService.loginPwdCheck(params);

        //패스워드 체크
        if(!encryptedPwd.equals(pwdCheck)){
            throw new Exception("비밀번호를 확인해주세요");
        }
        String userId = (String) params.get("userId");
        session.setAttribute("userId", userId);

        return "/board/BoardList";
    }

    /**
     * @Method Name : logout
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : logout
     * @return
     */
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return null;
    }

    /**
     * @Method Name : UserFindIdPw
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : ID / PW 찾기 View
     * @return
     */
    @RequestMapping("/user/UserFindIdPw")
    public String UserFindIdPw(Model model) {
        return "/user/UserFindIdPw";
    }

    /**
     * @Method Name : userUpdatePw
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : PW Update
     * @return
     */
    @RequestMapping(value = "/user/userUpdatePw", method = RequestMethod.POST)
    @ResponseBody
    public int userUpdatePw(@RequestParam Map<String, Object> params) {
        String pwd = (String) params.get("userNewPw");
        String encryptedPwd = encryptSHA256(pwd);
        params.put("userNewPw", encryptedPwd);
        int result = userService.userUpdatePw(params);
        return result;
    }

    /**
     * @Method Name : UserUpdate
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : MyPage User 정보 Update
     * @return
     */
    @RequestMapping(value = "/user/UserUpdate", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int UserUpdate(@RequestParam Map<String, Object> params) {
        int result = 0;
        String pwd = (String) params.get("userPwd");
        String encryptedPwd = encryptSHA256(pwd);
        params.put("userPwd", encryptedPwd);
        result = userService.UpdateUser(params);

        return result;
    }
}
