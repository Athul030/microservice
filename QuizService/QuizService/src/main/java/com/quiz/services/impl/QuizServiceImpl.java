package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repo.QuizRepo;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepo quizRepo;

    private final QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

//    @Override
//    public List<Quiz> get() {
//
//        List<Quiz> quizzes =  quizRepo.findAll();
//        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
//            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//            return quiz;
//        }).collect(Collectors.toList());
//        return newQuizList;
//    }

    @Override
    public List<Quiz> get(){
        List<Quiz> quizzes  = quizRepo.findAll();
        quizzes.stream().forEach(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId())));
        return quizzes;
    }

    @Override
    public Quiz get(Long id) {

        Quiz quiz = quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(id));
        return quiz;
    }
}
