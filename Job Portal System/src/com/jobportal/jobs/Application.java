package com.jobportal.jobs;

import com.jobportal.accounts.JobSeeker;

public class Application {
    private JobSeeker applicant;
    private Job job;

    public Application(JobSeeker applicant, Job job) {
        this.applicant = applicant;
        this.job = job;
    }

    public JobSeeker getApplicant() {
        return applicant;
    }

    public Job getJob() {
        return job;
    }
}
