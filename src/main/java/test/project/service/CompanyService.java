package test.project.service;

import java.util.List;
import java.util.UUID;
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;

public interface CompanyService {
    CompanyResponseDto add(CompanyRequestDto companyRequestDto);

    CompanyResponseDto getById(UUID id);

    List<CompanyResponseDto> getAll();

    CompanyResponseDto update(UUID id, CompanyRequestDto companyRequestDto);

    void delete(UUID id);
}
