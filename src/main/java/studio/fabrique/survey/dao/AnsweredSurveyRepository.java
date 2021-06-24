package studio.fabrique.survey.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import studio.fabrique.survey.model.AnsweredSurvey;

/**
 * Spring Data-JDBC Repository extension for AnsweredSurvey
 */
interface AnsweredSurveyRepository extends CrudRepository<AnsweredSurvey,Long> {
    /**
     * Find AnsweredSurveys by user id
     */
    @Query("SELECT * FROM \"answered_surveys\" WHERE user_id = :userId")
    Iterable<AnsweredSurvey> findByUserId(@Param("userId") Long userId);

    /**
     * Find AnsweredSurvey by user and survey ids
     */
    @Query("SELECT * FROM \"answered_surveys\" WHERE user_id = :userId and survey_id = :surveyId")
    AnsweredSurvey findByUserAndSurveyIds(@Param("userId") Long userId, @Param("surveyId") Long surveyId);
}
