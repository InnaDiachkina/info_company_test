package test.project.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import test.project.model.ReportDetails;

public interface ReportDetailsRepository extends MongoRepository<ReportDetails, UUID> {
    List<ReportDetails> findAllByReportId(UUID id);
}
