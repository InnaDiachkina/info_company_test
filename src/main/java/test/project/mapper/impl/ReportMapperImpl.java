package test.project.mapper.impl;

import org.springframework.stereotype.Component;
import test.project.dto.ReportRequestDto;
import test.project.dto.ReportResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.Report;

@Component
public class ReportMapperImpl implements RequestDtoMapper<ReportRequestDto, Report>,
        ResponseDtoMapper<ReportResponseDto, Report> {
    @Override
    public Report mapToModel(ReportRequestDto reportRequestDto) {
        Report report = new Report();
        report.setCompanyId(reportRequestDto.getCompanyId());
        report.setTotalRevenue(reportRequestDto.getTotalRevenue());
        report.setNetProfit(reportRequestDto.getNetProfit());
        return report;
    }

    @Override
    public ReportResponseDto mapToDto(Report report) {
        ReportResponseDto reportResponseDto = new ReportResponseDto();
        reportResponseDto.setId(report.getId());
        reportResponseDto.setCompanyId(report.getCompanyId());
        reportResponseDto.setReportDate(report.getReportDate());
        reportResponseDto.setTotalRevenue(report.getTotalRevenue());
        reportResponseDto.setNetProfit(report.getNetProfit());
        return reportResponseDto;
    }
}
