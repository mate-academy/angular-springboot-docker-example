package mate.academy.heroesapi.mapper;

public interface ModelMapper<T, U, V> {
    T toModel(U requestDto);

    V toResponseDto(T model);
}
