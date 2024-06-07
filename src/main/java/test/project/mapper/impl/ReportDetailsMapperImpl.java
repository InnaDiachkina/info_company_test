package test.project.mapper.impl;

import org.springframework.stereotype.Component;
import test.project.dto.ReportDetailsRequestDto;
import test.project.dto.ReportDetailsResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.ReportDetails;

@Component
public class ReportDetailsMapperImpl implements RequestDtoMapper<ReportDetailsRequestDto, ReportDetails>,
        ResponseDtoMapper<ReportDetailsResponseDto,ReportDetails> {
    @Override
    public ReportDetails mapToModel(ReportDetailsRequestDto reportDetailsRequestDto) {
        ReportDetails reportDetails = new ReportDetails();
        reportDetails.setReportId(reportDetailsRequestDto.getReportId());
        reportDetails.setFinancialData(reportDetailsRequestDto.getFinancialData());
        reportDetails.setComments(reportDetailsRequestDto.getComments());
        return reportDetails;
    }

    @Override
    public ReportDetailsResponseDto mapToDto(ReportDetails reportDetails) {
        ReportDetailsResponseDto reportDetailsResponseDto = new ReportDetailsResponseDto();
        reportDetailsResponseDto.setId(reportDetails.getId());
        reportDetailsResponseDto.setReportId(reportDetails.getReportId());
        reportDetailsResponseDto.setFinancialData(reportDetails.getFinancialData());
        reportDetailsResponseDto.setComments(reportDetails.getComments());
        return reportDetailsResponseDto;
    }
}
