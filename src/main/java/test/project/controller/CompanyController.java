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
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;
import test.project.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyResponseDto add(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.add(companyRequestDto);
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @GetMapping
    public List<CompanyResponseDto> getAll() {
        return companyService.getAll();
    }

    @PatchMapping("/{id}")
    public CompanyResponseDto update(@PathVariable Long id,
                                     @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.update(id, companyRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}
