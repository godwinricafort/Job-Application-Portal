package com.jobportal.jobs;

public class FullTimeJob extends Job {
    private double salary;

    public FullTimeJob(String title, String industry, String companyName, double salary) {
        super(title, industry, companyName);
        this.salary = salary;
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + getTitle());
        System.out.println("Industry: " + getIndustry());
        System.out.println("Company: " + getCompanyName());
        System.out.println("Salary: $" + salary);
    }
}
