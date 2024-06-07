package test.project.mapper.impl;

import org.springframework.stereotype.Component;
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.Company;

@Component
public class CompanyMapperImpl implements RequestDtoMapper<CompanyRequestDto, Company>,
        ResponseDtoMapper<CompanyResponseDto, Company> {

    @Override
    public Company mapToModel(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setAddress(companyRequestDto.getAddress());
        company.setRegistrationNumber(companyRequestDto.getRegistrationNumber());
        return company;
    }

    @Override
    public CompanyResponseDto mapToDto(Company company) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setName(company.getName());
        companyResponseDto.setAddress(company.getAddress());
        companyResponseDto.setRegistrationNumber(company.getRegistrationNumber());
        companyResponseDto.setCreatedAt(company.getCreatedAt());
        return companyResponseDto;
    }
}
