package com.dijuda.socialneighbors.api;

import org.json.JSONObject;// Replace 'some.package' with the actual package name of JSONStructure

public class Packet {
  
  private String endPoint;

  private JSONObject payLoad;

  public Packet (String endPoint, JSONObject payLoad) {

  }

  public JSONObject getPayLoad() {
    return payLoad;
  } 

}
