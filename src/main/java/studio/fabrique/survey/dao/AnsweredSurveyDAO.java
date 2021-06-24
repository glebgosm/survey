package studio.fabrique.survey.dao;

import org.springframework.stereotype.Component;
import studio.fabrique.survey.model.Answer;
import studio.fabrique.survey.model.AnsweredSurvey;
import studio.fabrique.survey.model.User;

import java.util.List;

@Component
public class AnsweredSurveyDAO {
    private AnsweredSurveyRepository answeredSurveyRepository;
    private UserDAO userDAO;

    public AnsweredSurveyDAO(AnsweredSurveyRepository answeredSurveyRepository, UserDAO userDAO) {
        this.answeredSurveyRepository = answeredSurveyRepository;
        this.userDAO = userDAO;
    }

    public AnsweredSurvey createAnsweredSurvey(Long surveyId, Long userId, List<Answer>answers) {
        User user =  (userId == null) ? null : userDAO.findById(userId);
        if (user == null) userId = Long.valueOf(userDAO.createNewUser());
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
