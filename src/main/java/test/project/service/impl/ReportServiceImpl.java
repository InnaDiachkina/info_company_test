package test.project.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import test.project.dto.ReportRequestDto;
import test.project.dto.ReportResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.Report;
import test.project.repository.ReportRepository;
import test.project.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final RequestDtoMapper<ReportRequestDto, Report> requestDtoMapper;
    private final ResponseDtoMapper<ReportResponseDto, Report> responseDtoMapper;

    public ReportServiceImpl(ReportRepository reportRepository,
                             RequestDtoMapper<ReportRequestDto, Report> requestDtoMapper,
                             ResponseDtoMapper<ReportResponseDto, Report> responseDtoMapper) {
        this.reportRepository = reportRepository;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }


    @Override
    public ReportResponseDto add(ReportRequestDto reportRequestDto) {
        Report report = requestDtoMapper.mapToModel(reportRequestDto);
        reportRepository.save(report);
        return responseDtoMapper.mapToDto(report);
    }

    @Override
    public ReportResponseDto getById(UUID id) {
        Report report = reportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Report with id: " + id + "not found"));
        return responseDtoMapper.mapToDto(report);
    }

    @Override
    public List<ReportResponseDto> getAllByCompanyId(UUID companyId) {
        return reportRepository.findAllByCompanyId(companyId)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        reportRepository.deleteById(id);
    }

    @Override
    public ReportResponseDto update(UUID id, ReportRequestDto reportRequestDto) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report with id: " + id + "not found"));
        if (reportRequestDto.getCompanyId() != null) {
            report.setCompanyId(reportRequestDto.getCompanyId());
        }
        if (reportRequestDto.getTotalRevenue() != null) {
            report.setTotalRevenue(reportRequestDto.getTotalRevenue());
        }
        if (reportRequestDto.getNetProfit() != null) {
            report.setNetProfit(reportRequestDto.getNetProfit());
        }
        Report updatedReport = reportRepository.save(report);
        return responseDtoMapper.mapToDto(updatedReport);
    }
}
