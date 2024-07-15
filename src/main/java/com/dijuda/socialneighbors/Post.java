
package com.dijuda.socialneighbors;

public class Post implements Commentable, Likeable {

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
  public Iterable<Comment> viewComments() {
    return null;    
  }  
}
