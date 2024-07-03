package com.dlt.senior.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dlt.senior.policy.model.PolicyVO;
import com.dlt.senior.policy.service.IWelfareService;

@Controller
public class PolicyController {

	@Autowired
	IWelfareService welfareService;
	
	@GetMapping(value="policy")
	public String index() {
		return "policy/policy";
	}
	
    
	@GetMapping("/policy/job")
    public String getWelfare(@RequestParam("region_id") String regionId, Model model) {
        PolicyVO vo = new PolicyVO();
        vo.setRegionId(regionId);
        List<PolicyVO> publicDtos = welfareService.getPublic(vo);
        List<PolicyVO> socialDtos = welfareService.getSocial();
        List<PolicyVO> marketDtos = welfareService.getMarket();

        model.addAttribute("publicDtos", publicDtos);
        model.addAttribute("socialDtos", socialDtos);
        model.addAttribute("marketDtos", marketDtos);

        return "policy/seoulJob"; // policy/seoulJob.jsp 페이지로 이동
    }
	
	@GetMapping("/policy/social")
	public String getSocial(@RequestParam("region_id") String regionId, Model model) {
        PolicyVO vo = new PolicyVO();
        vo.setRegionId(regionId);
        List<PolicyVO> welfareDtos = welfareService.getWelfare(vo);

        model.addAttribute("welfareDtos", welfareDtos);

        return "policy/seoulWelfare"; // policy/seoulJob.jsp 페이지로 이동
	}
	
	   @GetMapping("/policy/life")
	   public String getLife(@RequestParam("region_id") String regionId, Model model) {
	      PolicyVO vo = new PolicyVO();
	      vo.setRegionId(regionId);
	      model.addAttribute("regionId", regionId);
	      
	      int region_Id = Integer.parseInt(regionId);
	      if (region_Id==1) {
	         return "policy/seoulLife";
	      }   else {
	         return "policy/jeonnamLife";
	      }
	   }
	   
	   @GetMapping("/policy/health")
	   public String getHealth(@RequestParam("region_id") String regionId, Model model) {
	      PolicyVO vo = new PolicyVO();
	      vo.setRegionId(regionId);
	      model.addAttribute("regionId", regionId);
	      
	      int region_Id = Integer.parseInt(regionId);
	      if (region_Id==1) {
	         return "policy/seoulHealth";
	      }   else {
	         return "policy/jeonnamHealth";
	      }
	   }
	
}
