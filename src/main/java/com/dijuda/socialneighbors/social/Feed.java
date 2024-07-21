
package com.dijuda.socialneighbors.social;

import com.dijuda.socialneighbors.api.Session;
import java.util.Iterator;
import java.util.List;

public class Feed implements Iterable<Post> {

	private class FeedIterator implements Iterator<Post>{
		
		@Override
		public boolean hasNext () {		
			return true;		
		}


		@Override
		public Post next () {
			return null;
		}

	}

	private Session session;			

	public Feed (Session session) {
		this.session = session;
	}

  private List<Post> posts;

  @Override 
  public Iterator<Post> iterator(){
    return new FeedIterator();
  }


}

