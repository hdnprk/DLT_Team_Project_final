<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>DLT - survey</title>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href = "<c:url value = '/css/survey.css' /> " rel = "stylesheet">
	<link href = "<c:url value = '/css/button.css' /> " rel = "stylesheet">
</head>
    


<body>    
	<!-- Navbar Start -->
	<jsp:include page="../common/navi.jsp" flush="true"> 
		<jsp:param name="navi" value="네비호출" />
	</jsp:include>
	<!-- Navbar End -->


			<div id="contain">
        	<div class="jumbotron text-center">
                <h1>"당신의 삶의 만족도는 어떠신가요?"</h1>
                <div class="textBox">
	                <p>이 설문 조사는 노년층의 삶의 질을 이해하고 향상 시키기 위해 마련 되었습니다.
	                </p>
            </div>
            </div>
            <!-- google survey start -->
            	<div id="section2">
                <div class="survey">
                	<div class="main">
                    	<h1>삶의 만족도를 확인 해 보세요</h1>
                		</div>
	
                <div class="form">
                    <form class="surveyform" method="post" encType="UTF-8" name="surveyform" id="surveyform">

                        <table class="commontable">

                            <!-- 공통 질문 테이블 시작 -->
                            <tr class="questionTitle">
                                <th colspan="2">
                                    <h2><b>공통질문</b></h2>
                                </th>
                            </tr>

                            <tr>
                                <td class="question">1. 귀하의 성별을 선택 해주세요. </td>

                                <td class="answer">
                                    <label><input type="radio" name="GENDER" value="F"> 여자</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="GENDER" value="M"> 남자</label>
                                </td>
                            </tr>


                            <tr>
                                <td class="question">2. 귀하의 연령대가 어떻게 되십니까? </td>

                                <td class="answer">
                                    <label><input type="radio" name="AGE" value="1"> 65~69세</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="AGE" value="2"> 70~74세</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="AGE" value="3"> 75~79세</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="AGE" value="4"> 80~84세</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="AGE" value="5"> 85세 이상</label>
                                </td>
                            </tr>


                            <tr>
                                <td class="question">3. 거주지가 어디 십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="REGION" value="1" >서울</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="REGION" value="2">전남</label>&nbsp;&nbsp;
                                </td>
                            </tr>
                        </table>
                        <!-- 공통 질문 테이블 끝. -->


                        <!-- 건강 만족도 질문 테이블 시작 -->
                        <table class="healthtable">

                            <tr class="questionTitle">
                                <th colspan="2">
                                    <h2><b>건강 상태에 대한 만족도 조사</b></h2>
                                </th>
                            </tr>


                            <tr>
                                <td class="question">1. 귀하의 건강 상태에 대한 만족도는 어떠십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="HEALTH1" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH1" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH1" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH1" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH1" value="1"> 매우 불만족</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">2. 귀하께서는 자신의 평소 건강 상태가 어떻다고 생각 하십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="HEALTH2" value="5" checked> 매우 건강</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH2" value="4"> 건강</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH2" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH2" value="2"> 나쁨</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH2" value="1"> 매우 나쁨</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">3. 일주일에 며칠 운동을 하십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="HEALTH3" value="5" checked> 매일</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH3" value="4"> 3~5회</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH3" value="3"> 1~2회</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH3" value="2"> 안한다</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="HEALTH3" value="1"> 못한다 (건강상의 이유)</label>
                                </td>
                            </tr>
                        </table>
                        <!-- 건강 만족도 질문 테이블 끝 -->

                        <!-- 경제적 만족도 질문 테이블 시작 -->
                        <table class="economicstable">

                            <tr class="questionTitle">
                                <th colspan="2">
                                    <h2><b>경제 상황에 대한 만족도 조사</b></h2>
                                </th>
                            </tr>


                            <tr>
                                <td class="question">1. 현재의 소득 수준에 대해 어떻게 생각 하십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="ECONOMY1" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY1" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY1" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY1" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY1" value="1"> 매우 불만족</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">2. 주거 환경에 대한 만족도는 어떠십니까?</td>
                                <td class="answer">
                                    <label><input type="radio" name="ECONOMY2" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY2" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY2" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY2" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY2" value="1"> 매우 불만족</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">3. 여가 및 문화 생활을 위한 경제적 여유에 대해 어떻게 생각 하십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="ECONOMY3" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY3" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY3" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY3" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="ECONOMY3" value="1"> 매우 불만족</label>
                                </td>
                            </tr>
                        </table>
                        <!-- 경제적 만족도 질문 테이블 끝 -->

                        <!-- 사회 관계 만족도 질문 테이블 시작-->
                        <table class="relationshiptable">

                            <tr class="questionTitle">
                                <th colspan="2">
                                    <h2><b>사회적 관계에 대한 만족도 조사</b></h2>
                                </th>
                            </tr>


                            <tr>
                                <td class="question">1. 가족과의 관계에 대한 만족도는 어떠십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="SOCIAL1" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL1" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL1" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL1" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL1" value="1"> 매우 불만족</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">2. 친구 및 이웃과의 관계에 대해 어떻게 생각 하십니까?</td>

                                <td class="answer">
                                    <label><input type="radio" name="SOCIAL2" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL2" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL2" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL2" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL2" value="1"> 매우 불만족</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="question">3. 가족이나 친구로부터의 정서적 지원에 대한 만족도는 어떠십니까?</td>
                                <td class="answer">
                                    <label><input type="radio" name="SOCIAL3" value="5" checked> 매우 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL3" value="4"> 만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL3" value="3"> 보통</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL3" value="2"> 불만족</label>&nbsp;&nbsp;
                                    <label><input type="radio" name="SOCIAL3" value="1"> 매우 불만족</label>
                                </td>
                            </tr>
                        </table><br><br>
                        <!-- 사회 관계 만족도 질문 테이블 끝 -->

                        <button type="button" class="policyBtn" value="제출" id="policySubmit">제출</button><br><br><br>
                    </form>
                </div>
            </div>
        </div>
		</div>
    <!-- 만족도 조사 끝 -->

    <!-- 만족도 조사 결과 화면 시작 -->
    <form method="post">
        <div id="section3">
        <div class="satisfactionBOX">
            <br><br>
            <P>당신의 <b>삶의 만족도</b>는 [<span id="score0"></span>]점 입니다. </P><br><br>


            <p class="score_box">건강 상태 만족도<br> <span id="score1"></span>점</p>
            <p class="score_box">경제적 만족도 <br> <span id="score2"></span>점</p>
            <p class="score_box">사회적 관계 만족도<br> <span id="score3"></span>점</p><br><br><br>

            <button class="policyBtn" type="submit" id="graphSubmit">평균 그래프 보기</button><br><br><br>
        </div>
    </div><br><br><br>
    </form>
    
    <!-- 만족도 조사 결과 그래프 화면 -->
    <div id="section4">
    <div class="graph">
    	<div class="chartContainer">
            	<canvas id="myChart"></canvas>
				<canvas id="yourChart"></canvas><br><br><br>
		</div>
		
		<br><br><br>

            <p>▼당신에게 필요한 정책은?▼</p>
            <button class="policyBtn" type="submit">정책 보기</button><br><br><br>
    </div>
    </div>
    <!-- 그래프 끝 --> 
   



	<!-- Footer Start -->
	<jsp:include page="../common/footer.jsp" flush="true">
		<jsp:param name="footer" value="푸터호출" />
	</jsp:include>
	<!-- Footer End -->
	
 <script src = "<c:url value = '/js/survey.js'/>"></script>
</body>
</html>