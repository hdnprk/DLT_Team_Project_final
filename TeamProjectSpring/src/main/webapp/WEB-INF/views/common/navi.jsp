<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <body>
 <!-- Navbar Start -->
    <nav id="topnav" class="navbar navbar-expand-lg bg-white navbar-light px-4 px-lg-5">
        <a href="${pageContext.request.contextPath}" class="navbar-brand d-flex align-items-center" id="mainLogoBox">
            <img src = "<c:url value = '/img/logo.png'/>">
        </a>
        <button type="button" class="navbar-toggler me-0" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <!-- <a href="index.html" class="nav-item nav-link active">Home</a> -->
                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="map.jsp" id="navbarDropdownGroup1" role="button"
                        data-bs-toggle="dropdown">
                        건강·정책
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/disease">질병 정보</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/policy">정책</a>
                    </div>
                </div>

                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="lifeService.jsp" id="navbarDropdownGroup1" role="button"
                        data-bs-toggle="dropdown">
                        삶의 질 분석
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/life">기대수명 예측</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/survey">당신의 만족도는?</a>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/boardList/1" class="nav-item nav-link">커뮤니티</a>
                                <c:choose>
                <c:when test = "${user_id == null}">
					<a href = "${pageContext.request.contextPath}/member/beforeLogin" class="nav-item nav-link">로그인</a>						
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/member/logout" class="nav-item nav-link">로그아웃</a>
				</c:otherwise>
				</c:choose>
            </div>
        </div>
    </nav>
    <!-- Navbar End -->
    </body>
</html>