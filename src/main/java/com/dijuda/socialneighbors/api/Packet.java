
package com.dijuda.socialneighbors.api;

import org.json.JSONObject;

public class Packet {
	
  private String endPoint;

  private JSONObject payLoad;
	
	private String method;

  public Packet (String endPoint, String method, JSONObject payLoad) {
		this.endPoint = "/" + endPoint;
		this.method = method;
		this.payLoad = payLoad;

  }

	public String endPoint () {
		return endPoint;	
	}
	
	public String method () {
		return method;
	}

	@Override
	public String toString () {
		return payLoad.toString();
	}

}
