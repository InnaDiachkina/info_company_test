package test.project.mapper;

public interface RequestDtoMapper <D, T>{
    T mapToModel(D dto);
}
