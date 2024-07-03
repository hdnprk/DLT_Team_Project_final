<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>DLT_커뮤니티 글 작성</title>
                    <link href = "<c:url value = '/css/css.css' /> " rel = "stylesheet">  

                    <link rel="stylesheet"
                        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
                        crossorigin="anonymous">
      				<link href = "<c:url value = '/css/style.css' /> " rel = "stylesheet">           
                </head>

                <body>
                    <!-- Navbar Start -->
                    <jsp:include page="../common/navi.jsp" flush="true">
                        <jsp:param name="navi" value="네비호출" />
                    </jsp:include>
                    <!-- Navbar End -->


                    <form method="post" action="writeBoard" name = "writeForm"  onsubmit="return writeCheck()">
                        <div id="conatain" class="board_wrap">
                            <div class="board_title">
                                <strong>DLT 커뮤니티</strong>
                                <p>질문하고 소통하는 공간! 커뮤니티에 오신것을 환영합니다.</p>
                            </div>
                            <div class="board_write_wrap">
                                <div class="board_write">
                                    <div class="title">
                                        <dl>
                                            <dt>제목</dt>
                                            <dd><input type="text" placeholder="제목 입력" name="boardTitle" id = "boardTitle"></dd>
                                        </dl>
                                    </div>
                                    <div class="info">
                                        <dl>
                                            <dt>작성자</dt>
                                            <c:if test = "${user_name != null }">                                        
                                                <dd>
                                                	${user_name }
                                                </dd>
                                            </c:if>
                                        </dl>
                                    </div>
                                    <div class="cont">
                                        <textarea id="summernote" name="boardContent"></textarea>
                                    </div>
                                </div>
                                <!--URL 이동-->
                                <div class="bt_wrap">
                                <button type="submit" id="onBtn">등록</button>
                                 <a href="${pageContext.request.contextPath}/boardList/1">취소</a>
                                </div>
                            </div>
                        </div>
                    </form>

                    <!-- Footer Start -->
                    <jsp:include page="../common/footer.jsp" flush="true">
                        <jsp:param name="footer" value="푸터호출" />
                    </jsp:include>
                    <!-- Footer End -->

                    <!-- JavaScript Libraries -->
                    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
					<script src = "<c:url value = '/js/write.js'/>"></script>                    
                </body>

                </html>