package com.dlt.senior.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.senior.board.dao.IBoardRepository;
import com.dlt.senior.board.model.BoardVO;
import com.dlt.senior.board.model.CommentVO;


@Service
public class BoardService implements IBoardService{
	
	@Autowired
	IBoardRepository boardRepository;
	
	//게시판 글 목록 조회
	@Override
	public List<BoardVO> getBoardList(int page) {
		int startRow = (page - 1) * 10 + 1;
		int endRow = 10 + startRow - 1;
		int recordsPerPage = 10;
		int totalPages = (int) Math.ceil((double) boardRepository.totalRows() / recordsPerPage);
		int pageRange = 5;
		int startPage = Math.max(1, page - pageRange / 2);
		int endPage = Math.min(totalPages, startPage + pageRange - 1);
		
				
		List<BoardVO> test = boardRepository.getBoardList(startRow, endRow);
		test.get(0).setTotalPages(totalPages);
		test.get(0).setPageRange(pageRange);
		test.get(0).setStartPage(startPage);
		test.get(0).setEndPage(endPage);
		return test;  
	}
	
	//게시판 글 조회
	@Override
	public BoardVO getBoardView(int boardId) {
		boardRepository.updateViewership(boardId); //뷰어십 업데이트
		BoardVO vo = boardRepository.getBoardView(boardId); //게시글 상세 조회
		return vo;
	}
	
	//게시판 글 삭제
	@Override
	public void deleteBoard(int boardId) {
		boardRepository.deleteBoard(boardId);
	}
	
	//게시판 글 댓글 조회
	@Override
	public List<CommentVO> getCommentList(int boardId) {
		List<CommentVO> vo = boardRepository.getCommentList(boardId);
		
		return vo;
	}
	
	//글 작성
	@Override
	public void insertBoard(BoardVO vo) {
		vo.setBoardContent(vo.getBoardContent().replace("\n", "<br>"));
		boardRepository.insertBoard(vo);
	}
	
	//글 수정 조회
	@Override
	public BoardVO getEditBoard(int boardId) {
		BoardVO vo = boardRepository.getEditBoard(boardId);
		vo.setBoardContent(vo.getBoardContent().replace("<br>", "\n"));
		return vo;
	}
	
	//글 수정
	@Override
	public void editBoard(BoardVO vo) {
		vo.setBoardContent(vo.getBoardContent().replace("\n", "<br>"));
		boardRepository.editBoard(vo);
	}
	
	//댓글 작성
	@Override
	public void insertComment(CommentVO vo) {
		vo.setbComment(vo.getbComment().replace("\n", "<br>"));
		if(vo.getbGroup() == 0) {;
			boardRepository.insertComment(vo);
		}
		else {
			vo.setcStep(1);
			boardRepository.insertReply(vo);
		}
	}
	
	//댓글 삭제
	@Override
	public void deleteComment(int cId, int cStep, int bGroup) {
		boardRepository.deleteComment(cId, cStep, bGroup);
	}
}
