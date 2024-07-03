package com.dlt.senior.survey.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dlt.senior.survey.model.SurveyVO;
import com.dlt.senior.survey.service.IGraphService;
import com.dlt.senior.survey.service.IScoreService;

@Controller
public class SurveyController {

	@Autowired
	IGraphService graphService;
	@Autowired
	IScoreService scoreService;
	
	@GetMapping(value="survey")
	public String index() {
		return "survey/survey";
	}
	
	//설문조사 결과 저장, 결과 계산
	@PostMapping(value="survey/surveyInsertScore")
	@ResponseBody
	public Map<String,Object> saveResult(@RequestBody SurveyVO vo) {
			System.out.println("Recieved SurveyVO :" + vo);
			scoreService.insertSurvey(vo);
			
			return scoreService.calculateResults(vo);
	}

	//그래프 나타냄
	@PostMapping(value = "survey/surveyGraph")
	@ResponseBody
	public Map<String, Object> getGraphInfo(@RequestBody Map<String, String>params) {
		String gender = params.get("gender");
		String age = params.get("age");
		
	    // 디버깅용 로그
	    System.out.println("Received gender: " + gender);
	    System.out.println("Received age: " + age);

	    return graphService.generateGraphInfo(gender, age);
	}

}