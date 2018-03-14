package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.security.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    User findByFacebookId(final String facebookId);
}
