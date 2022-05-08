package com.simplilearn.vo;

import java.util.ArrayList;

public class Question 
{
	private String questionID;
	private String questionDesc;
	private ArrayList<Option> options;
	private String correctAns;
	
	public String getQuestionID()
	{
		return questionID;
	}
	public void setQuestionID(String questionID)
	{
		this.questionID = questionID;
	}
	public String getQuestionDesc()
	{
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc)
	{
		this.questionDesc = questionDesc;
	}
	public ArrayList<Option> getOptions()
	{
		return options;
	}
	public void setOptions(ArrayList<Option> options)
	{
		this.options = options;
	}
	public String getCorrectAns()
	{
		return correctAns;
	}
	public void setCorrectAns(String correctAns)
	{
		this.correctAns = correctAns;
	}	
}