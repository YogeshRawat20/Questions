package com.questions.pojo;

import java.sql.Date;

public class Questions {
	int qId;
	String qText;
	int qtId;
	String qData;
	int[] correctAnswer;
	int spId;
	Date createdTime;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqText() {
		return qText;
	}
	public void setqText(String qText) {
		this.qText = qText;
	}
	public int getQtId() {
		return qtId;
	}
	public void setQtId(int qtId) {
		this.qtId = qtId;
	}
	public String getqData() {
		return qData;
	}
	public void setqData(String qData) {
		this.qData = qData;
	}
	public int[] getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int[] correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
