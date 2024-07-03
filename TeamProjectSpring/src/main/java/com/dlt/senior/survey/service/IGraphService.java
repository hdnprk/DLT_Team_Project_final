package com.dlt.senior.survey.service;

import java.util.Map;
import com.dlt.senior.survey.model.GraphVO;


public interface IGraphService {

	GraphVO getResults(String gender, String age);
	Map<String, Object> generateGraphInfo(String gender, String age);
}
