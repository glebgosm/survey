package studio.fabrique.survey.dao;

import org.springframework.stereotype.Component;
import studio.fabrique.survey.model.User;

/**
 * Data Access Object for users
 */
@Component
public class UserDAO {
    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add a new user.
     */
    public Integer createNewUser(){
        return userRepository.saveUser(new User());
    }

    /**
     * Get User by id
     * @return User instance or null if no user was found
     */
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
