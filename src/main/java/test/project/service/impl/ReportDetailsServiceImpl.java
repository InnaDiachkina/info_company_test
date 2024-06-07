package test.project.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import test.project.dto.ReportDetailsRequestDto;
import test.project.dto.ReportDetailsResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.ReportDetails;
import test.project.repository.ReportDetailsRepository;
import test.project.service.ReportDetailsService;

@Service
public class ReportDetailsServiceImpl implements ReportDetailsService {
    private final ReportDetailsRepository reportDetailsRepository;
    private final RequestDtoMapper<ReportDetailsRequestDto, ReportDetails> requestDtoMapper;
    private final ResponseDtoMapper<ReportDetailsResponseDto, ReportDetails> responseDtoMapper;

    public ReportDetailsServiceImpl(ReportDetailsRepository reportDetailsRepository,
                                    RequestDtoMapper<ReportDetailsRequestDto, ReportDetails> requestDtoMapper,
                                    ResponseDtoMapper<ReportDetailsResponseDto, ReportDetails> responseDtoMapper) {
        this.reportDetailsRepository = reportDetailsRepository;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @Override
    public ReportDetailsResponseDto add(ReportDetailsRequestDto reportDetailsRequestDto) {
        ReportDetails reportDetails = requestDtoMapper.mapToModel(reportDetailsRequestDto);
        reportDetails.setId(UUID.randomUUID());
        reportDetailsRepository.save(reportDetails);
        return responseDtoMapper.mapToDto(reportDetails);
    }

    @Override
    public List<ReportDetailsResponseDto> findAllByReportId(UUID id) {
        return reportDetailsRepository.findAllByReportId(id)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReportDetailsResponseDto findById(UUID id) {
        ReportDetails reportDetails = reportDetailsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Report details with id: " + id + " not found"));
        return responseDtoMapper.mapToDto(reportDetails);
    }

    @Override
    public ReportDetailsResponseDto update(UUID id, ReportDetailsRequestDto reportDetailsRequestDto) {
        ReportDetails reportDetails = reportDetailsRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Report details with id: " + id + " not found"));
        if (reportDetailsRequestDto.getReportId() != null) {
            reportDetails.setReportId(reportDetailsRequestDto.getReportId());
        }
        if (reportDetailsRequestDto.getFinancialData() != null) {
            reportDetails.setFinancialData(reportDetailsRequestDto.getFinancialData());
        }
        if (reportDetailsRequestDto.getComments() != null) {
            reportDetails.setComments(reportDetailsRequestDto.getComments());
        }
        ReportDetails updatedReportDetails = reportDetailsRepository.save(reportDetails);
        return responseDtoMapper.mapToDto(updatedReportDetails);
    }

    @Override
    public void delete(UUID id) {
        reportDetailsRepository.deleteById(id);
    }
}
