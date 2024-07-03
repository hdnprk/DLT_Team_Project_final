package com.dlt.senior.disease.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;

import com.dlt.senior.disease.model.DiseaseVO;

public interface IDiseaseRepository {
	List<DiseaseVO> getDistrictList(@Param("area") int area);
	List<DiseaseVO> getDiseaseData(@Param("district") int district);
}
