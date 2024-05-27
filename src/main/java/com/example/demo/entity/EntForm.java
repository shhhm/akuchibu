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
		}
		else if ("B".equals(choice)) {
			sampleDao.incrementCountForOptionB();
		}
		
		return "redirect:/thankyou"; // 送信後のページにリダイレクト
	}

}
