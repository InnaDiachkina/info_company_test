package test.project.dto;

import java.util.Map;
import java.util.UUID;

public class ReportDetailsResponseDto {
    private UUID id;
    private UUID reportId;
    private Map<String, Object> financialData;
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

    public Map<String, Object> getFinancialData() {
        return financialData;
    }

    public void setFinancialData(Map<String, Object> financialData) {
        this.financialData = financialData;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
