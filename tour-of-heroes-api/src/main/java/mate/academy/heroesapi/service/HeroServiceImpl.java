package mate.academy.heroesapi.service;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.heroesapi.dto.HeroRequestDto;
import mate.academy.heroesapi.dto.HeroResponseDto;
import mate.academy.heroesapi.mapper.HeroMapper;
import mate.academy.heroesapi.model.Hero;
import mate.academy.heroesapi.repository.HeroRepository;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;

    public HeroServiceImpl(HeroRepository heroRepository, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    @Override
    public List<HeroResponseDto> getAll() {
        return heroRepository.findAll() // TODO: add pagination here if required
                .stream()
                .map(heroMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public HeroResponseDto get(Long id) {
        return heroMapper.toResponseDto(heroRepository.getOne(id));
    }

    @Override
    public HeroResponseDto save(HeroRequestDto heroRequestDto) {
        Hero newHero = heroMapper.toModel(heroRequestDto);
        Hero savedHero = heroRepository.save(newHero);
        return heroMapper.toResponseDto(savedHero);
    }

    @Override
    public void update(Long id, HeroRequestDto heroRequestDto) {
        Hero hero = heroRepository.getOne(id);
        Hero newHero = heroMapper.toModel(heroRequestDto);
        newHero.setId(hero.getId());
        heroRepository.save(newHero);
    }

    @Override
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    @Override
    public List<HeroResponseDto> findByNamePart(String name) {
        return heroRepository.findAllByNameContains(name)
                .stream()
                .map(heroMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
