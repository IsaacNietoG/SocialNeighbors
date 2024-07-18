
package com.dijuda.socialneighbors.api;

import org.json.JSONObject;

import com.dijuda.socialneighbors.social.interactions.Comment;

import java.util.Optional;

public class PacketFactory {
 
	public Packet login (String email, String password) {
		return 
			new Packet("login",	credentialsJSON(email, password));
	}
	
	public Packet register (String email, String password, String name, String apartment, Optional<String> familyID) {
		return 
			new Packet ("register",  credentialsJSON(email, password)
					.put ("name", name)
					.put ("apartment", apartment)
					.put ("familyID", familyID.orElse(""))
					);
	}

	public Packet like (String postID) {
		return 
			new Packet("like", new JSONObject()
					.put("postID", postID));
	}
	
	public Packet comment (Comment comment) {
		//Not finished
		return 
			new Packet ("comment", new JSONObject());
//				.put("text", comment.getText())
//					.put("postID", comment.getPost()));
	} 


	//Private Methods

	private JSONObject credentialsJSON (String email, String password) {
		return new JSONObject()
					.put ("email", email)
					.put ("password", password);
	}

 
}
