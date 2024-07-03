<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    	

                
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DLT_작성한 글</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
       <link href = "<c:url value = '/css/style.css' /> " rel = "stylesheet">
       <link href = "<c:url value = '/css/css.css' /> " rel = "stylesheet">
    </head>


    <body>
        <!-- Navbar Start -->
        <jsp:include page="../common/navi.jsp" flush="true">
            <jsp:param name="navi" value="네비호출" />
        </jsp:include>
        <!-- Navbar End -->


        <div id="conatain" class="board_wrap">
            <div class="board_title">
                <strong>DLT 커뮤니티</strong>
                <p>질문하고 소통하는 공간! 커뮤니티에 오신것을 환영합니다.</p>
            </div>
            <div class="board_view_wrap">
                <div class="board_view">
                    <div class="title">
                        ${board.boardTitle }
                    </div>
                    <div class="info">
                        <dl>
                            <dt>작성자</dt>
                            <dd>${board.userName }</dd>
                        </dl>
                        <dl>
                            <dt>작성일</dt>
                            <dd>${board.boardDate }</dd>
                        </dl>
                        <dl>
                            <dt>조회</dt>
                            <dd>${board.boardViews }</dd>
                        </dl>
                    </div>
                    <div class="cont">
						${board.getBoardContent() }
                    </div>
                </div>

                <!--URL 이동-->
                <div class="bt_wrap">
                    <a href="${pageContext.request.contextPath}/boardList/1" class="on">목록</a>
                    
				<c:choose>
					<c:when test = "${board.userId == user_id }">
                     	<a href="${pageContext.request.contextPath}/getEditBoard/${board.boardId}" class="on">수정</a>
					</c:when>
				</c:choose>
                </div>
                
           
        <form action="writeComment" method="post" name="commentform" id="commentform">
		<input type="hidden" name="bId" value="${board.boardId }" /> 
		<div class="comments-container">


			<!-- 댓글 목록 -->
			<c:forEach items="${commentList}" var="dto">
				<div class="comment ${dto.cStep == 0 ? 'bComment' : 'special-bComment'}"> <!-- 댓글이면 bComment, 답글이면 special-bComment -->
					<c:choose>
						<c:when test="${dto.cStep == 0}">
							<strong>${dto.cName } :</strong>${dto.bComment }
            </c:when>
						<c:otherwise>
							<strong>${dto.cName } :</strong>${dto.bComment }
            </c:otherwise>
					</c:choose>
					
					<div class="comment-info">${dto.cDate }</div>

					<c:choose>
						<c:when test="${user_id != null}">
							<c:choose>
								<c:when test="${dto.cStep == 0}">
									<div class="reply-button"
										onclick="showReplyForm('${dto.cName }', ${dto.bGroup })">답글
										달기</div>
								</c:when>
								<c:otherwise>
									<div class="different-reply-button"></div>
								</c:otherwise>
							</c:choose>

							<!-- ${dto.userId}와 ${sessionId}를 비교하여 일치하면 삭제하기 버튼 추가 -->
							<c:if test="${dto.userId == user_id}">
								<div class="delete-button">
									<a href="deleteComment/${dto.cId }/${dto.cStep}/${dto.bGroup }/${board.boardId}" onclick = "return confirmDeleteComment()">삭제하기</a>
								</div>
							</c:if>
						</c:when>
						<c:otherwise>
							<div class="reply-button" onclick="loginPage()">답글
								달기</div>
						</c:otherwise>
					</c:choose>
				</div>
			</c:forEach>


			<!-- 댓글 입력 폼 -->
			<div class="comment-form">
				<textarea id="commentText" name="bComment"
					placeholder="댓글을 입력하세요"></textarea>


				<c:choose>
					<c:when test="${user_id != null}">
						<input id="insertbtn" type="button" value="댓글 등록 "
							onclick="commentCheck()">
					</c:when>
					<c:otherwise>
						<input id="insertbtn" type="button" value="댓글 등록"
							onclick="loginPage()">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form>

            </div>
        </div>


        <!-- Footer Start -->
        <jsp:include page="../common/footer.jsp" flush="true">
            <jsp:param name="footer" value="푸터호출" />
        </jsp:include>
        <!-- Footer End -->


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        

		<script src = "<c:url value = '/js/board.js'/>"></script>

    </body>

    </html>