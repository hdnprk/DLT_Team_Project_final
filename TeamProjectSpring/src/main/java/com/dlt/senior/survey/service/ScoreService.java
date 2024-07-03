package com.dlt.senior.survey.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlt.senior.survey.dao.IScoreRepository;
import com.dlt.senior.survey.model.SurveyVO;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	IScoreRepository score;

	@Override
	public void insertSurvey(SurveyVO vo) {

		int maxSeq = score.getMaxSeq(); 
		vo.setSEQ(maxSeq);

		score.insertSurvey(vo);
	}

	@Override
	public Map<String, Object> calculateResults(SurveyVO vo) {
	        int health1 = Integer.parseInt(vo.getHealth1()) * 20;
	        int health2 = Integer.parseInt(vo.getHealth2()) * 20;
	        int health3 = Integer.parseInt(vo.getHealth3()) * 20;
	        int economy1 = Integer.parseInt(vo.getEconomy1()) * 20;
	        int economy2 = Integer.parseInt(vo.getEconomy2()) * 20;
	        int economy3 = Integer.parseInt(vo.getEconomy3()) * 20;
	        int social1 = Integer.parseInt(vo.getSocial1()) * 20;
	        int social2 = Integer.parseInt(vo.getSocial2()) * 20;
	        int social3 = Integer.parseInt(vo.getSocial3()) * 20;

	        int totHth = (health1 + health2 + health3) / 3;
	        int totEco = (economy1 + economy2 + economy3) / 3;
	        int totRel = (social1 + social2 + social3) / 3;
	        int totScore = (totHth + totEco + totRel) / 3;

	        Map<String, Object> response = new HashMap<String, Object>();
	        response.put("totScore", totScore);
	        response.put("totHth", totHth);
	        response.put("totEco", totEco);
	        response.put("totRel", totRel);
			return response;

	    }

}
