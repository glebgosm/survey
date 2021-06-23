package studio.fabrique.survey.dao;

import org.springframework.stereotype.Component;
import studio.fabrique.survey.model.Answer;
import studio.fabrique.survey.model.AnsweredSurvey;

import java.util.List;

@Component
public class AnsweredSurveyDAO {
    private AnsweredSurveyRepository answeredSurveyRepository;

    public AnsweredSurveyDAO(AnsweredSurveyRepository answeredSurveyRepository) {
        this.answeredSurveyRepository = answeredSurveyRepository;
    }

    public AnsweredSurvey createAnsweredSurvey(Long surveyId, Long userId, List<Answer>answers) {
        AnsweredSurvey answeredSurvey = new AnsweredSurvey(surveyId, userId, answers);
        return answeredSurveyRepository.save(answeredSurvey);
    }

    public Iterable<AnsweredSurvey> getAnsweredSurveys(Long userId) {
        return answeredSurveyRepository.findByUserId(userId);
    }

    public AnsweredSurvey getAnsweredSurvey(Long userId, Long surveyId) {
        return answeredSurveyRepository.findByUserAndSurveyIds(userId, surveyId);
    }

}
