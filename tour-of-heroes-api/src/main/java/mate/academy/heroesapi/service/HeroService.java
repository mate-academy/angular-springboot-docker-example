package mate.academy.heroesapi.service;

import java.util.List;
import mate.academy.heroesapi.dto.HeroRequestDto;
import mate.academy.heroesapi.dto.HeroResponseDto;

public interface HeroService {
    List<HeroResponseDto> getAll();

    HeroResponseDto get(Long id);

    HeroResponseDto save(HeroRequestDto heroRequestDto);

    void update(Long id, HeroRequestDto heroRequestDto);

    void delete(Long id);

    List<HeroResponseDto> findByNamePart(String name);
}
