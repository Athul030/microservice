package com.question.services.impl;

import com.question.entities.Question;
import com.question.repo.QuestionRepo;
import com.question.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;


    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question Not found"));

    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {

        return questionRepo.findByQuizId(quizId);
    }
}
