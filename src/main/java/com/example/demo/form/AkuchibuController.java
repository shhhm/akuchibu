package com.example.demo.form;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AkuchibuController {
	@RequestMapping("/")
	public String chat1() {
		return "chat1";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "chat2";
	}
	
	@RequestMapping("/test")
	public String chat() {
		return "chat3";
	}
	
	
	}
	

