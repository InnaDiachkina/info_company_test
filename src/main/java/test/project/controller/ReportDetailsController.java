package test.project.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.project.dto.ReportDetailsRequestDto;
import test.project.dto.ReportDetailsResponseDto;
import test.project.service.ReportDetailsService;

@RestController
@RequestMapping("/report_details")
public class ReportDetailsController {
    private final ReportDetailsService reportDetailsService;

    public ReportDetailsController(ReportDetailsService reportDetailsService) {
        this.reportDetailsService = reportDetailsService;
    }

    @PostMapping
    public ReportDetailsResponseDto add(@RequestBody ReportDetailsRequestDto reportDetailsRequestDto) {
        return reportDetailsService.add(reportDetailsRequestDto);
    }

    @GetMapping("/{id}")
    public ReportDetailsResponseDto getById(@PathVariable UUID id) {
        return reportDetailsService.findById(id);
    }

    @GetMapping("/report/{id}")
    public List<ReportDetailsResponseDto> getByReportId(@PathVariable UUID id) {
        System.out.println(id);
        reportDetailsService.findAllByReportId(id);
        System.out.println("use");
        return reportDetailsService.findAllByReportId(id);
    }

    @PatchMapping("/{id}")
    public ReportDetailsResponseDto update(@PathVariable UUID id,
                                           @RequestBody ReportDetailsRequestDto reportDetailsRequestDto) {
        return reportDetailsService.update(id, reportDetailsRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        reportDetailsService.delete(id);
    }
}
