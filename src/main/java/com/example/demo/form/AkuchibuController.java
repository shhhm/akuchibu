package com.example.demo.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.SampleDao;


@Controller
public class AkuchibuController {
	
	private final SampleDao sampleDao;
	
	public AkuchibuController(SampleDao sampleDao){
		this.sampleDao = sampleDao;
	}

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
		sampleDao.incrementCountForOptionA();
		return "a";
	}

	
	@RequestMapping("/b")
	public String b() {
		sampleDao.incrementCountForOptionB();
		return "b";
	}
	
	@RequestMapping("/c")
	public String c() {
		sampleDao.incrementCountForOptionC();
		return "c";
	}
	
	@RequestMapping("/d")
	public String d() {
		sampleDao.incrementCountForOptionD();
		return "d";
	}
	
	@RequestMapping("/e")
	public String e() {
		sampleDao.incrementCountForOptionE();
		return "e";
	}
	
	@RequestMapping("/f")
	public String f() {
		sampleDao.incrementCountForOptionF();
		return "f";
	}
	
	@RequestMapping("/g")
	public String g() {
		sampleDao.incrementCountForOptionG();
		return "g";
	}

	@RequestMapping("/h")
	public String h() {
		sampleDao.incrementCountForOptionH();
		return "h";
	}
	
	
	@PostMapping("/submitSurvey")
    public String submitSurvey(@RequestParam("choice") String choice) {
        // アンケート結果をサービスに渡して処理
      //  surveyService.processSurveyResult(choice);
        return "redirect:/thankyou"; // 送信後のページにリダイレクト
    }

}
