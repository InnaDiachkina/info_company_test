package test.project.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import test.project.model.Report;

public interface ReportRepository extends JpaRepository<Report, UUID> {
    List<Report> findAllByCompanyId(UUID id);
}
