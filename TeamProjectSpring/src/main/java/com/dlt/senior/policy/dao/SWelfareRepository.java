package com.dlt.senior.policy.dao;

import java.util.List;

import com.dlt.senior.policy.model.PolicyVO;

public interface SWelfareRepository {
	List<PolicyVO> getWelfare(PolicyVO vo);
    List<PolicyVO> getSocial();
    List<PolicyVO> getMarket();
    List<PolicyVO> getPublic(PolicyVO vo);
}
