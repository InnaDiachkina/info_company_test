package test.project.service;

import java.util.List;
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;

public interface CompanyService {
    CompanyResponseDto add(CompanyRequestDto companyRequestDto);

    CompanyResponseDto getById(Long id);

    List<CompanyResponseDto> getAll();

    CompanyResponseDto update(Long id, CompanyRequestDto companyRequestDto);

    void delete(Long id);
}