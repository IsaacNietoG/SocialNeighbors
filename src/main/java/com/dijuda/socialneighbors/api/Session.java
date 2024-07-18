
package com.dijuda.socialneighbors.api;

import com.dijuda.socialneighbors.social.User;
import java.util.Optional;

public class Session {

  private String token;

  private User user;
	
	public Session (String token) {
		this.token = token;
		this.user = null; //Manager.APICommunicator.getCommunicator();
	}
	
	public User getUser () {
		return user;
	}
	
} 
