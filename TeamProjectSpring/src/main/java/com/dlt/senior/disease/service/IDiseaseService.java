package com.dlt.senior.disease.service;

import java.util.List;

import org.json.JSONArray;

import com.dlt.senior.disease.model.DiseaseVO;

public interface IDiseaseService {
	public List<DiseaseVO> getDistrict(int area);
	public JSONArray getDiseaseData(int district);
}
