package test.project.model;

public class ReportDetails {
    private Long id;
    private Long reportId;
    private String financial_data;
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getFinancial_data() {
        return financial_data;
    }

    public void setFinancial_data(String financial_data) {
        this.financial_data = financial_data;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
