package com.knight.iot.ricecooker.fcm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.threeten.bp.Duration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidConfig.Priority;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.knight.iot.ricecooker.RicecookerApplication;

@Component
public class FcmClient {
	
	private AndroidConfig androidConfig;
	private ApnsConfig apnsConfig;
	
	
	public FcmClient(FcmSettings settings) {
		Path p = Paths.get(settings.getServiceAccountFile());
		try(InputStream serviceAccount = Files.newInputStream(p)){
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
			FirebaseApp.initializeApp(options);
		}catch(IOException e) {
			RicecookerApplication.logger.error("init fcm", e);
		}
		
		this.androidConfig = AndroidConfig.builder()
				.setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey("personal")
				.setPriority(Priority.HIGH)
				.setNotification(AndroidNotification.builder().setTag("personal").build())
				.build();
		this.apnsConfig = ApnsConfig.builder().setAps(Aps.builder().setCategory("personal").setThreadId("personal").build()).build();
		
	}
	
	public void sendMessageByToken(String deviceToekn, Map<String,String> data)  throws InterruptedException, ExecutionException {

		Message message = Message.builder().putAllData(data).setToken(deviceToekn)
				.setApnsConfig(apnsConfig).setAndroidConfig(androidConfig)
				.setNotification(new Notification("Personal Message","A personal message!"))
				.build();
		
		String response = FirebaseMessaging.getInstance().sendAsync(message).get();
		System.out.println("Send message: " + response);
	}
	
	public void sendStringMessageByToken(String deviceToekn, String data)  throws InterruptedException, ExecutionException {

		Message message = Message.builder().putData("mymsg", data).setToken(deviceToekn)
				.setApnsConfig(apnsConfig).setAndroidConfig(androidConfig)
				.setNotification(new Notification("Personal Message","A personal message!"))
				.build();
		
		String response = FirebaseMessaging.getInstance().sendAsync(message).get();
		System.out.println("Send message: " + response);
	}
	
	

}
