package pl.nakiel.projektZespolowy.security.facebook;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import pl.nakiel.projektZespolowy.repository.UserRepository;


public class FacebookSignInAdapter implements SignInAdapter {

    private final UserRepository userRepository;

    @Autowired
    public FacebookSignInAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {

        System.out.println(" ====== Sign In adapter");

        pl.nakiel.projektZespolowy.domain.security.User user = userRepository.findByFacebookId(connection.getKey().getProviderUserId());

        UsernamePasswordAuthenticationToken userDetail = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(userDetail);
        return userDetail.getName();
    }


}
