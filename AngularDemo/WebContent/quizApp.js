/**
 * 
 */
// global variables
var correctAnswer = 0;
var userAnswer = -1;
var currentQuestion = 0;
var userScores = new Array();
var showQuizFlag = true;

var quizApp = angular.module('quizApp',[]);
quizApp.controller('QuizCtrl',function($scope,$http){
	
	// AJAX call to load quiz
	$http.get("answers.json").success(function(data){
		$scope.userChoice = -1;
		$scope.quiz = data;
		$scope.quiz.questions = shuffleArray($scope.quiz.questions);
		displayQuestion($scope.quiz.questions[currentQuestion]);
	}).error(function(){
		alert("failed to load quiz");
		console.log("failed to load quiz");
	});
	
	//event listeners
	$scope.SubmitAnswer = SaveAnswerPrintNextQuestion;
	$scope.Restart = NewGame;
	$scope.Scores = ShowScores;
	$scope.Help = ShowHelp;
	
	
	
	
	
	//store user answer and print next question
	function SaveAnswerPrintNextQuestion(){
		console.log("button press:"+currentQuestion);
		var delta = parseInt($scope.userChoice) - parseInt(correctAnswer);
		userScores[currentQuestion - 1] = (delta==0)?1:0;
		if (currentQuestion < $scope.quiz.questions.length){
			displayQuestion($scope.quiz.questions[currentQuestion]);
		} else {
			//end of the game
			ShowScores();
		}
		$scope.userChoice = -1; 
	};
	
	//display current user score
	function ShowScores(){
		if(showQuizFlag) {
			$scope.SubmitAnswer = null;
			$scope.usertotal = 0;
			angular.forEach(userScores, function(score){
				$scope.usertotal += parseInt(score);
			});
			$scope.maxtotal = $scope.quiz.questions.length;
			changeElementAttribute('#question-area','display','none');
			changeElementAttribute('#score-area','display','block');
			changeElementAttribute('#help-area','display','none');
			showQuizFlag = false;
		} else {
			//show current question
			$scope.SubmitAnswer = SaveAnswerPrintNextQuestion;
			displayQuestionArea();
			showQuizFlag = true;
		}
	};
	
	//quiz instructions
	function ShowHelp(){
		if (showQuizFlag){
			//show help menu
			$scope.SubmitAnswer = null;
			changeElementAttribute('#question-area','display','none');
			changeElementAttribute('#score-area','display','none');
			changeElementAttribute('#help-area','display','block');
			showQuizFlag = false;
		} else {
			//show current question
			$scope.SubmitAnswer = SaveAnswerPrintNextQuestion;
			displayQuestionArea();
			showQuizFlag = true;
		}
	};
	

	
	
	//start a new game
	function NewGame(){
		//reset flags and restore default settings
		displayQuestionArea();
		correctAnswer = 0;
		userAnswer = -1;
		currentQuestion = 0;
		userScores = new Array();
		showQuizFlag = true;
		// randomize quiz data
		$scope.userChoice = -1;
		$scope.quiz.questions = shuffleArray($scope.quiz.questions);
		displayQuestion($scope.quiz.questions[currentQuestion]);
	};
	
});

//helper functions

//reset display attributes
function displayQuestionArea() {
	changeElementAttribute('#question-area','display','block');
	changeElementAttribute('#score-area','display','none');
	changeElementAttribute('#help-area','display','none');
};

//change attribute values
function changeElementAttribute(elemID, attrName, attrVal) {
	var elem = angular.element(document.querySelector(elemID));
	elem.css(attrName, attrVal);
};

//format question to display
function displayQuestion(questionToDisplay) {
	// set the question
	var q = angular.element(document.querySelector('#question'));
	q.empty();
	var newQuestion = '<h3>' + questionToDisplay.question + '</h3>';
	q.append(newQuestion);

	// shuffle questions
	var answers = shuffleArray(questionToDisplay.answers);

	var count = 0;
	// add each answer to markup
	angular.forEach(answers, function(answer) {
		var elementID = "#a" + count;
		var divAnswer = angular.element(document.querySelector(elementID));
		divAnswer.empty();
		divAnswer.append(answer.answer);
		if (answer.correct === true) {
			correctAnswer = count;
		}
		// list.append(a);
		count++;
	});
	currentQuestion++;
};

//randomize question order
function shuffleArray(array){
	var count = array.length, t, i;
	// shuffle while elements remain
	while(count){
		i = Math.floor(Math.random()*count);
		count--;
		// swap elements
		t=array[count]
		array[count]=array[i];
		array[i] = t;
	}
	return array;
};