package test.project.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.project.dto.ReportRequestDto;
import test.project.dto.ReportResponseDto;
import test.project.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ReportResponseDto add(@RequestBody ReportRequestDto reportRequestDto) {
        return reportService.add(reportRequestDto);
    }

    @GetMapping("/{id}")
    public ReportResponseDto getById(@PathVariable Long id) {
        return reportService.getById(id);
    }

    @GetMapping("/company/{id}")
    public List<ReportResponseDto> getByCompanyId(@PathVariable Long id) {
        return reportService.getAllByCompanyId(id);
    }

    @PatchMapping("/{id}")
    public ReportResponseDto update(@PathVariable Long id,
                                    @RequestBody ReportRequestDto reportRequestDto) {
        return reportService.update(id, reportRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reportService.delete(id);
    }
}
