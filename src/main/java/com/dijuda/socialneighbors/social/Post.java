
package com.dijuda.socialneighbors.social;

import com.dijuda.socialneighbors.social.interactions.*;

public class Post implements Commentable, Likeable {

  private String id;

  public Post () {

  }

  @Override
  public void like(){

  }

  @Override
  public Iterable<User> viewLikes() {
    return null;
  }  

  @Override
  public void comment() {

  }
 
  @Override
  public Iterable<Comment> viewComments(){
    return null;    
  }  
  
}
