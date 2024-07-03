package com.dlt.senior.policy.service;

import java.util.List;

import com.dlt.senior.policy.model.PolicyVO;

public interface IWelfareService {
	List<PolicyVO> getWelfare(PolicyVO vo);
    List<PolicyVO> getSocial();
    List<PolicyVO> getMarket();
    List<PolicyVO> getPublic(PolicyVO vo);
}
