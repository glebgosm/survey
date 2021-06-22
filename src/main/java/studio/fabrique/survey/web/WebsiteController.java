package studio.fabrique.survey.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.fabrique.survey.dao.SurveyDAO;
import studio.fabrique.survey.model.Question;
import studio.fabrique.survey.model.QuestionType;
import studio.fabrique.survey.model.Survey;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class WebsiteController {

    @Autowired
    private SurveyDAO surveyDAO;

    public WebsiteController(SurveyDAO surveyDAO) {
        this.surveyDAO = surveyDAO;
        Question q1 = new Question(QuestionType.TEXT, "Question1?");
        Question q2 = new Question(QuestionType.TEXT, "Question2?");
        List<Question> questions = new ArrayList<>();
        Collections.addAll(questions, q1, q2);
        surveyDAO.createSurvey("Survey1",
                LocalDate.now(),
                LocalDate.now().plus(1, ChronoUnit.DAYS),
                "Description",
                questions);
    }

    @GetMapping("/surveys")
    public Iterable<Survey> getSurveys() {
        return surveyDAO.getSurveys();
    }


}
