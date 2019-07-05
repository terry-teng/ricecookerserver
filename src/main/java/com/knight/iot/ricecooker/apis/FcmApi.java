package com.knight.iot.ricecooker.apis;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knight.iot.ricecooker.services.FcmService;

@RestController
public class FcmApi {

	@Autowired
	private FcmService fcmService;
	
	//private String testToken = "ea6V-t68ayw:APA91bFXg9fP2JCfi5LaOesBek5i6asZZrQ0L18Rh7T-myNTkpgyE6xQurKmQFp7vLVfQlalfYt_7S0LcP-ATieJTi6XAC6E3NsWq4tGVhQhvERKteMYCRSDqtyyr4feLQJehj59q0tH";
	private String testToken ="eJD6dZv8DP0:APA91bGGKLviocJT6uJxONWETbsMdFzZcvRKe5kI4xAe3-sAt_cUKO9gJ_Lyk2sj2k7WZ2DQ9cVAklknMX9wIb88QiKxf3dlIep-GOi1b_9PwBX7-W2NTQqqMzpS9S8Bx-4-eEDbdb0S";
	
	@GetMapping(value="/send")
	public void sendStringMessage(@RequestParam(name="message") String message) {
		try {
			fcmService.sendStringMessage(testToken, message);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/updatetesttoken")
	public void updateTestToken(@RequestParam(name="token") String token) {
		this.testToken = token;
	}
	
	@GetMapping(value="/gettesttoken")
	public String getTestToken() {
		return this.testToken;
	}
	
	
}
