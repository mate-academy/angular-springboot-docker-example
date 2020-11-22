package mate.academy.heroesapi.mapper;

import mate.academy.heroesapi.dto.HeroRequestDto;
import mate.academy.heroesapi.dto.HeroResponseDto;
import mate.academy.heroesapi.model.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper implements ModelMapper<Hero, HeroRequestDto, HeroResponseDto> {

    @Override
    public Hero toModel(HeroRequestDto requestDto) {
        Hero hero = new Hero();
        hero.setName(requestDto.getName());
        return hero;
    }

    @Override
    public HeroResponseDto toResponseDto(Hero model) {
        HeroResponseDto responseDto = new HeroResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        return responseDto;
    }
}
