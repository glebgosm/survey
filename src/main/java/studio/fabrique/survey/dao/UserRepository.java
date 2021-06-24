package studio.fabrique.survey.dao;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import studio.fabrique.survey.model.User;

/**
 * Spring Data-JDBC Repository extension for User
 */
interface UserRepository extends CrudRepository<User,Long> {
    /**
     * Add new user to the DB
     */
    @Modifying
    @Query("INSERT INTO users DEFAULT VALUES")
    Integer saveUser(User user);
}
