package pl.nakiel.projektZespolowy.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;
import pl.nakiel.projektZespolowy.resources.dto.createstandarduser.CreateStandardUserRequestDTO;
import pl.nakiel.projektZespolowy.resources.dto.initfacebookuser.InitFacebookUserRequestDTO;

import java.util.List;

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
    public User getCurrentUser() {
        User user = userRepository.findByUsername(((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return user;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        User user = getCurrentUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void createStandardUser(CreateStandardUserRequestDTO createStandardUserRequestDTO) {

    }

    @Override
    public void initFacebookUser(InitFacebookUserRequestDTO initFacebookUserRequestDTO) {

    }
}
