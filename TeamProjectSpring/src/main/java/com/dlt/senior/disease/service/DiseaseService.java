package com.dlt.senior.disease.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.senior.disease.dao.IDiseaseRepository;
import com.dlt.senior.disease.model.DiseaseVO;

@Service
public class DiseaseService implements IDiseaseService{
	
	@Autowired
	IDiseaseRepository diseaseRepository;
	
	@Override
	public List<DiseaseVO> getDistrict(int area) {
		List<DiseaseVO> list = diseaseRepository.getDistrictList(area);
		
		return list;
	}

	@Override
	public JSONArray getDiseaseData(int district) {
		List<DiseaseVO> list = diseaseRepository.getDiseaseData(district);
	    JSONArray jsonArray = new JSONArray();
	    for (DiseaseVO data : list) {
	        JSONObject jsonObject = new JSONObject(data); // DiseaseVO 객체를 JSONObject로 변환
	        jsonArray.put(jsonObject);
	    }
	    
		return jsonArray;
	}
	

}
