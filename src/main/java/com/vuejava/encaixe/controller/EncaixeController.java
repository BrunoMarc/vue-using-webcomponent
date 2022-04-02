package com.vuejava.encaixe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vuejava.dto.EstablishmentInfo;
import com.vuejava.dto.ScheduleData;
import com.vuejava.encaixe.links.EncaixeLinks;
import com.vuejava.encaixe.service.EncaixeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class EncaixeController {
	
	@Autowired
	EncaixeService encaixeService;
	
	@GetMapping(path = EncaixeLinks.GET_ESTABLISHMENT)
    public ResponseEntity<?> getEstablishment(@PathVariable String name) {
        
        EstablishmentInfo resource = encaixeService.getEstablishment(name);
        return ResponseEntity.ok(resource);
    }
	
	@GetMapping(path = EncaixeLinks.GET_SCHEDULES)
    public ResponseEntity<?> showSchedules(@PathVariable int establishment,
    		@RequestParam int category, @RequestParam int service, @RequestParam int payment, @RequestParam int agreementId) {
        
		ScheduleData[] resource = encaixeService.showSchedules(establishment, category, service, payment, agreementId);
        return ResponseEntity.ok(resource);
    }

}
