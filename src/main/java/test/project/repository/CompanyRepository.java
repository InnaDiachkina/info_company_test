package test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.project.model.Company;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Long> {
}
