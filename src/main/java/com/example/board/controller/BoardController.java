package com.example.board.controller;

import com.example.board.DTO.Board;
import com.example.board.DTO.User;
import com.example.board.service.BoardService;
import com.example.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * @Method Name : BoardList
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community View
     * @param model
     * @return
     */
    @RequestMapping("/board/BoardList")
    public String BoardList(Model model,HttpSession session){
        List<Board> boardList = boardService.BoardList();
        System.out.println("================boardList");
        System.out.println(boardList);
        model.addAttribute("BoardList", boardList);

        return "/board/BoardList";
    }

    /**
     * @Method Name : BoardRegisterPage
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Register View
     * @param model
     * @return
     */
    @RequestMapping(value = "/board/BoardRegister", method = RequestMethod.GET)
    public String BoardRegisterPage(HttpSession session, Model model) {

        String userId = (String) session.getAttribute("userId");
        model.addAttribute("userId", userId);
        return "/board/BoardRegister";

    }

    /**
     * @Method Name : BoardRegister
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Register
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/BoardRegister", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int BoardRegister(@RequestParam Map<String, Object> params,HttpSession session) {

        int result = 0;
        String userId = (String) session.getAttribute("userId");
        params.put("boardId", userId);
        result = boardService.InsertBoard(params);

        return result;
    }
    /**
     * @Method Name : BoardDetail
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Detail View
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/BoardDetail" , method = RequestMethod.POST)
    public String BoardDetail(@RequestParam Map<String, Object> params , Model model) {

        List<Board> boardDetail = boardService.BoardDetail(params);

        model.addAttribute("BoardDetail", boardDetail);

        return "/board/BoardDetail";

    }
    /**
     * @Method Name : BoardCntUpdate
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community 조회수 Update
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/BoardCntUpdate", method = RequestMethod.POST)
    @ResponseBody
    public int BoardCntUpdate(@RequestParam Map<String, Object> params) {
        int rateCnt = boardService.CheckBoardCnt(params);
        params.put("boardCnt", rateCnt + 1);
        int result = 0;
        result = boardService.BoardCntUpdate(params);

        return result;
    }

    /**
     * @Method Name : BoardModifyCheck
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community 수정 가능한지 Check
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/BoardModifyCheck", method = RequestMethod.POST)
    @ResponseBody
    public int BoardModifyCheck(@RequestParam Map<String, Object> params, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        params.put("boardId", userId);
        int result = boardService.BoardModifyCheck(params);
        return result;
    }

    /**
     * @Method Name : UpdateBoard
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community Update
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/UpdateBoard", method = RequestMethod.POST)
    @ResponseBody
    public int UpdateBoard(@RequestParam Map<String, Object> params) {
        int result = boardService.UpdateBoard(params);
        return result;
    }

    /**
     * @Method Name : selectBoardList
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community 검색 조건 Filtering
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/selectBoardList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectBoardList(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = boardService.SelectBoardList(params);
        return map;
    }

    /**
     * @Method Name : deleteBoard
     * @작성일 : 2024. 12. 08.
     * @작성자 : "KWJ"
     * @변경이력 :
     * @Method 설명 : Community delete
     * @param params
     * @return
     */
    @RequestMapping(value = "/board/deleteBoard", method = RequestMethod.POST)
    @ResponseBody
    public int deleteBoard(@RequestBody Map<String, Object> params) {
        List<Integer> boardSeqs = (List<Integer>) params.get("boardSeqs");

        int result = boardService.deleteBoard(boardSeqs);
        return result;
    }
}
