package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.events.Event;
import pl.nakiel.projektZespolowy.domain.security.Role;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findOneByActive(Boolean active);
}
