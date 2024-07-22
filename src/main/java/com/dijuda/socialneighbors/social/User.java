
package com.dijuda.socialneighbors.social;

import com.dijuda.socialneighbors.api.APICommunicator;
import com.dijuda.socialneighbors.api.Packet;
import com.dijuda.socialneighbors.api.PacketFactory;

import java.net.http.HttpRequest;
import java.util.HashMap;

public class User {

    private class UserCommunicator extends APICommunicator {

        public UserCommunicator(Packet packet) {
            super(packet);
        }

        @Override
        protected HttpRequest.Builder buildRequest(Packet packet) {
            return super.buildRequest(packet).header("auth", token);
        }

    }

    private String token;

    private HashMap<String, String> info;

    public User(String token) {
        this.token = token;
        setInfo();
    }

    public void getProfilePicture() {

    }

    public void getInfo(User user) {

    }

    public void post(String content) {
        Post myPost = new Post(content);
        sendPacketAuto(new PacketFactory().post(myPost));
    }

    public void comment(Post fatherPost, String content) {
        Post comment = new Post(fatherPost, content);
        sendPacketAuto(new PacketFactory().comment(comment));
    }

    public void like(Post post) {
        sendPacketAuto(new PacketFactory().like(post));
    }

    //Private

    private void sendPacketAuto(Packet packet) {
        UserCommunicator uc = new UserCommunicator(packet);
        uc.sendPacket();
    }

    private void setInfo() {


    }

}
