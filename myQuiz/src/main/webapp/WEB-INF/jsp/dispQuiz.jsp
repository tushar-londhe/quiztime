<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QUIZ ENGINE</title>

<script type="text/javascript" src="<spring:url value="/resources/js/jquery-3.6.0.min.js" />"></script> 
<script type="text/javascript" src="<spring:url value="/resources/js/main.js"/>"></script>
<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

</head>
<body>


<div class="quiz">
<br/>
<div align="center" class="mainHeading">TODAY'S QUIZ</div>
<br/>
<form name="quizForm" action="reviewQuiz" method="post">
	<table style="width:100%">
		<tr>			
			<th>Question</th>			
		</tr>	
		<tr>
			<td>
				<input type="hidden" name="noOfQuestions" id="noOfQuestions" value="${questionList.size()}"/>
			</td>
		</tr>	
		<c:forEach var="question" items="${questionList}">		
			<tr>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${question.questionID}" />)
							<c:out value="${question.questionDesc}" />
						</b>
					</span>
				</td>
			</tr>
			<tr>
				<td>
					<c:forEach var="option" items="${question.options}">
						<input type="radio" name="question${question.questionID}" id="question${question.questionID}" value="${question.questionID}:${option.optionDesc}"><span style="font-family: courier">${option.optionDesc}</span><br/>						
					</c:forEach>										
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<input type="submit" name="btnSubmit" value="Review" onclick="return reviewQuiz()"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" name="textAnswers" id="textAnswers"/>
			</td>
		</tr>
			
	</table>
</form>
</div>


</body>
</html>