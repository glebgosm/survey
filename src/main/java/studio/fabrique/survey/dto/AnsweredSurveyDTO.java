package studio.fabrique.survey.dto;

import studio.fabrique.survey.model.Answer;

import java.util.List;

/**
 * Data Transfer Object for AnsweredSurvey
 */
public class AnsweredSurveyDTO {
    private Long surveyId;
    private Long userId;
    private List<Answer> answers;

    public AnsweredSurveyDTO(Long surveyId, Long userId, List<Answer> answers) {
        this.surveyId = surveyId;
        this.userId = userId;
        this.answers = answers;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
