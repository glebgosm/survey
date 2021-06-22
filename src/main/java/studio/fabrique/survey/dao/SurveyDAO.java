package studio.fabrique.survey.dao;

import org.springframework.stereotype.Component;
import studio.fabrique.survey.model.Question;
import studio.fabrique.survey.model.Survey;

import java.time.LocalDate;
import java.util.List;

@Component
public class SurveyDAO {
    private SurveyRepository surveyRepository;

    public SurveyDAO(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(String name, LocalDate startDate, LocalDate endDate, String description, List<Question> questions) {
        Survey survey = new Survey(name, startDate, endDate, description, questions);
        return surveyRepository.save(survey);
    }

    public Iterable<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

}
