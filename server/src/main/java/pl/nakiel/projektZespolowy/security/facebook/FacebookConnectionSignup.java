package pl.nakiel.projektZespolowy.security.facebook;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        //TODO tworzenie uzytkownika
        System.out.println("signup === ");
        final User user = new User();
        user.setUsername(connection.getDisplayName());
        user.setPassword("randomAlphabetic(8)");
        userRepository.save(user);
        return user.getUsername();
    }

}