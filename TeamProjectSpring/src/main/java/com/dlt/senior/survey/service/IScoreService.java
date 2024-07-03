package com.dlt.senior.survey.service;



import java.util.Map;
import com.dlt.senior.survey.model.SurveyVO;


public interface IScoreService {

	void insertSurvey(SurveyVO vo);
	Map<String, Object> calculateResults(SurveyVO vo);
}
