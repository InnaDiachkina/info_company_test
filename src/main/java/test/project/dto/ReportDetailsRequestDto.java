package test.project.dto;

import java.util.Map;
import java.util.UUID;

public class ReportDetailsRequestDto {
    private UUID reportId;
    private Map<String, Object> financialData;
    private String comments;

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
