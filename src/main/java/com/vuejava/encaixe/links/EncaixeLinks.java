package com.vuejava.encaixe.links;

import org.springframework.stereotype.Component;

@Component
public class EncaixeLinks {
	
	public static final String GET_ESTABLISHMENT = "/establishment/{name}/info";
	public static final String GET_SCHEDULES = "/establishments/{establishment}/schedules";

}
