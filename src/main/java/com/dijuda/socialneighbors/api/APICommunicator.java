
package com.dijuda.socialneighbors.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class APICommunicator {
		
		private final String APILINK = "";

		private Packet packet;
	
		private JSONObject response;

		private int responseCode;

		public APICommunicator (Packet packet) {
			this.packet = packet;
		}
	
		public boolean sendPacket () {		
			HttpResponse<String> response; 		
			try {
				response = HttpClient.newHttpClient()
				.send(buildRequest(packet).build(), HttpResponse.BodyHandlers.ofString());	
			}	catch (Exception e) {
				return false;
			}
			this.responseCode = response.statusCode();
			this.response = new JSONObject(response.body());
			return true;
		}

		public int getResponseCode () {
			return responseCode;
		}

		public String get (String key) {
			if (response == null)
				throw new IllegalStateException();
			return response.getString(key);
		}

		//protected
	
		protected HttpRequest.Builder buildRequest (Packet packet) {
			return HttpRequest.newBuilder()
				.uri(getLink())
				.method(packet.method(), HttpRequest.BodyPublishers.ofString(packet.toString()));
		}

		protected URI getLink() {
			return URI.create(APILINK + packet.endPoint());
		}  

	}
