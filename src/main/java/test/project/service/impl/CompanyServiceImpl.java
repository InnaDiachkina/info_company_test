package test.project.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.Company;
import test.project.repository.CompanyRepository;
import test.project.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final RequestDtoMapper<CompanyRequestDto, Company> requestDtoMapper;
    private final ResponseDtoMapper<CompanyResponseDto, Company> responseDtoMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              RequestDtoMapper<CompanyRequestDto, Company> requestDtoMapper,
                              ResponseDtoMapper<CompanyResponseDto, Company> responseDtoMapper) {
        this.companyRepository = companyRepository;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @Override
    public CompanyResponseDto add(CompanyRequestDto companyRequestDto) {
        Company company = requestDtoMapper.mapToModel(companyRequestDto);
        companyRepository.save(company);
        return responseDtoMapper.mapToDto(company);
    }

    @Override
    public CompanyResponseDto getById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Company with id: " + id + " not found"));
        return responseDtoMapper.mapToDto(company);
    }

    @Override
    public List<CompanyResponseDto> getAll() {
        return companyRepository.findAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponseDto update(Long id, CompanyRequestDto companyRequestDto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company with id: " + id + " not found"));
        if (companyRequestDto.getName() != null) {
            company.setName(companyRequestDto.getName());
        }
        if (companyRequestDto.getAddress() != null) {
            company.setAddress(companyRequestDto.getAddress());
        }
        if (companyRequestDto.getRegistrationNumber() != null) {
            company.setRegistrationNumber(companyRequestDto.getRegistrationNumber());
        }
        Company updatedCompany = companyRepository.save(company);
        return responseDtoMapper.mapToDto(updatedCompany);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}

