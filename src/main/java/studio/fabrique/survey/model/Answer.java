package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("answers")
public class Answer {
    @Id
    private Long id;
    private Long questionId;
    private String answer;

    public Answer(Long questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }
}
