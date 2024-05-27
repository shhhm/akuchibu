package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SurveyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void processSurveyResult(String choice) {
        // アンケート結果をデータベースに追加
        insertSurveyResult(choice);
        // Aが選択された場合、Aのカウントをインクリメント
        if ("外部研修".equals(choice)) {
            incrementCountForOptionA();
            
        }
        else if ("B".equals(choice)) {
            incrementCountForOptionB();
        }
        // 他の選択肢に対する処理をここに追加
    }

    private void insertSurveyResult(String choice) {
        jdbcTemplate.update("INSERT INTO survey_result (choice) VALUES (?)", choice);
    }

    private void incrementCountForOptionA() {
        jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 1");
    }
    
    private void incrementCountForOptionB() {
        jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 2");
    }
}
