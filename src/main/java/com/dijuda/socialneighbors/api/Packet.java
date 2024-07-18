
package com.dijuda.socialneighbors.api;

import org.json.JSONObject;

public class Packet {
	
  private String endPoint;

  private JSONObject payLoad;

  public Packet (String endPoint, JSONObject payLoad) {
		this.endPoint = endPoint;
		this.payLoad = payLoad;
  }

	public String endPoint () {
		return endPoint;	
	}

	@Override
	public String toString () {
		return payLoad.toString();
	}

}
