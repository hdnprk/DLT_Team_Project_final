package com.dlt.senior.survey.dao;

import org.apache.ibatis.annotations.Param;

import com.dlt.senior.survey.model.GraphVO;


public interface IGraphRepository {

	GraphVO getResults(@Param("gender") String gender, @Param ("age") String age);
}
