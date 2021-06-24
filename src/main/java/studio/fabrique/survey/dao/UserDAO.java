package studio.fabrique.survey.dao;

import org.springframework.stereotype.Component;
import studio.fabrique.survey.model.User;

@Component
public class UserDAO {
    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer createNewUser(){
        return userRepository.saveUser(new User());
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
