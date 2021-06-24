package studio.fabrique.survey.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studio.fabrique.survey.dao.AnsweredSurveyDAO;
import studio.fabrique.survey.dao.SurveyDAO;
import studio.fabrique.survey.dto.SurveyDTO;
import studio.fabrique.survey.model.Question;

/**
 * Controller for admin requests
 */
@RestController
public class AdminController {

    private SurveyDAO surveyDAO;
    private AnsweredSurveyDAO answeredSurveyDAO;

    public AdminController(SurveyDAO surveyDAO, AnsweredSurveyDAO answeredSurveyDAO) {
        this.surveyDAO = surveyDAO;
        this.answeredSurveyDAO = answeredSurveyDAO;
    }

    /**
     * Add a new survey.
     * @param surveyDTO
     * @return Survey instance
     */
    @PostMapping(path="/surveys")
    public ResponseEntity createSurvey(@RequestParam("user") String username,
                                          @RequestParam("password") String password,
                                          @RequestBody SurveyDTO surveyDTO)
    {
        if (!isAdmin(username, password))
            return new ResponseEntity<String>("Access denied", HttpStatus.UNAUTHORIZED);
        for (Question q : surveyDTO.getQuestions())
            q.setId(null);
        surveyDAO.createSurvey(
                surveyDTO.getName(),
                surveyDTO.getStartDate(),
                surveyDTO.getEndDate(),
                surveyDTO.getDescription(),
                surveyDTO.getQuestions()
        );
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * Delete a survey.
     */
    @DeleteMapping("/surveys/{surveyId}")
    public ResponseEntity deleteSurvey(@PathVariable Long surveyId,
                                       @RequestParam("user") String username,
                                       @RequestParam("password") String password)
    {
        if (!isAdmin(username, password))
            return new ResponseEntity<String>("Access denied", HttpStatus.UNAUTHORIZED);
        surveyDAO.deleteSurvey(surveyId);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Change a survey.
     */
    @PostMapping("/surveys/{surveyId}")
    public ResponseEntity changeSurvey(@PathVariable Long surveyId,
                                       @RequestParam("user") String username,
                                       @RequestParam("password") String password,
                                       @RequestBody SurveyDTO surveyDTO)
    {
        if (!isAdmin(username, password))
            return new ResponseEntity<String>("Access denied", HttpStatus.UNAUTHORIZED);
        surveyDAO.changeSurvey(
                surveyId,
                surveyDTO.getName(),
                surveyDTO.getEndDate(),
                surveyDTO.getDescription(),
                surveyDTO.getQuestions()
        );
        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean isAdmin(String username, String password) {
        return "admin".equalsIgnoreCase(username) &&
               "admin".equalsIgnoreCase(password);
    }

}
























