package mate.academy.heroesapi.repository;

import java.util.List;
import mate.academy.heroesapi.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findAllByNameContains(String name);
}
