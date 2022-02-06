package com.bbtutorials.users.controller;


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

import com.bbtutorials.dto.EstablishmentInfo;
import com.bbtutorials.dto.ScheduleData;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping(path = UserLinks.GET_ESTABLISHMENT)
    public ResponseEntity<?> getEstablishment(@PathVariable String name) {
        
        EstablishmentInfo resource = usersService.getEstablishment(name);
        return ResponseEntity.ok(resource);
    }
	
	@GetMapping(path = UserLinks.GET_SCHEDULES)
    public ResponseEntity<?> showSchedules(@PathVariable int establishment,
    		@RequestParam int category, @RequestParam int payment) {
        
		ScheduleData[] resource = usersService.showSchedules(establishment, category, payment);
        return ResponseEntity.ok(resource);
    }
	
	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = UserLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@RequestBody Users user) {
        Users resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }
}
