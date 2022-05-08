package com.simplilearn.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplilearn.vo.Option;
import com.simplilearn.vo.Question;
import com.simplilearn.vo.Quiz;

public class PrepareQuiz
{
	public static Quiz prepareQuestions()
	{
		Quiz quiz = new Quiz();
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		ArrayList<Option> options1 = new ArrayList<Option>();
		ArrayList<Option> options2 = new ArrayList<Option>();
		ArrayList<Option> options3 = new ArrayList<Option>();
		
		/////////////////////////////////////////////////////////////////////////
		
		Option opt1 = new Option();
		opt1.setOptionID("100");
		opt1.setOptionDesc("3");
		
		Option opt2 = new Option();
		opt2.setOptionID("101");
		opt2.setOptionDesc("5");
		
		Option opt3 = new Option();
		opt3.setOptionID("102");
		opt3.setOptionDesc("2");
		
		Option opt4 = new Option();
		opt4.setOptionID("103");
		opt4.setOptionDesc("1");
				
		options1.add(opt1);
		options1.add(opt2);
		options1.add(opt3);
		options1.add(opt4);
		
		///////////////////////////////////////////////////////////////////////////
		
		Option opti1 = new Option();
		opti1.setOptionID("100");
		opti1.setOptionDesc("Sachin Tendulkar");
		
		Option opti2 = new Option();
		opti2.setOptionID("101");
		opti2.setOptionDesc("Ricky Ponting");
		
		Option opti3 = new Option();
		opti3.setOptionID("102");
		opti3.setOptionDesc("Brian Lara");
		
		Option opti4 = new Option();
		opti4.setOptionID("103");
		opti4.setOptionDesc("Sunil Gavaskar");
				
		options2.add(opti1);
		options2.add(opti2);
		options2.add(opti3);
		options2.add(opti4);
		
		///////////////////////////////////////////////////////////////////////////
		
		///////////////////////////////////////////////////////////////////////////
				
		Option option1 = new Option();
		option1.setOptionID("100");
		option1.setOptionDesc("Anil Kumble");
		
		Option option2 = new Option();
		option2.setOptionID("101");
		option2.setOptionDesc("Shane Warne");
		
		Option option3 = new Option();
		option3.setOptionID("102");
		option3.setOptionDesc("Glenn McGrath");
		
		Option option4 = new Option();
		option4.setOptionID("103");
		option4.setOptionDesc("Mutthaiah Murlidharan");
		
		options3.add(option1);
		options3.add(option2);
		options3.add(option3);
		options3.add(option4);
		
		///////////////////////////////////////////////////////////////////////////
		
		Question question1 = new Question();
		question1.setQuestionID("100");
		question1.setQuestionDesc("How many times India has won the World Cup ?");
		question1.setCorrectAns("2");		
		question1.setOptions(options1);
		
		
		Question question2 = new Question();
		question2.setQuestionID("101");
		question2.setQuestionDesc("Who has the highest number of centuries in Test Cricket");
		question2.setCorrectAns("Sachin Tendulkar");
		question2.setOptions(options2);
		
		
		Question question3 = new Question();
		question3.setQuestionID("102");
		question3.setQuestionDesc("Who has the highest number of wickets in Test Cricket");
		question3.setCorrectAns("Mutthaiah Murlidharan");
		question3.setOptions(options3);
			
		
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		
		quiz.setQuestions(questions);
		
		return quiz;
	}
	
	public static String convertObjectToJSONString(Quiz quiz) throws JsonProcessingException
	{
		ObjectMapper obj = new ObjectMapper();
		String quizString = obj.writeValueAsString(quiz);
		return quizString;
	}
	
	public static Quiz convertJSONToObject() throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper obj = new ObjectMapper();		
		Quiz quiz = obj.readValue(new File("E:\\Tushar\\my.office\\SIMPLILEARN\\COURSE-5\\workspace\\myQuiz\\src\\main\\webapp\\resources\\questions.json"), Quiz.class);
		return quiz;
	}
}
