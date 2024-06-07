package test.project.dto;

import java.util.UUID;

public class ReportDetailsRequestDto {
    private UUID reportId;
    private String financialData;
    private String comments;

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
