package com.dijuda.socialneighbors.api;

import com.dijuda.socialneighbors.social.Post;
import org.json.JSONObject;

public class PacketFactory {

    public Packet login(String email, String password) {
        return new Packet("login", "GET", credentialsJSON(email, password));
    }

    public Packet register(String email, String password, String username, String name, String place) {
        return new Packet("register", "POST", credentialsJSON(email, password).put("username", username).put("name", name).put("apartment", place));
    }

    public Packet like(Post post) {
        return new Packet("like", "POST", new JSONObject().put("postID", post.getPostID()));
    }

    public Packet unlike(Post post) {
        Packet like = like(post);
        like.setMethod("DELETE");
        return like;
    }

    public Packet comment(Post comment) {
        String endPoint = "comment";
        return new Packet(endPoint, "POST", postJSON(endPoint, comment).put("fatherPostID", comment.getFatherPost().orElseThrow().getPostID()));
    }

    public Packet post(Post post) {
        String endPoint = "post";
        return new Packet(endPoint, "POST", postJSON(endPoint, post));
    }

    //Private Methods

    private JSONObject postJSON(String endPoint, Post post) {
        return new JSONObject().put("content", post.getContent());
    }

    private JSONObject credentialsJSON(String email, String password) {
        return new JSONObject().put("email", email).put("password", password);
    }


}
