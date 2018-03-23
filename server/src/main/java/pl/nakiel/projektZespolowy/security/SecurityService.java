package pl.nakiel.projektZespolowy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;

@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        User user = userRepository.findByUsername(((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return user;
    }
}
