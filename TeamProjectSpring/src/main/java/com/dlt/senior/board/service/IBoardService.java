package com.dlt.senior.board.service;

import java.util.List;

import com.dlt.senior.board.model.BoardVO;
import com.dlt.senior.board.model.CommentVO;

public interface IBoardService {
	public List<BoardVO> getBoardList(int page); //게시판 글 목록 조회
	public BoardVO getBoardView(int boardId); //게시판 글 조회
	public void insertBoard(BoardVO vo); //글 작성
	public BoardVO getEditBoard(int boardId); //글 수정 조회
	public void editBoard(BoardVO vo); //글 수정
	public void deleteBoard(int boardId); //게시판 글 삭제
	public List<CommentVO> getCommentList(int boardId); //게시판 댓글 조회
	public void insertComment(CommentVO vo); //댓글 작성
	public void deleteComment(int cId, int cStep, int bGroup); //댓글 삭제
}
