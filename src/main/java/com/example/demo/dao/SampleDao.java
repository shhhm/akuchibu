package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {
	private final JdbcTemplate db;

	@Autowired
	public SampleDao(JdbcTemplate db) {
		this.db = db;
	}

	public void insertSurveyResult(String choice) {
		db.update("INSERT INTO survey_result (choice) VALUES (?)", choice);
	}

	public void incrementCountForOptionA() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 1");
	}

	public void incrementCountForOptionB() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 2");
	}

	public void incrementCountForOptionC() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 3");
	}

	public void incrementCountForOptionD() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 4");
	}

	public void incrementCountForOptionE() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 5");
	}

	public void incrementCountForOptionF() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 6");
	}

	public void incrementCountForOptionG() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 7");
	}

	public void incrementCountForOptionH() {
		db.update("UPDATE survey_result SET count = count + 1 WHERE id = 8");
	}
}