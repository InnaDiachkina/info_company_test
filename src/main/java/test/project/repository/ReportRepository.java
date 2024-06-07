package test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.project.model.Report;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByCompanyId(Long id);
}
