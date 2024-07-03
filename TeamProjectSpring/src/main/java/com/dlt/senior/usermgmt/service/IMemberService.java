package com.dlt.senior.usermgmt.service;

import com.dlt.senior.usermgmt.model.MemberVO;

public interface IMemberService {
	public MemberVO getLogin(MemberVO vo);
	public void setRegister(MemberVO vo);
}
