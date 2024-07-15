package com.dijuda.socialneighbors.api;

import java.util.Optional;

public class AccountFactory {

  public class Register extends PacketFactory {

    private String name;

    public Register (String name, String aprtment, String email, String password, Optional<String> familyID) {
      
    }

    @Override 
    public Packet build () {
      


      return new Packet("register", null);
    }

  }

  public class LogIn extends PacketFactory {

    private String email;

    private String password;

    public LogIn (String name, String password) {
      
    }

    @Override 
    public Packet build () {
      return null;
    }

  }

}
