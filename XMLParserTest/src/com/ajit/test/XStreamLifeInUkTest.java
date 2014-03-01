package com.ajit.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ajit.xml.vo.Config;
import com.ajit.xml.vo.Item;
import com.ajit.xml.vo.Label;
import com.ajit.xml.vo.Labeltext;
import com.ajit.xml.vo.Quiz;
import com.ajit.xml.vo.Quizlevel;
import com.ajit.xml.vo.Quizlist;
import com.thoughtworks.xstream.XStream;

public class XStreamLifeInUkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//toXMl();
		fromXMl();

	}

	private static void toXMl() {
		XStream xstream = new XStream();
		xstream.alias("quizlevel", Quizlevel.class);
		xstream.alias("quizlist", Quizlist.class);
		xstream.alias("quiz", Quiz.class);
		xstream.alias("label", Label.class);
		xstream.addImplicitCollection(Quiz.class, "labelopt");
		xstream.addImplicitCollection(Quizlevel.class, "quizlist");
		xstream.addImplicitCollection(Quizlist.class, "quiz");
		xstream.useAttributeFor(Label.class, "type");
		xstream.useAttributeFor(Label.class, "value");
		
		
		Quizlevel quizlevel = new Quizlevel();
		//1st Quizlist
		Quizlist quizlist = new Quizlist();
		
		Quiz quiz = new Quiz();
		quiz.setQuestion("Quesion1");
		
		Label label = new Label("radio", "I");
		label.setLabeltext("Option1");
		quiz.add(label);
		
		label = new Label("radio", "l");
		label.setLabeltext("Option2");
		quiz.add(label);
		
		quizlist.add(quiz);
		
		quizlevel.add(quizlist);
		
		
		//2nd Quizlist
		quizlist = new Quizlist();
		
		quiz = new Quiz();
		quiz.setQuestion("Quesion1");
		
		label = new Label("radio", "I");
		label.setLabeltext("Option1");
		quiz.add(label);
		
		label = new Label("radio", "l");
		label.setLabeltext("Option2");
		quiz.add(label);
		
		quizlist.add(quiz);
		
		quizlevel.add(quizlist);
		
		/*List<Quiz> quizesList = new ArrayList<Quiz>();
		
		Quiz quiz = new Quiz();
		quiz.setQuestion("Quesion1");
		
		Label label = new Label("radio", "I");
		label.setLabeltext("Option1");
		quiz.add(label);
		
		label = new Label("radio", "l");
		label.setLabeltext("Option2");
		quiz.add(label);
		
		quizesList.add(quiz);
		
		quiz = new Quiz();
		quiz.setQuestion("Quesion2");
		
		label = new Label("radio", "I");
		label.setLabeltext("Option1");
		quiz.add(label);
		quizesList.add(quiz);
		//quizlevel.add(quizesList);
		
		List<Quiz> quizesList2 = new ArrayList<Quiz>();
		Quiz quiz2 = new Quiz();
		quiz2.setQuestion("Quesion1");
		
		Label label2 = new Label("radio", "I");
		label2.setLabeltext("Option1");
		quiz2.add(label);
		
		label2 = new Label("radio", "l");
		label2.setLabeltext("Option2");
		quiz2.add(label);
		
		quizesList2.add(quiz2);
		//quizlevel.add(quizesList2);
		*/
		//xstream.(Quiz.class, "label");
		//xstream.registerConverter(new QuizConverter());
		String configStr = xstream.toXML(quizlevel);
		//String configStr = xstream.toXML(quiz);
		System.out.println(configStr);
	}

	private static void fromXMl() {
		XStream xstream = new XStream();
		xstream.alias("quizlevel", Quizlevel.class);
		xstream.alias("quizlist", Quizlist.class);
		xstream.alias("quiz", Quiz.class);
		xstream.alias("label", Label.class);
		xstream.addImplicitCollection(Quiz.class, "labelopt");
		xstream.addImplicitCollection(Quizlevel.class, "quizlist");
		xstream.addImplicitCollection(Quizlist.class, "quiz");
		xstream.useAttributeFor(Label.class, "type");
		xstream.useAttributeFor(Label.class, "value");
		
		
		Quizlevel quizlevel = (Quizlevel)xstream.fromXML(new File("LifeinUK_2.xml"));
		
		System.out.println(quizlevel);
		/*
		System.out.println(quizlevel.getQuizlist().size());
		for(Quiz quiz : quizlevel.getQuizlist()){
			System.out.println(quiz.getQuestion());
			for(Label label : quiz.getContent()){
				System.out.println(label.toString());
			}
		}*/
	}

}
