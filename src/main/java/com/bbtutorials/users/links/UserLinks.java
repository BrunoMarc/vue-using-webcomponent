package com.bbtutorials.users.links;

import org.springframework.stereotype.Component;

@Component
public class UserLinks {
	
	public static final String GET_ESTABLISHMENT = "/establishment/{name}/info";
	public static final String GET_SCHEDULES = "/establishments/{establishment}/schedules";
	public static final String LIST_USERS = "/users";
    public static final String ADD_USER = "/user";

}
