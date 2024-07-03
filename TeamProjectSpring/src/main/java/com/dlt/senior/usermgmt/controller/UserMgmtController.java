package com.dlt.senior.usermgmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlt.senior.usermgmt.model.MemberVO;
import com.dlt.senior.usermgmt.service.IMemberService;

@Controller
@RequestMapping("/member")
public class UserMgmtController {

	@Autowired
	IMemberService memberService;
	
	//로그인 전 세션 URL 저장
	@GetMapping("/beforeLogin")
	public String storeURL(HttpServletRequest request, HttpSession session) { 
		String refererURL = (String) session.getAttribute("refererURL");
		if(refererURL == null) {
			refererURL = request.getHeader("Referer");
			session.setAttribute("refererURL", refererURL);
		}

		return "/usermgmt/login";	
	}
	
	//로그인
	@PostMapping("/login") 
	public String login(@ModelAttribute MemberVO vo, Model model, HttpSession session) {
		MemberVO loginVO = memberService.getLogin(vo);
		
		String refererURL = (String) session.getAttribute("refererURL");
		
		//로그인 실패
		if(loginVO.getName() == null) {
			return "/error/loginFail";
		}
		//로그인 성공
		else {
			session.setAttribute("user_id", loginVO.getUserId());
			session.setAttribute("user_name", loginVO.getName());
			
			return "redirect:" + (refererURL != null ? refererURL : "/index");
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		String refererURL = request.getHeader("Referer");
		session.invalidate();
		return "redirect:" + (refererURL != null ? refererURL : "/index");
	}
	
	//회원가입 페이지 이동
	@GetMapping("/register")
	public String getRegisterPage(HttpServletRequest request, HttpSession session) {
		String refererURL = (String) session.getAttribute("refererURL");
		if(refererURL == null) {
			refererURL = request.getHeader("Referer");
			session.setAttribute("refererURL", refererURL);
		}

		return "/usermgmt/registration";
	}
	
	@PostMapping("/register/input")
	public String register(@ModelAttribute MemberVO vo, HttpSession session) {
		memberService.setRegister(vo);
		return "redirect:" + (session.getAttribute("refererURL") != null ? session.getAttribute("refererURL") : "/index");
	}
}
