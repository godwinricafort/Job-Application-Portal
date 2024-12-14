package com.jobportal.jobs;

import com.jobportal.utils.Utils;
import java.util.ArrayList;
import java.util.Scanner;

public class JobList {
    private ArrayList<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        jobs.add(job);
        System.out.println("\nJob added successfully!");
    }

    public void displayJobs() {
        Utils.delay(500);
        Utils.clearScreen();
        Utils.headerDesign();

        System.out.println("\n=== POSTED JOBS ===\n");
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            System.out.println("\nPress Enter to continue.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            return;
        }
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            String jobType = (job instanceof FullTimeJob) ? "Full-Time" : (job instanceof PartTimeJob) ? "Part-Time" : "Unknown";
            System.out.println("[" + (i + 1) + "] " + job.getTitle() + " at " + job.getCompanyName() + " (" + jobType + ")");
        }
        System.out.println("\nPress Enter to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public Job getJob(int index) {
        if (index < 0 || index >= jobs.size()) {
            System.out.println("\nInvalid job index.");
            return null;
        }
        return jobs.get(index);
    }
}
