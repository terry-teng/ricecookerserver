package com.knight.iot.ricecooker.services;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knight.iot.ricecooker.fcm.FcmClient;

@Service
public class FcmService {

	@Autowired
	private FcmClient fcmClient; 
	
	public void sendStringMessage(String token, String message) throws InterruptedException, ExecutionException {
		this.fcmClient.sendStringMessageByToken(token, message);
	}
	
}
