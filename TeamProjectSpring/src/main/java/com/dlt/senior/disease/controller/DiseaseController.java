package com.dlt.senior.disease.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlt.senior.disease.model.DiseaseVO;
import com.dlt.senior.disease.service.IDiseaseService;

@Controller
public class DiseaseController {
    @Autowired
    ResourceLoader resourceLoader;
    
    @Autowired
    IDiseaseService diseaseService;
	
	//질병 페이지 이동
	@GetMapping("disease")
	public String getDiseasePage() {
		return "disease/diseaseService";
	}
	
	//차트 폴리곤 불러오기
	@GetMapping("diseasePolygon")
	@ResponseBody
	public ResponseEntity<String> getDiseasePolygon() {
		try {
			Resource resource = resourceLoader.getResource("classpath:/map.json");
            byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
            String jsonData = new String(bdata, StandardCharsets.UTF_8);
            return ResponseEntity.ok()
            .contentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
            .body(jsonData);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"File not found\"}");
		}

    }
	
	//차트 페이지 불러오기
	@GetMapping("diseaseChart")
	public String getChartPage(@RequestParam(name = "area") int area, Model model) {
		model.addAttribute("list", diseaseService.getDistrict(area));
		return "disease/diseaseChart"; 
	}
	
	//차트 불러오기
	@GetMapping("getDiseaseChart")
	@ResponseBody
	public ResponseEntity<String> getChartData(@RequestParam(name = "district") int district, Model model) {
		JSONArray jsonArray = diseaseService.getDiseaseData(district);
		return ResponseEntity.ok().body(jsonArray.toString());
	}
	
	//JSON 데이터를 받아오는 것까지 완료
}
