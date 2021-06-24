package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/**
 * User answers to a particular Survey
 */
@Table("answered_surveys")
public class AnsweredSurvey {
    @Id
    @Column("id")
    private Long id;
    @Column("survey_id")
    private Long surveyId;
    @Column("user_id")
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
