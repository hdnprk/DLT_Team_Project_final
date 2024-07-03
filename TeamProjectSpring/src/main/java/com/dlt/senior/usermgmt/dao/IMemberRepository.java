package com.dlt.senior.usermgmt.dao;

import com.dlt.senior.usermgmt.model.MemberVO;

public interface IMemberRepository {
	MemberVO getLogin(MemberVO vo);
	void setRegister(MemberVO vo);
}
