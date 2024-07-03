$(function(){
    $('#policySubmit').on("click", function (event) {
        event.preventDefault();

        var isAllAnswered = true;
        var commonQuestions = ['GENDER', 'AGE', 'REGION']; 

        for(var i = 0; i < commonQuestions.length; i++) {
            if(!$("input[name='" + commonQuestions[i] + "']:checked").val()) {
                isAllAnswered = false;
                break;
            }
        }
        
        if (!isAllAnswered) {
        	alert("제출 하시기 전에 모든 질문에 응답 해주세요.")
        	return;
        	}
        	
        var surveyData = {
            gender: $("input[name='GENDER']:checked").val(),
            age: $("input[name='AGE']:checked").val(),
            region: $("input[name='REGION']:checked").val(),
            health1: $("input[name='HEALTH1']:checked").val(),
            health2: $("input[name='HEALTH2']:checked").val(),
            health3: $("input[name='HEALTH3']:checked").val(),
            economy1: $("input[name='ECONOMY1']:checked").val(),
            economy2: $("input[name='ECONOMY2']:checked").val(),
            economy3: $("input[name='ECONOMY3']:checked").val(),
            social1: $("input[name='SOCIAL1']:checked").val(),
            social2: $("input[name='SOCIAL2']:checked").val(),
            social3: $("input[name='SOCIAL3']:checked").val()
        };
        
        $.ajax({
            url: "survey/surveyInsertScore",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(surveyData),
            dataType: 'json',
            success: function (response) {
                console.log(response);
                document.getElementById('score0').innerText = response.totScore;
                document.getElementById('score1').innerText = response.totHth;
                document.getElementById('score2').innerText = response.totEco;
                document.getElementById('score3').innerText = response.totRel;
                
                fnMove2();
            },
            error: function (request, status, error) {
                console.error(error); // 에러 메시지 출력
            }
        });
    });

    $('#graphSubmit').on("click", function (event) {
        event.preventDefault();

        var gender = $("input[name='GENDER']:checked").val();
        var age = $("input[name='AGE']:checked").val();
        
        fetch("survey/surveyGraph", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ "gender": gender, "age": age })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("응답이 없습니다.");
            }
            return response.json();
        })
        .then(response => {
        console.log(response);
            fnMove3();
            
            var totHth = document.getElementById('score1').innerText;
            var totEco = document.getElementById('score2').innerText;
            var totRel = document.getElementById('score3').innerText;
            
            var totHth2 = response.avgHth;
            var totEco2 = response.avgEco;
            var totRel2 = response.avgRel;
            
            fnMove4(totHth, totEco, totRel, totHth2, totEco2, totRel2);
        })
        .catch(error => {
            console.error(error); // 에러 메시지 출력
        });
    });
});

function fnMove2() {
    var offset = $("#section3").offset();
    $('html, body').animate({ scrollTop: offset.top - 100 }, 50);
}

function fnMove3() {
    var offset = $("#section4").offset();
    $('html, body').animate({ scrollTop: offset.top - 100 }, 50);
}

function fnMove4(totHth, totEco, totRel, totHth2, totEco2, totRel2) {
    var data1 = {
        labels: ['건강', '경제', '사회적 관계'],
        datasets: [{
            label: '나의 삶의 만족도 평균',
            data: [totHth, totEco, totRel],
            backgroundColor: ['red', 'orange', 'yellow'],
        }]
    };
    var ctx1 = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx1, {
        type: 'bar',
        data: data1,
        options: {}
    });

    var data2 = {
        labels: ['건강', '경제', '사회적 관계'],
        datasets: [{
            label: '나와 같은 연령대 삶의 만족도 평균',
            data: [totHth2, totEco2, totRel2],
            backgroundColor: ['red', 'orange', 'yellow'],
        }]
    };
    var ctx2 = document.getElementById('yourChart').getContext('2d');
    var yourChart = new Chart(ctx2, {
        type: 'bar',
        data: data2,
        options: {}
    });

    var charts = document.querySelectorAll('#myChart, #yourChart');
    
    charts.forEach(function(chart) {
        chart.style.maxWidth = '800px';
        chart.style.height = '600px';
        chart.style.margin = 'auto';
        chart.style.border = '2px solid #ccc';
        chart.style.boxShadow = '0 4px 8px rgba (0,0,0,0.1)';
        chart.style.backgroundColor = '#f9f9f9';
    });     
}

