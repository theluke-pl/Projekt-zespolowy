package pl.nakiel.projektZespolowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nakiel.projektZespolowy.domain.geo.Localization;

public interface LocalizationRepository extends JpaRepository<Localization, Long> {
}
