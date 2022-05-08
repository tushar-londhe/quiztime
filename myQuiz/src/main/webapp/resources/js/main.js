/**
 * 
 */

function reviewQuiz()
{
	var strAnswers='';
	var noOfQuestions = document.getElementById('noOfQuestions').value;
	flag = false;
	
	ctr=100;
	
	for(var i=0; i<noOfQuestions; i++)
	{
		$("input:radio[name=question"+ctr+"]:checked").each(function(){
    	strAnswers = strAnswers + $(this).val() + ',';		
		});
		
		++ctr;	
	}
	flag = true;	
	document.getElementById('textAnswers').value=strAnswers;
	
	return flag;
}