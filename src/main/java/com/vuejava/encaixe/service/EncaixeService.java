package com.vuejava.encaixe.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.vuejava.dto.AuthData;
import com.vuejava.dto.EstablishmentInfo;
import com.vuejava.dto.ScheduleData;

@Component
public class EncaixeService {
	
    WebClient webClient = WebClient.create("https://apitest.encaixe.me");

    EstablishmentInfo establishmentInfo = null;
	AuthData authData = null;
	public String reasonOption = "";
	ScheduleData[] responseJsonSchedules = null;
	public ScheduleData selectedSchedule = null;
    
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
