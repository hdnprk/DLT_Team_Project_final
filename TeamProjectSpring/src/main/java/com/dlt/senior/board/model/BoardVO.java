package com.dlt.senior.board.model;

import java.sql.Date;

public class BoardVO {
	private int boardId;
	private String userName;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardViews;
	private int page;
	private int totalPages;
	private int pageRange;
	private int startPage;
	private int endPage;
	
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageRange() {
		return pageRange;
	}
	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBoardId() {
		return boardId;
	}
	public String getUserId() {
		return userId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	
}
