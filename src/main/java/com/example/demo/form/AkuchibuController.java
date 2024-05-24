package com.example.demo.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AkuchibuController {
	@RequestMapping("/")
	public String top() {
		return "chat1";
	}
	}