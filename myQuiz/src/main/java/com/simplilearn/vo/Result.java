package com.simplilearn.vo;

public class Result
{
	private String questionID;
	private String questionDesc;
	private String userAnswer;
	private String correctAnswer;
	private String isCorrectAns;
	
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
	public String getUserAnswer()
	{
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer)
	{
		this.userAnswer = userAnswer;
	}
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer)
	{
		this.correctAnswer = correctAnswer;
	}
	public String getIsCorrectAns()
	{
		return isCorrectAns;
	}
	public void setIsCorrectAns(String isCorrectAns)
	{
		this.isCorrectAns = isCorrectAns;
	}
	
	
}
