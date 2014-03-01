package com.ajit.xml.vo;

import java.util.ArrayList;
import java.util.List;

public class Quizlevel {
	public List<Quizlist> quizlist = new ArrayList<Quizlist>();

	public void add(Quizlist entry) {
		quizlist.add(entry);
	}

	public List<Quizlist> getContent() {
	        return quizlist;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("<quiz_level>");
		int quixCount = 0;
		//<quiz><type>radio</type>
		//<question>How many flowers are below ? _s-img_flower_red.jpg,9_e-img_ </question>
		//<answer>4</answer>
		//<option1>1</option1>
		//<option2>4</option2>
		//<explanation>Correct answer is 9.</explanation></quiz>
		
		for(Quizlist quizlist : this.getContent()){
			for(Quiz quiz : quizlist.getContent()){
				String type = "";
				int answer = 0;
				int count = 0;
				StringBuffer strOption = new StringBuffer(); 
				//System.out.println(quiz.getQuestion());
				for(Label label : quiz.getContent()){
					count++;
					//System.out.println(label.toString());
					type = label.getType();
					
					//Answer
					if(answer == 0 && label.getValue().equalsIgnoreCase("I")){
						answer = count;
					}
					
					//option
					strOption.append("<option" + count + ">" + label.getLabeltext() + "</option" + count + ">");
						
				}
				str.append("<quiz>");
				str.append("<type>" + type + "</type>");
				str.append("<question>" + quiz.getQuestion() + "</question>");
				str.append("<answer>" + answer + "</answer>");
				str.append(strOption.toString());
				str.append("</quiz>");
				quixCount++;
			}
		}
		str.append("<quiz_level>");
		System.out.println("count : " + quixCount);
		return str.toString().replace("\t", " ").replace("\n", " ").replace("  ", " ") + "<!--"+quixCount+"-->";
	}
}
