package com.dlt.senior.survey.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.senior.survey.dao.IGraphRepository;
import com.dlt.senior.survey.model.GraphVO;

@Service
public class GraphService implements IGraphService {

	@Autowired
	IGraphRepository graph;

	@Override
	public GraphVO getResults(String gender, String age) {
        GraphVO result = graph.getResults(gender, age);
        System.out.println("Result from repository: " + result);
		return result;
	}
	
	@Override
	public Map<String, Object> generateGraphInfo(String gender, String age) {
		GraphVO result2 = getResults(gender, age);
		
		if (result2 == null) {
			throw new IllegalStateException ("Result is null");
		}
		
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("avgHth", result2.getHealth());
        response.put("avgEco", result2.getEco());
        response.put("avgRel", result2.getRel());

        return response;
	}


}
