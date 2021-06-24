package studio.fabrique.survey.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.survey.dao.AnsweredSurveyDAO;
import studio.fabrique.survey.dao.SurveyDAO;
import studio.fabrique.survey.dto.AnsweredSurveyDTO;
import studio.fabrique.survey.model.AnsweredSurvey;
import studio.fabrique.survey.model.Survey;

/**
 * Controller for user requests
 */
@RestController
public class UserController {

    private SurveyDAO surveyDAO;
    private AnsweredSurveyDAO answeredSurveyDAO;

    public UserController(SurveyDAO surveyDAO, AnsweredSurveyDAO answeredSurveyDAO) {
        this.surveyDAO = surveyDAO;
        this.answeredSurveyDAO = answeredSurveyDAO;
    }

    /**
     * Get all available surveys.
     * @return
     */
    @GetMapping("/surveys")
    public Iterable<Survey> getSurveys() {
        return surveyDAO.getSurveys();
    }

    /**
     * Get surveys completed by the user.
     * @param userId user id
     * @return
     */
    @GetMapping("/completed_surveys/{userId}")
    public Iterable<AnsweredSurvey> getAnsweredSurveys(@PathVariable Long userId) {
        return answeredSurveyDAO.getAnsweredSurveys(userId);
    }

    /**
     * Save answered survey.
     * @param answeredSurveyDTO
     */
    @PostMapping("/completed_surveys")
    public ResponseEntity<?> sendAnsweredSurvey(@RequestBody AnsweredSurveyDTO answeredSurveyDTO){
        answeredSurveyDAO.createAnsweredSurvey(
                answeredSurveyDTO.getSurveyId(),
                answeredSurveyDTO.getUserId(),
                answeredSurveyDTO.getAnswers());
        return new ResponseEntity<String>("Thank you for your answers!", HttpStatus.CREATED);
    }

}
