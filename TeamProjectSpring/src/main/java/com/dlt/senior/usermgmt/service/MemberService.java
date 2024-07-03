package com.dlt.senior.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dlt.senior.usermgmt.dao.IMemberRepository;
import com.dlt.senior.usermgmt.model.MemberVO;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	IMemberRepository memberRepository;

	@Override
	public MemberVO getLogin(MemberVO vo) {
		MemberVO test = memberRepository.getLogin(vo);

		
		//아이디가 조회가 안되는 경우
		if(test == null){
			vo.setName(null);
			return vo;
		}
		else {
			//비밀번호가 같음(로그인 성공)
			if(test.getUserPw().equals(vo.getUserPw())) {
				return test;
			}
			//비밀번호가 다름
			else {
				vo.setName(null);
				return vo;
			}
		}	
	}

	@Override
	public void setRegister(MemberVO vo) {
		memberRepository.setRegister(vo);
		
	}
	
	

}
