<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

             
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>DLT_커뮤니티</title>
                        <link rel="stylesheet" href="<c:url value = '/css/css.css' />">

                        <link rel="stylesheet"
                            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
                            rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
                       	<!-- Template Stylesheet -->
						<link href = "<c:url value = '/css/style.css' /> " rel = "stylesheet">
						
						
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
                            <div class="board_list_wrap">
                                <div class="board_list">
                                    <div class="top">
                                        <div class="num">번호</div>
                                        <div class="title">제목</div>
                                        <div class="writer">작성자</div>
                                        <div class="date">작성일</div>
                                        <div class="count">조회</div>
                                    </div>
                                	<c:if test = "${not empty boardList }">
                 <!--         	<div class="num">${(param.page - 1) * 10 + status.count}</div> -->                                                                                        
	<div>
    	<c:forEach var="dto" items="${boardList}" varStatus="status">
			  <div class="num">${dto.boardId }</div>
        	<div class="title">
            	<a href="${pageContext.request.contextPath}/boardView/${dto.boardId }" style="text-decoration:none">${dto.getBoardTitle()}</a>
        	</div>
        	<div class="writer">${dto.userName }</div>
        	<div class="date">${dto.boardDate }</div>
        	<div class="count">${dto.boardViews }</div>
    	</c:forEach>
	</div>
                                    
                                    </c:if>
                                    
<c:if test="${empty boardList}">
    <div>
        <div class="num">&nbsp;</div>
        <div class="title">&nbsp;</div>
        <div class="writer">&nbsp;</div>
        <div class="date">&nbsp;</div>
        <div class="count">&nbsp;</div>
    </div>
        <div>
        <div class="num">&nbsp;</div>
        <div class="title">&nbsp;</div>
        <div class="writer">&nbsp;</div>
        <div class="date">&nbsp;</div>
        <div class="count">&nbsp;</div>
    </div>
</c:if>

    </div>
			<c:set var="currentPage" value="${boardList.get(0).page }" />
			<div class="board_page">

				<a href="1" class="bt first"> << </a> 
			<c:choose>
			<c:when test = "${boardList.get(0).page  <= boardList.get(0).endPage }">
				<a href="${boardList.get(0).startPage }" class="bt next"> < </a> 
			</c:when>	
			<c:otherwise>
				<a href="${page - 1}" class="bt next"> > </a> 
			</c:otherwise>
			</c:choose>


				<c:forEach var="pageNumber" begin="${boardList.get(0).startPage }" end="${boardList.get(0).endPage}">
					<c:set var="onClass"
						value="${pageNumber eq page ? 'on' : ''}" />
					<a href="${pageNumber}" class="num ${onClass}">${pageNumber}</a>
				</c:forEach>

			<c:choose>
			<c:when test = "${page >= boardList.get(0).endPage  }">
				<a href="${boardList.get(0).endPage }" class="bt next"> > </a> 
			</c:when>
			<c:otherwise>
				<a href="${page + 1}" class="bt next"> > </a> 
			</c:otherwise>
			</c:choose>
				<a href="${boardList.get(0).totalPages }" class="bt last"> >> </a>

			</div>

                                <!--URL 이동-->
                                <div class="bt_wrap">
                                    <c:choose>
                                    <c:when test = "${user_id == null }">
                                        <a href="${pageContext.request.contextPath}/member/beforeLogin" class="on">등록</a>
                                    </c:when>
                                    	<c:when test = "${user_id != null }">
                                            <a href="${pageContext.request.contextPath}/getWriteBoard" class="on">등록</a>
                                    	</c:when>
                                     </c:choose>
                                </div>

                            </div>
                        </div>

                        <!-- Footer Start -->
                        <jsp:include page="../common/footer.jsp" flush="true">
                            <jsp:param name="footer" value="푸터호출" />
                        </jsp:include>
                        <!-- Footer End -->


                        <!-- JavaScript Libraries -->
                        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                        <script
                            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                        <!-- Chart.js-->
                        <script src="<c:url value = '/js/wow.min.js' />"></script>
                    </body>

                    </html>