package test.project.mapper;

public interface ResponseDtoMapper <D, T>{
    D mapToDto(T t);
}
