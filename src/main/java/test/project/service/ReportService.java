package test.project.service;

import java.util.List;
import java.util.UUID;

import test.project.dto.ReportRequestDto;
import test.project.dto.ReportResponseDto;

public interface ReportService {
    ReportResponseDto add(ReportRequestDto request);

    ReportResponseDto getById(UUID id);

    List<ReportResponseDto> getAllByCompanyId(UUID companyId);

    void delete(UUID id);

    ReportResponseDto update(UUID id, ReportRequestDto request);
}
