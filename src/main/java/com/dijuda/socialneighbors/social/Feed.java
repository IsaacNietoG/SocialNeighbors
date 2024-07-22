
package com.dijuda.socialneighbors.social;

import java.util.Iterator;

public class Feed implements Iterable<Post> {

    private class FeedIterator implements Iterator<Post> {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Post next() {
            return null;
        }

    }

    private User user;

    public Feed(User user) {
        this.user = user;
    }

    @Override
    public Iterator<Post> iterator() {
        return new FeedIterator();
    }


}

