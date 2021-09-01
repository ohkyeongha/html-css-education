package com.kitri.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping("/websocket")
	public String webSocket() {
		return "websocket";
	}
}
