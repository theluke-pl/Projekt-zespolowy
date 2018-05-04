package pl.nakiel.projektZespolowy.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.RoleRepository;
import pl.nakiel.projektZespolowy.repository.UserRepository;
import pl.nakiel.projektZespolowy.resources.dto.createstandarduser.CreateStandardUserRequestDTO;
import pl.nakiel.projektZespolowy.resources.dto.initfacebookuser.InitFacebookUserRequestDTO;
import pl.nakiel.projektZespolowy.security.ISecurityService;
import pl.nakiel.projektZespolowy.security.SecurityService;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ISecurityService securityService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return null;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        User user = securityService.getCurrentUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public User createStandardUser(String username, String password, String email, String firstName, String secondName) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setStatus(User.TO_ACTIVATION_STD);
        user.getRoles().add(roleRepository.findByName("STANDARD_USER"));

        user = userRepository.save(user);

        return user;
    }

    @Override
    public User getUserById(Long id){
        return userRepository.getOne(id);
    }

    @Override
    public User initFacebookUser(InitFacebookUserRequestDTO initFacebookUserRequestDTO) {
        return null;
    }
}
