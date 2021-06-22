package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("questions")
public class Question {

    @Id
    private Long id;
    private QuestionType type;
    private String text;

//    @PersistenceConstructor
//    public Question(long id, String type, String test) {
//        switch (type) {
//            case ("T"):
//                this.type = QestionType.TEXT;
//                break;
//            case ("1"):
//                this.type = QestionType.ONE_CHECK;
//                break;
//            case ("0"):
//                this.type = QestionType.SEVERAL_CHECK;
//                break;
//        }
//        this.text = text;
//    }

    public Question(QuestionType type, String text) {
        this.type = type;
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
