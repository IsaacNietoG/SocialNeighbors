
package com.dijuda.socialneighbors.social.interactions;

public interface Commentable {
	
	public void comment();

	public Iterable<Comment> viewComments();	

}
