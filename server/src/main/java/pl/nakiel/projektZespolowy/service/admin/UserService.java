package pl.nakiel.projektZespolowy.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return null;
    }

    @Override
    public void changePassword(Long userId, String password) {
        User user = userRepository.getOne(userId);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
