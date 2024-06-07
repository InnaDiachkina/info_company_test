package test.project.model;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "report_details")
public class ReportDetails {
    @Id
    private UUID id;
    @Field("reportId")
    private UUID reportId;
    private String financialData;
    private String comments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getReportId() {
        return reportId;
    }

    public void setReportId(UUID reportId) {
        this.reportId = reportId;
    }

    public String getFinancialData() {
        return financialData;
    }

    public void setFinancialData(String financialData) {
        this.financialData = financialData;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}