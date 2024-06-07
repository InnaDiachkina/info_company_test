package test.project.service;

import java.util.List;
import test.project.dto.ReportRequestDto;
import test.project.dto.ReportResponseDto;

public interface ReportService {
    ReportResponseDto add(ReportRequestDto request);

    ReportResponseDto getById(Long id);

    List<ReportResponseDto> getAllByCompanyId(Long companyId);

    void delete(Long id);

    ReportResponseDto update(Long id, ReportRequestDto request);
}
