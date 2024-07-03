package com.dlt.senior.survey.dao;

import com.dlt.senior.survey.model.SurveyVO;

public interface IScoreRepository {
	
	int getMaxSeq();
	void insertSurvey(SurveyVO vo);
	
}
