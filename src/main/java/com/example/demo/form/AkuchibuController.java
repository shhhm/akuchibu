package com.example.demo.form;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SampleDao;

@Controller
public class AkuchibuController {

    private final SampleDao sampleDao;

    public AkuchibuController(SampleDao sampleDao) {
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

    @RequestMapping("/results")
    public String showSurveyResults(Model model) {
        Map<String, Integer> surveyResults = getSurveyResultsMap();
        model.addAttribute("surveyResults", surveyResults);
        return "view"; // view.htmlテンプレートを返す
    }

    private Map<String, Integer> getSurveyResultsMap() {
        Map<String, Integer> surveyResults = new HashMap<>();
        surveyResults.put("外部研修", sampleDao.getCountForOption("A"));
        surveyResults.put("内部研修", sampleDao.getCountForOption("B"));
        surveyResults.put("部署説明", sampleDao.getCountForOption("C"));
        surveyResults.put("パソコン", sampleDao.getCountForOption("D"));
        surveyResults.put("打刻", sampleDao.getCountForOption("E"));
        surveyResults.put("体調不良", sampleDao.getCountForOption("F"));
        surveyResults.put("有給", sampleDao.getCountForOption("G"));
        surveyResults.put("忌引き", sampleDao.getCountForOption("H"));
        return surveyResults;
    }
}
