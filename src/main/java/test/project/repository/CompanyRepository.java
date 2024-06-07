package test.project.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import test.project.model.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
