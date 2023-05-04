package com.exam.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Question;
import com.exam.model.Quiz;
import com.exam.service.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionOfQuizadmin(@PathVariable("qid") Long qid) {
		Quiz quiz = new Quiz();
		quiz.setqId(qid);
		Set<Question> questionOfQuiz = this.service.getQuestionOfQuiz(quiz);
		return ResponseEntity.ok(questionOfQuiz);

	}

	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.service.getQuestion(quesId);
	}
	
	
	//eval-quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity evalQuiz(@RequestBody List<Question> questions)
	{
		double marksGot =0;
		int correctAnswers = 0;
		int attempted =0;
		for(Question q : questions ) {
			
			Question question= this.service.getQuestion(q.getQuesid());
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				
				correctAnswers++;
				
				double marksSingle = Double.parseDouble(question.getQuiz().getMaxMarks())/questions.size();
				
				marksGot+=marksSingle;
				
			}
			
			if(q.getGivenAnswer()!=null)
			{
				attempted++;
			}
			
		}
		
		Map<String, Object> map= Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}
	
	
	
}
