package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.SampleDao;

@Controller
public class EntForm {
	private final SampleDao sampleDao;

	@Autowired
	public EntForm(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@PostMapping("/submit")
	public String submitForm(@RequestParam("choice") String choice) {
		// アンケート結果をデータベースに追加
		sampleDao.insertSurveyResult(choice);
		// Aが送信された場合にAのカウントをインクリメント
		if ("外部研修".equals(choice)) {
			sampleDao.incrementCountForOptionA();
		} else if ("内部研修".equals(choice)) {
			sampleDao.incrementCountForOptionB();
		} else if ("部署説明".equals(choice)) {
			sampleDao.incrementCountForOptionC();
		} else if ("PCロック".equals(choice)) {
			sampleDao.incrementCountForOptionD();
		} else if ("打刻".equals(choice)) {
			sampleDao.incrementCountForOptionE();
		} else if ("体調不良".equals(choice)) {
			sampleDao.incrementCountForOptionF();
		} else if ("有給".equals(choice)) {
			sampleDao.incrementCountForOptionG();
		} else if ("忌引き".equals(choice)) {
			sampleDao.incrementCountForOptionH();
		}
		return "redirect:/thankyou"; // 送信後のページにリダイレクト
	}
}