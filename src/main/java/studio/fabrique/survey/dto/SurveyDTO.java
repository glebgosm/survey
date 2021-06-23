package studio.fabrique.survey.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import studio.fabrique.survey.model.Question;

import java.time.LocalDate;
import java.util.List;

public class SurveyDTO {

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String description;

    private List<Question> questions;


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
}
