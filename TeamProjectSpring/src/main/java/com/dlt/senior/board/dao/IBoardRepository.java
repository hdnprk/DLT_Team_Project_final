 package com.dlt.senior.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dlt.senior.board.model.BoardVO;
import com.dlt.senior.board.model.CommentVO;

public interface IBoardRepository {
	List<BoardVO> getBoardList(@Param("startRow") int startRow,@Param("endRow") int endRow); //게시판 글 목록
	double totalRows(); //페이지네이션
	BoardVO getBoardView(@Param("boardId") int boardId); //게시판 글 조회
	void updateViewership(@Param("boardId") int boardId); //게시판 글 조회수 업데이트
	void insertBoard(BoardVO vo); //글 작성
	BoardVO getEditBoard(int boardId); //글 수정 조회
	void editBoard(BoardVO vo); //글 수정
	void deleteBoard(@Param("boardId") int boardId); // 글 삭제
	List<CommentVO> getCommentList(@Param("boardId") int boardId); //게시판 댓글 목록 조회
	void insertComment(CommentVO vo); //댓글 등록
	void insertReply(CommentVO vo); //대댓글(답글) 등록
	void deleteComment(@Param("cId") int cId,@Param("cStep") int cStep,@Param("bGroup") int bGroup); //댓글 삭제

}
