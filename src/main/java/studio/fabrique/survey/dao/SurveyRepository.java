package studio.fabrique.survey.dao;

import org.springframework.data.repository.CrudRepository;
import studio.fabrique.survey.model.Survey;

public interface SurveyRepository extends CrudRepository<Survey,Long> {

}
