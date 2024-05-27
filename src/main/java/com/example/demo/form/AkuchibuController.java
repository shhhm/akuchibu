package com.example.demo.form;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AkuchibuController {
	@RequestMapping("/")
	public String chat1() {
		return "chat1";
	}
	
	@RequestMapping("/chat2")
	public String top() {
		return "chat2";
	}
	
	@RequestMapping("/top")
	public String chat() {
		return "top";
	}
	
	@RequestMapping("/a")
	public String a() {
		return "a";
	}
	
	
	}
	

