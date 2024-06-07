package test.project.service;

import java.util.List;
import java.util.UUID;
import test.project.dto.ReportDetailsRequestDto;
import test.project.dto.ReportDetailsResponseDto;

public interface ReportDetailsService {
    ReportDetailsResponseDto add(ReportDetailsRequestDto reportDetailsRequestDto);

    List<ReportDetailsResponseDto> findAllByReportId(UUID id);

    ReportDetailsResponseDto findById(UUID id);

    ReportDetailsResponseDto update(UUID id,
                                    ReportDetailsRequestDto reportDetailsRequestDto);
    void delete(UUID id);
}
