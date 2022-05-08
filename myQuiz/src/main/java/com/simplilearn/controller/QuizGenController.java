package com.simplilearn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.utilities.PrepareQuiz;
import com.simplilearn.vo.Question;
import com.simplilearn.vo.Quiz;
import com.simplilearn.vo.Result;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class QuizGenController
{
	@RequestMapping(value = "/genQuiz", method = RequestMethod.GET)
	public String generateQuiz(Model model)
	{
		String forwardPage = "";
		try
		{
			Quiz quiz = PrepareQuiz.convertJSONToObject();
			model.addAttribute("questionList", quiz.getQuestions());
			forwardPage = "dispQuiz";
		}
		catch (IOException e)
		{
			e.printStackTrace();
			forwardPage = "error";
		}

		return forwardPage;
	}

	@RequestMapping(value = "/reviewQuiz", method = RequestMethod.POST)
	public String reviewQuiz(@RequestParam("textAnswers") String textAnswers, Model model)
	{
		String forwardPage = "results";
		Quiz quiz;
		Result result = null;
		int score = 0;

		try
		{
			quiz = PrepareQuiz.convertJSONToObject();
			
			HashMap<String, Question> questionsMap = new HashMap<String, Question>();
			ArrayList<Result> resultList = new ArrayList<Result>();
			
			for(Question quest : quiz.getQuestions())
			{
				questionsMap.put(quest.getQuestionID(), quest);
			}

			String[] ans = textAnswers.split(",");
			
			for(int i=0; i<ans.length; i++)
			{
				String[] questAns = ans[i].split(":");
				if(questAns[1].equals(questionsMap.get(questAns[0]).getCorrectAns()))
				{
					score++;
					result = new Result();
					result.setQuestionID(questionsMap.get(questAns[0]).getQuestionID());
					result.setQuestionDesc(questionsMap.get(questAns[0]).getQuestionDesc());
					result.setUserAnswer(questAns[1]);
					result.setCorrectAnswer(questionsMap.get(questAns[0]).getCorrectAns());
					result.setIsCorrectAns("Yes");					
				}
				else
				{
					result = new Result();
					result.setQuestionID(questionsMap.get(questAns[0]).getQuestionID());
					result.setQuestionDesc(questionsMap.get(questAns[0]).getQuestionDesc());
					result.setUserAnswer(questAns[1]);
					result.setCorrectAnswer(questionsMap.get(questAns[0]).getCorrectAns());
					result.setIsCorrectAns("No");					
				}
				
				resultList.add(result);
			}
			
			model.addAttribute("Result", resultList);
			model.addAttribute("score", score);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return forwardPage;
	}
}
