package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.users.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
