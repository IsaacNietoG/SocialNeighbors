
package com.dijuda.socialneighbors.api;

import org.json.JSONObject;

import com.dijuda.socialneighbors.social.interactions.Comment;
import com.dijuda.socialneighbors.social.interactions.Likeable;


public class PacketFactory {
 
	public Packet login (String email, String password) {
		return 
			new Packet("login", "GET"	,credentialsJSON(email, password));
	}
	
	public Packet register (String email, String password, String name, String place, String familyID) {
		JSONObject registerJSON = credentialsJSON(email, password)
					.put ("name", name)
					.put ("place", place);
		if(null == familyID)
			registerJSON.put ("familyID", familyID);
		return
			new Packet ("register", "POST", registerJSON);
	}

	public Packet like (Likeable likeable) {
		return 
			new Packet("like", "POST" , new JSONObject()
					.put("postID", likeable.getPostID()));
	}
	
	public Packet comment (Comment comment) {
		//Not finished
		return
			new Packet ("comment", "POST" ,new JSONObject());
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
