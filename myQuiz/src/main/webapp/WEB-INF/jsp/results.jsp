<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery-3.6.0.min.js" />"></script> 
<script type="text/javascript" src="<spring:url value="/resources/js/main.js"/>"></script>
<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

<meta charset="ISO-8859-1">
<title>RESULTS</title>
</head>
<body>

<div class="quiz">
<br/>
<div align="center" class="mainHeading">TODAY'S QUIZ RESULT</div>
<br/>
<form name="retakeQuiz" action="genQuiz" method="GET">
	<table style="width:100%">
		<tr>			
			<th>ID #</th>
			<th>Question</th>
			<th>User Answer</th>
			<th>Correct Answer</th>
			<th>Is your answer correct ?</th>			
		</tr>	
			
		<c:forEach var="result" items="${Result}">
			<tr>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${result.questionID}" />							
						</b>
					</span>
				</td>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${result.questionDesc}" />						
						</b>
					</span>
				</td>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${result.userAnswer}" />							
						</b>
					</span>
				</td>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${result.correctAnswer}" />						
						</b>
					</span>
				</td>
				<td>
					<span style="font-family: courier">
						<b>
							<c:out value="${result.isCorrectAns}" />							
						</b>
					</span>
				</td>		
							
			</tr>			
		</c:forEach>
			<tr>
				<td colspan="5" align="center">
					<span style="font-family: courier">
						<b>
							FINAL SCORE: <c:out value="${score}" />
						</b>
					</span>
				</td>
			</tr>
			<tr>
				<td colspan="5" align="center">
					<input type="submit" name="btnHome" value="Retake Quiz .." />
				</td>
			</tr>
	</table>	
</form>
</div>

</body>
</html>