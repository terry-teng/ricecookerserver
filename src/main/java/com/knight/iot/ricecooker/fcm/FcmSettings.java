package com.knight.iot.ricecooker.fcm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="fcm")
@Component
public class FcmSettings {
	
	private String serviceAccountFile;

	public String getServiceAccountFile() {
		return serviceAccountFile;
	}

	public void setServiceAccountFile(String serviceAccountFile) {
		this.serviceAccountFile = serviceAccountFile;
	}
	
	

}
