package com.ajit.xml.vo;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	private String question;
	private List<Label> labelopt = new ArrayList<Label>();
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void add(Label entry) {
		labelopt.add(entry);
	}

	public List<Label> getContent() {
	        return labelopt;
	}
	
	
}
