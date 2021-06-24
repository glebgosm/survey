package studio.fabrique.survey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Table("surveys")
public class Survey {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;
    @Column("start_date")
    private final LocalDate startDate;
    @Column("end_date")
    private LocalDate endDate;
    @Column("description")
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
