package com.dlt.senior.life.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlt.senior.life.model.LifeExpectancyVO;
import com.dlt.senior.life.service.ILifeService;

@Controller
public class LifeController {

	@Autowired
	ILifeService lifeService;
	
	//기대 수명 페이지 불러오기
	@GetMapping("life")
	public String getLifePage() {
		return "life/lifeService";
	}
	
	//개인 기대 수명 계산
	@PostMapping("lifeCalc")
	public ResponseEntity<Integer> getPersonalLife(@RequestBody Map<String,Object> sendData) {
        return ResponseEntity.ok()
        .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
        .body(lifeService.calcLife(sendData)); 
	}
	
	//미래 기대 수명
	@GetMapping("getLife/{regionFirst}/{regionSecond}/{yearStart}/{yearEnd}")
	@ResponseBody
	public ResponseEntity<String> getLife(@PathVariable String regionFirst,@PathVariable String regionSecond, @PathVariable int yearStart, @PathVariable int yearEnd){		
		String json = lifeService.getLife(regionFirst,regionSecond, yearStart, yearEnd);
        return ResponseEntity.ok()
        .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
        .body(json); 
	}
	
	//과거 기대 수명
	@GetMapping("getLife/{regionFirst}/{yearStart}/{yearEnd}")
	@ResponseBody
	public ResponseEntity<String> getLife(@PathVariable String regionFirst, @PathVariable int yearStart, @PathVariable int yearEnd){		
		String json = lifeService.getLife(regionFirst, yearStart, yearEnd);
        return ResponseEntity.ok()
        .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
        .body(json); 
	}
	
	
	
}
