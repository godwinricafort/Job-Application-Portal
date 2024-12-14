package com.jobportal.jobs;

public abstract class Job {
    private String title;
    private String industry;
    private String companyName;

    public Job(String title, String industry, String companyName) {
        this.title = title;
        this.industry = industry;
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public abstract void displayJobDetails();
}
