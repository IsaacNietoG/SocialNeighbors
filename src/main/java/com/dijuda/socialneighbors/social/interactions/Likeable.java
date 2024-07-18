

package com.dijuda.socialneighbors.social.interactions;

import com.dijuda.socialneighbors.social.User;

public abstract class Likeable {

	private String postID;

  public void like () {
			
	}

  public <T extends User> Iterable<T> viewLikes () {	
		return null;		
	}

}	
