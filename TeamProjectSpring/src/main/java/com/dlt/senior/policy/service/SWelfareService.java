package com.dlt.senior.policy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlt.senior.policy.dao.SWelfareRepository;
import com.dlt.senior.policy.model.PolicyVO;

@Service
public class SWelfareService implements IWelfareService {

	@Autowired
	SWelfareRepository welfare;
	
	@Override
	public List<PolicyVO> getWelfare(PolicyVO vo) {
		return welfare.getWelfare(vo);
	}

    @Override
    public List<PolicyVO> getSocial() {
        return welfare.getSocial();
    }

    @Override
    public List<PolicyVO> getMarket() {
        return welfare.getMarket();
    }

    @Override
    public List<PolicyVO> getPublic(PolicyVO vo) {
        return welfare.getPublic(vo);
    }

}
