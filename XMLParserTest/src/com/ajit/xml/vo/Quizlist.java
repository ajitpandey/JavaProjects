package com.ajit.xml.vo;

import java.util.ArrayList;
import java.util.List;

public class Quizlist {
	public List<Quiz> quiz = new ArrayList<Quiz>();

	public void add(Quiz entry) {
		quiz.add(entry);
	}

	public List<Quiz> getContent() {
	        return quiz;
	}
	
	
}
