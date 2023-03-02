package net.mulaudzi.lds.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import net.mulaudzi.lds.model.Greeting;
import net.mulaudzi.lds.model.HelloMessage;

/**
 * Create a controller to receive the hello message and send a greeting message.
 * GreetingController is mapped to handle messages to the endpoint /hello
 * @author Phindulo Mulaudzi
 *
 */
@Controller
public class GreetingController {
	
	@MessageMapping("/hello") /***Will handle all messages sent to /hello**/
	/***we set an application prefix in stomp to /app, this means to access this controller we go to /app/hello**/
	@SendTo("/topic/greetings") /***Will send the return type of its method to /topic/greetings **/
	public Greeting greeting(HelloMessage helloMessage) {
		/***our stomp broker is configured to use endpoint /topic**/
		/***anyone that connects to stop will subscribe to /topic**/
		/***return value is broadcast to all subscribers of /topic/greetings***/
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName())+"!");
	}
}
