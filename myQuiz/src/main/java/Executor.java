import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import utilities.PrepareQuiz;
import vo.Quiz;

public class Executor
{

	public static void main(String[] args)
	{
		//writeJSON();
		readJSON();
	}
	
	private static void readJSON()
	{
		try
		{
			Quiz quiz = PrepareQuiz.convertJSONToObject();
			System.out.println(quiz.getQuestions().get(0).getQuestionDesc());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void writeJSON()
	{
		try
		{
			System.out.println(PrepareQuiz.convertObjectToJSONString(PrepareQuiz.prepareQuestions()));
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}