package com.example.demo.form;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dao.SampleDao;

@Controller
public class AkuchibuController {
	private final SampleDao sampleDao;

	public AkuchibuController(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@RequestMapping("/top")
	public String chat() {
		return "top";
	}

	@PostMapping("/a")
	public String handleFormSubmission(@RequestParam("choice") String choice,
			@RequestParam(value = "other", required = false) String other, Model model) {
		switch (choice) {
		case "A":
			sampleDao.incrementCountForOptionA();
			return "a";
		case "B":
			sampleDao.incrementCountForOptionB();
			return "b";
		case "C":
			sampleDao.incrementCountForOptionC();
			return "c";
		case "D":
			sampleDao.incrementCountForOptionD();
			return "d";
		case "E":
			sampleDao.incrementCountForOptionE();
			return "e";
		case "F":
			sampleDao.incrementCountForOptionF();
			return "f";
		case "G":
			sampleDao.incrementCountForOptionG();
			return "g";
		case "H":
			sampleDao.incrementCountForOptionH();
			return "h";
		case "I":
			if (other == null || other.trim().isEmpty()) {
				model.addAttribute("error", "コメントを入力してください。");
				return "top"; // エラーメッセージを表示するトップページに戻る
			}
			model.addAttribute("message", other);
			return "i";
		default:
			return "top"; // デフォルトビュー
		}
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMissingParams(MissingServletRequestParameterException ex, Model model) {
		model.addAttribute("error", "選択してください。");
		return "top"; // エラーメッセージを表示するトップページに戻る
	}

	@RequestMapping("/complete")
	public String complete() {
		return "complete";
	}

	@RequestMapping("/results")
	public String showSurveyResults(Model model) {
		Map<String, Integer> surveyResults = getSurveyResultsMap();
		model.addAttribute("surveyResults", surveyResults);
		return "view"; // view.htmlテンプレートを返す
	}

	private Map<String, Integer> getSurveyResultsMap() {
		Map<String, Integer> surveyResults = new LinkedHashMap<>();
		surveyResults.put("外部研修", sampleDao.getCountForOption("外部研修"));
		surveyResults.put("内部研修", sampleDao.getCountForOption("内部研修"));
		surveyResults.put("部署説明", sampleDao.getCountForOption("部署説明"));
		surveyResults.put("パソコン", sampleDao.getCountForOption("パソコン"));
		surveyResults.put("打刻", sampleDao.getCountForOption("打刻"));
		surveyResults.put("体調不良", sampleDao.getCountForOption("体調不良"));
		surveyResults.put("有給", sampleDao.getCountForOption("有給"));
		surveyResults.put("忌引き", sampleDao.getCountForOption("忌引き"));
		return surveyResults;
	}
}
