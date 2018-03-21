package pl.nakiel.projektZespolowy.security.facebook;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    private UserRepository userRepository;

    @Autowired
    public FacebookConnectionSignup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String execute(Connection<?> connection) {
        if(userRepository.findByFacebookId(connection.getKey().getProviderUserId()) != null){
            User user = userRepository.findByFacebookId(connection.getKey().getProviderUserId());
            return user.getId().toString();
        }
        String [] fields = { "id", "email",  "first_name", "last_name" };
        System.out.println("signup === ");
        final User user = new User();
        user.setUsername(connection.getKey().getProviderUserId());
        user.setPassword(randomAlphabetic(18));
        user.setFacebookId(connection.getKey().getProviderUserId());
        user.setStatus(User.TO_ACTIVATION_FB);
        userRepository.save(user);
        return user.getId().toString();
    }

}