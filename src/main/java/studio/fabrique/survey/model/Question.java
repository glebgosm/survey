package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("questions")
public class Question {

    @Id
    private Long id;
    private QuestionType type;
    private String text;
    private Long surveyId;

    public Question(QuestionType type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return type == question.type &&
                Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text);
    }

    public QuestionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }
}
