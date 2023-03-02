package net.mulaudzi.lds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mulaudzi.lds.model.Greeting;
import net.mulaudzi.lds.model.HelloMessage;
import net.mulaudzi.lds.service.WebSocketService;

@RestController
public class WebSocketRestController {
	@Autowired
	private WebSocketService webSocketService;
	
	@GetMapping("/test")
	public void test() {
		for(int i = 0; i < 100; i ++) {
			String message = "Count is "+ String.valueOf(i);
			/***Make sure to use the object that the main controller expects, it also has to specifically 
			 * be an object if you dont wanna strugle with spring failing to parse primitive types**/
			var helloMessage = new Greeting(message);
			webSocketService.notifyFrontend(helloMessage);
		}
	}
}
