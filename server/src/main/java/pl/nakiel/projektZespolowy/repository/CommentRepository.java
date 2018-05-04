package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.events.Comment;
import pl.nakiel.projektZespolowy.domain.security.Role;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
