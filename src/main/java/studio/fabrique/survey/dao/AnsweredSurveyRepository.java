package studio.fabrique.survey.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import studio.fabrique.survey.model.AnsweredSurvey;

public interface AnsweredSurveyRepository extends CrudRepository<AnsweredSurvey,Long> {
    @Query("SELECT * FROM \"answered_surveys\" WHERE user_id = :userId")
    Iterable<AnsweredSurvey> findByUserId(@Param("userId") Long userId);

    @Query("SELECT * FROM \"answered_surveys\" WHERE user_id = :userId and survey_id = :surveyId")
    AnsweredSurvey findByUserAndSurveyIds(@Param("userId") Long userId, @Param("surveyId") Long surveyId);
}
