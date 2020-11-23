package mate.academy.heroesapi.controller;

import java.util.List;
import mate.academy.heroesapi.dto.HeroRequestDto;
import mate.academy.heroesapi.dto.HeroResponseDto;
import mate.academy.heroesapi.service.HeroService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<HeroResponseDto> getAll(@RequestParam(required = false) String name) {
        if (name != null) {
            return heroService.findByNamePart(name);
        }
        return heroService.getAll();
    }

    @GetMapping("/{id}")
    public HeroResponseDto getById(@PathVariable Long id) {
        return heroService.get(id);
    }

    @PostMapping
    public HeroResponseDto create(@RequestBody HeroRequestDto heroRequestDto) {
        return heroService.save(heroRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody HeroRequestDto heroRequestDto) {
        heroService.update(id, heroRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        heroService.delete(id);
    }
}
