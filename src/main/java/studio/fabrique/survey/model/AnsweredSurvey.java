package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("answered_surveys")
public class AnsweredSurvey {
    @Id
    private Long id;
    private Long surveyId;
    private Long userId;
    @MappedCollection(idColumn = "answered_survey_id", keyColumn = "ordinal")
    private List<Answer> answers;

    public AnsweredSurvey(Long surveyId, Long userId, List<Answer> answers) {
        this.surveyId = surveyId;
        this.userId = userId;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}