package pl.nakiel.projektZespolowy.security.facebook;


import java.util.Arrays;
import java.util.stream.Collectors;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import pl.nakiel.projektZespolowy.domain.security.User;
import pl.nakiel.projektZespolowy.repository.UserRepository;

@Service
public class FacebookSignInAdapter implements SignInAdapter {

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {

        System.out.println(" ====== Sign In adapter");



        UsernamePasswordAuthenticationToken userDetail = new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(localUserId,null,null), null, Arrays.asList(new SimpleGrantedAuthority("STANDARD_USER")));

        SecurityContextHolder.getContext().setAuthentication(userDetail);
        return userDetail.getName();
    }


}
