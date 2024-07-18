
package com.dijuda.socialneighbors.api;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.dijuda.socialneighbors.api.exceptions.InvalidCredentialsException;

import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;

public class Manager {
		
	public static class APICommunicator {
		
		private Packet packet;

		private HttpResponse<String> response;

		private String token;
		
		private APICommunicator () {}

		public static APICommunicator getCommunicator () {
			return new APICommunicator();
		}
		
		public APICommunicator setToken (String token) {
			this.token = token;
			return this; 
		}

		public APICommunicator sendPacket (Packet packet) {
			this.packet = packet;
			try {
				this.response = HttpClient.newHttpClient().send(createRequest(packet), HttpResponse.BodyHandlers.ofString());
			} catch (IOException io) {
				//Send Notification to GUI
			} catch (InterruptedException ie) {
				//Send notification to GUI
				//Problems with API
			}
			return this;
		}
		
		public Optional<String> retrieveBody () {
			if (packet == null)
				throw new IllegalStateException("No packet has been sent");
			if (response == null)
				throw new NoSuchElementException("There was a problem sending your packet");
			if(response.statusCode() == 200)
				return Optional.of(response.body());
			return Optional.empty();
		}

		public boolean correctlySent () {
			if (packet == null)
				throw new IllegalStateException ("No packet has been sent");
			return response != null;
		}

		private HttpRequest createRequest (Packet packet) {
			return HttpRequest.newBuilder()
				.uri(URI.create("" + packet.endPoint()))
				.method("GET", HttpRequest.BodyPublishers.ofString(packet.toString()))
				.build();
		}

	}

	public boolean registerUser (String email, String password, String name, String department, String family) {
		boolean validData = validEmail(email) && password != null && name != null && department != null;
		if (!validData)
			return false;
		Packet registerPacket = new PacketFactory()
			.register(email, password, name, department, Optional.ofNullable(family));
		return APICommunicator.getCommunicator().sendPacket(registerPacket).correctlySent();
		//Maybe implement password security checker
	}

	public Session login (String email, String password) {
		String token = APICommunicator.getCommunicator()
			.sendPacket(new PacketFactory().login(email, password))
			.retrieveBody().orElseThrow(InvalidCredentialsException::new);
		return new Session (token);
	}

	private boolean validEmail (String email) {
		int atSign, dot;
		atSign = dot = 0;
		for(int i = 0; i < email.length(); ++i)
			switch (email.charAt(i)) {
				case '@':
					++atSign;
					break;
				case '.':
					++dot;
					break;
			}
		return (atSign == 1) && dot > 0;
	}

}

