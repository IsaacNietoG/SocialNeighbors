

package com.dijuda.socialneighbors.social.interactions;

import com.dijuda.socialneighbors.social.User;

public interface Likeable {

  public void like ();

  public Iterable<User> viewLikes ();  

}	
