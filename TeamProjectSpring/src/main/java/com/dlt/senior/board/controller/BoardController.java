package com.dlt.senior.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dlt.senior.board.model.BoardVO;
import com.dlt.senior.board.model.CommentVO;
import com.dlt.senior.board.service.IBoardService;



@Controller
public class BoardController {

	@Autowired
	IBoardService boardService;
	
	//메인 페이지
	@GetMapping(value = "/")
	public String mainPage(Model model) {
		int page = 1;
		model.addAttribute("boardList", boardService.getBoardList(page));
		return "index";
	}
	
	//글 리스트 조회
	@GetMapping(value = "/boardList/{page}")
	public String getBoardList(@PathVariable int page, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(page));
		return "board/boardList";
	}
	
	
	//상세 글 조회
	@GetMapping(value = "/boardView/{boardId}")
	public String getBoardView(@PathVariable int boardId, Model model) {
		model.addAttribute("board", boardService.getBoardView(boardId)); //글 조회
		model.addAttribute("commentList", boardService.getCommentList(boardId)); //댓글 조회
		return "board/boardView";
	}
	
	//글 작성 페이지 조회(세션 아이디 조회)
	@GetMapping(value = "/getWriteBoard")
	public String getWriteBoard() {
		return "board/boardWrite";
	}
	
	//글 작성
	@PostMapping(value = "/writeBoard")
	public String writeBoard(@ModelAttribute BoardVO vo,HttpSession session) {
		vo.setUserId((String) session.getAttribute("user_id"));
		vo.setUserName((String) session.getAttribute("user_name"));
		boardService.insertBoard(vo);
		return "redirect:/boardList/1";
	}
	
	//글 수정 페이지 조회
	@GetMapping(value = "/getEditBoard/{boardId}")
	public String getEditBoard(@PathVariable int boardId, Model model) {
		BoardVO vo = boardService.getEditBoard(boardId);
		model.addAttribute("board", vo);
		return "board/boardEdit";
	}
	
	//글 수정
	@PostMapping(value = "/editBoard")
	public String updateBoard(@ModelAttribute BoardVO vo) {
		boardService.editBoard(vo);
		return "redirect:/boardView/" + vo.getBoardId();
	}
	
	//글 삭제
	@GetMapping(value = "/deleteBoard/{boardId}")
	public String deleteBoard(@PathVariable int boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/boardList/1";
	}
	
	//댓글 작성
	@PostMapping(value = "/boardView/writeComment")
	public String writeComment(@ModelAttribute CommentVO vo, Model model,HttpSession session) {		
		vo.setUserId((String) session.getAttribute("user_id"));
		vo.setcName((String) session.getAttribute("user_name"));
		
		boardService.insertComment(vo);
		
		return "redirect:/boardView/" + vo.getbId();
	}
	
	//답글 작성
	@PostMapping(value = "/boardView/writeComment/{groupId}")
	public String writeComment(@ModelAttribute CommentVO vo, @PathVariable int groupId, Model model, HttpSession session) {
		vo.setUserId((String) session.getAttribute("user_id"));
		vo.setcName((String) session.getAttribute("user_name"));
		
		vo.setbGroup(groupId);
		
		boardService.insertComment(vo);
		
		return "redirect:/boardView/" + vo.getbId();
	}
	
	@GetMapping(value = "/boardView/deleteComment/{cId}/{cStep}/{bGroup}/{boardId}")
	public String deleteComment(@PathVariable int cId, @PathVariable int cStep, @PathVariable int bGroup, @PathVariable int boardId) {
		boardService.deleteComment(cId,cStep,bGroup);
		
		return "redirect:/boardView/" + boardId;
	}
}
