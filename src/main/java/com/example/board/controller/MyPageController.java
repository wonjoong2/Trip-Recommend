package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.DTO.User;
import com.example.board.service.MyPageService;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;
    private final MyPageService myPageService;

    /**
     * @Method Name : myPagePop
     * @작성일 : 2024. 12. 09.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : myPage Popup View
     * @param params
     * @return
     */
    @RequestMapping(value = "/myPagePop" , method = RequestMethod.POST)
    public String myPagePop(@RequestParam Map<String, Object> params , Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        List<User> userDetail =  userService.userDetail(userId);
        model.addAttribute("userDetail", userDetail.get(0));

        return "/mypage/myPagePop";

    }
    /**
     * @Method Name : myTravelPop
     * @작성일 : 2024. 12. 09.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : myTravel Popup View
     * @param params
     * @return
     */
    @RequestMapping(value = "/myTravelPop" , method = RequestMethod.POST)
    public String myTravelPop(@RequestParam Map<String, Object> params , Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int userSeq = Integer.parseInt(userService.userSeqCheck(userId));
        params.put("userSeq",userSeq);
        model.addAttribute("params", params);

        return "/mypage/myTravelPop";

    }
    /**
     * @Method Name : myPagePop
     * @작성일 : 2024. 12. 09.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : 내 여행목록 List
     * @param params
     * @return
     */
    @RequestMapping("/myTravelList")
    @ResponseBody
    public Map<String, Object> myTravelList(Model model,@RequestParam Map<String, Object> params) throws Exception {

        return myPageService.myTravelList(params);
    }
    /**
     * @Method Name : myGoogleMapPop
     * @작성일 : 2024. 12. 09.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : 내 여행목록 GoogleMap View
     * @param
     * @return
     */
    @RequestMapping(value = "/myGoogleMapPop", method = RequestMethod.POST)
    public String myGoogleMapPop(@RequestParam("locations") String locationsJson, Model model) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSON 문자열을 List<Map<String, Object>>로 변환
            List<Map<String, Object>> locations = objectMapper.readValue(locationsJson, new TypeReference<>() {});
            model.addAttribute("locationsJson", locationsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/mypage/myGoogleMapPop";
    }
}
