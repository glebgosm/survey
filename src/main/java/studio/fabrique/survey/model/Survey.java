package studio.fabrique.survey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Table("surveys")
public class Survey {
    @Id
    private Long id;
    private String name;
    private final LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @MappedCollection(idColumn = "survey_id", keyColumn = "ordinal")
    private List<Question> questions;

    public Survey(String name, LocalDate startDate, LocalDate endDate, String description, List<Question> questions) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
