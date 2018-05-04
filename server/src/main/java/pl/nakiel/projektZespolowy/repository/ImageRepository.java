package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.events.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
