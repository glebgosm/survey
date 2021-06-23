package studio.fabrique.survey.web;

import org.springframework.web.bind.annotation.*;
import studio.fabrique.survey.dao.AnsweredSurveyDAO;
import studio.fabrique.survey.dao.SurveyDAO;
import studio.fabrique.survey.dto.SurveyDTO;
import studio.fabrique.survey.model.Question;
import studio.fabrique.survey.model.QuestionType;
import studio.fabrique.survey.model.Survey;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AdminController {

    private SurveyDAO surveyDAO;
    private AnsweredSurveyDAO answeredSurveyDAO;

    public AdminController(SurveyDAO surveyDAO, AnsweredSurveyDAO answeredSurveyDAO) {
        this.surveyDAO = surveyDAO;
        this.answeredSurveyDAO = answeredSurveyDAO;
    }

    //@PostConstruct
    public void createTempSurveys() {
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

    /**
     * Add a new survey.
     * @param surveyDTO
     * @return Survey instance
     */
    @PostMapping(path="/surveys")
    public Survey createSurvey(@RequestBody SurveyDTO surveyDTO) {
        for (Question q : surveyDTO.getQuestions())
            q.setId(null);
        return surveyDAO.createSurvey(
                surveyDTO.getName(),
                surveyDTO.getStartDate(),
                surveyDTO.getEndDate(),
                surveyDTO.getDescription(),
                surveyDTO.getQuestions()
        );
    }

    /**
     * Delete a survey.
     */
    @DeleteMapping("/surveys/{surveyId}")
    public void deleteSurvey(@PathVariable Long surveyId) {
        surveyDAO.deleteSurvey(surveyId);
    }

    /**
     * Change a survey.
     */
    @PostMapping("/surveys/{surveyId}")
    public void changeSurvey(@PathVariable Long surveyId, @RequestBody SurveyDTO surveyDTO) {
        surveyDAO.changeSurvey(
                surveyId,
                surveyDTO.getName(),
                surveyDTO.getEndDate(),
                surveyDTO.getDescription(),
                surveyDTO.getQuestions()
        );

    }


}
























