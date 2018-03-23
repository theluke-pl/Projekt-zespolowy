package pl.nakiel.projektZespolowy.security;

import pl.nakiel.projektZespolowy.domain.security.User;

public interface ISecurityService {
    User getCurrentUser();
}
