package com.bbtutorials.users.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bbtutorials.dto.AuthData;
import com.bbtutorials.dto.EstablishmentInfo;
import com.bbtutorials.dto.ScheduleData;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;

@Component
public class UsersService {
	
	private UsersRepository usersRepository;
    WebClient webClient = WebClient.create("https://apitest.encaixe.me");

    EstablishmentInfo establishmentInfo = null;
	AuthData authData = null;
	public String reasonOption = "";
	ScheduleData[] responseJsonSchedules = null;
	public ScheduleData selectedSchedule = null;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    
    public Users saveUser(Users users) {
    	return usersRepository.save(users);
    }
    
    public EstablishmentInfo getEstablishment(String name) {
    	establishmentInfo = webClient.get()
                .uri("/establishments/"+name+"/info")
                .exchange()
                .block()
                .bodyToMono(EstablishmentInfo.class)
                .block();
    	
    	return establishmentInfo;
    }
    
    public ScheduleData[] showSchedules(int establishmentId, int category, int service, int payment) {
    	responseJsonSchedules = webClient.get()
                .uri("/establishments/"+establishmentId+"/schedules?value="+payment+"&reason="+category+"&serviceId="+service)
				/* .header("Authorization", authData.token) */
                .exchange()
                .block()
                .bodyToMono(ScheduleData[].class)
                .block();
    			


    			System.out.println(establishmentInfo);
    			System.out.println(authData);
    			System.out.println(responseJsonSchedules);



        return responseJsonSchedules;
    }

}
