package studio.fabrique.survey.dao;

import org.springframework.data.repository.CrudRepository;
import studio.fabrique.survey.model.Survey;

/**
 * Spring Data-JDBC Repository extension for Survey
 */
interface SurveyRepository extends CrudRepository<Survey,Long> {

}
