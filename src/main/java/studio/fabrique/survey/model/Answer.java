package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User answer to a particular Question
 */
@Table("answers")
public class Answer {
    @Id
    @Column("id")     // we need to specify column name explicitly because Spring would uppercase
    private Long id;  // the names by default and H2 is case-sensitive
    @Column("question_id")
    private Long questionId;
    @Column("answer")
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
