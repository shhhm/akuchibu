package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public SampleDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertSurveyResult(String choice) {
		jdbcTemplate.update("INSERT INTO survey_result (choice) VALUES (?)", choice);
	}

	public void incrementCountForOptionA() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 1");
	}

	public void incrementCountForOptionB() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 2");
	}

	public void incrementCountForOptionC() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 3");
	}

	public void incrementCountForOptionD() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 4");
	}
	
	public void incrementCountForOptionE() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 5");
	}
	
	public void incrementCountForOptionF() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 6");
	}
	
	public void incrementCountForOptionG() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 7");
	}
	
	public void incrementCountForOptionH() {
		jdbcTemplate.update("UPDATE survey_result SET count = count + 1 WHERE id = 8");
	}
}
