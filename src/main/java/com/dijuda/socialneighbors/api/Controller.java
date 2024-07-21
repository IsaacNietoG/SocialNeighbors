
package com.dijuda.socialneighbors.api;

import com.dijuda.socialneighbors.api.exceptions.FailedRequestException;
import com.dijuda.socialneighbors.api.exceptions.InvalidCredentialsException;
import com.dijuda.socialneighbors.api.exceptions.InvalidInformationException;

public class Controller {
		
	public void registerUser 
		(String email, String password, String name, String apartment, String familyID) throws InvalidInformationException {
		if(!validEmail(email) || null == name || null == password || null == apartment) 
			throw new InvalidInformationException();
		Packet registerPacket = new PacketFactory()
			.register(email, password, name, apartment, familyID);
		APICommunicator communicator = new APICommunicator(registerPacket);
		if(!communicator.sendPacket())
			throw new FailedRequestException();	
	}

	public Session login (String email, String password) {
		Packet logInPacket = new PacketFactory().login(email, password);	
		APICommunicator communicator = new APICommunicator (logInPacket);
		if (!communicator.sendPacket())
			throw new FailedRequestException();
		if (200 == communicator.getResponseCode())
			throw new InvalidCredentialsException();
		String token = communicator.get("token");
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
					dot += atSign > 1 ? 1 : 0;
					break;
			}
		return (atSign == 1) && dot > 0;
	}

}

