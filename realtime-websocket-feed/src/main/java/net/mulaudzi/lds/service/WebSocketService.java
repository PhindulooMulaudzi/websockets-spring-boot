package net.mulaudzi.lds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import net.mulaudzi.lds.model.Greeting;
import net.mulaudzi.lds.model.HelloMessage;

/***
 * The idea is to use a websocket service so that we can stream data without
 * having to wait for a message to be posted and then we reply.
 * 
 * @author Phindulo Mulaudzi
 *
 */

@Service
public class WebSocketService {
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	/****We can essentially pass in any object to the method and it will be sent*/
	public void notifyFrontend(Greeting message) {		
		/**it is important to specify the destiantion Arg1 and then pass the message object Arg2**/
		simpMessagingTemplate.convertAndSend("/topic/greetings", message);
	}
}
