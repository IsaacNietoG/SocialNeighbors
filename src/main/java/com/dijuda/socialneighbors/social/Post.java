
package com.dijuda.socialneighbors.social;

import java.util.Optional;

public class Post {

	private final Post fatherPost;

  private final String postID;

	private String content;

	public Post (Post fatherPost, String text ) {
		this.fatherPost = fatherPost;
		this.content = text;
		this.postID = null;
	}
	
  public Post (String text) {
		this(null, text);
  }
	
	public String getPostID () {
		return postID;
	}
	
	public Optional <Post> getFatherPost () {
		return Optional.ofNullable (fatherPost); 
	}
	
	public String getContent () {
		return content;
	}

}
