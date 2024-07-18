
package com.dijuda.socialneighbors.social;

import com.dijuda.socialneighbors.social.interactions.*;

public class Post extends Likeable implements Commentable {

  private String id;

  public Post () {

  }

  @Override
  public void comment() {

  }
 
  @Override
  public Iterable<Comment> viewComments(){
    return null;    
  }  
  
}
