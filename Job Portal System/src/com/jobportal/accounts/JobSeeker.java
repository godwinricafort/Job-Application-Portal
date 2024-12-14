package com.jobportal.accounts;

import com.jobportal.jobs.*;
import com.jobportal.utils.Utils;

import java.util.Scanner;

public class JobSeeker extends User {
    private Scanner scanner = new Scanner(System.in);

    public JobSeeker(String name, String email, String password) {
        super(name, email, password);
    }

    public void browseAndApply(JobList jobList) {
        while (true) {
            Utils.delay(500);
            Utils.clearScreen();
            Utils.headerDesign();

            System.out.println("\n=== Job Seeker Menu ===");
            System.out.println("\n[1] Browse Jobs");
            System.out.println("[2] Apply for a Job");
            System.out.println("[3] Log Out");
            System.out.print("\nChoose an option: ");

            int choice = getValidInput();
            switch (choice) {
                case 1:
                    jobList.displayJobs();
                    break;
                case 2:
                    applyForJob(jobList);
                    break;
                case 3:
                    System.out.println("\nLogging out...");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void applyForJob(JobList jobList) {
        jobList.displayJobs();
        System.out.print("Enter the job number you want to apply for: ");
        int jobIndex = getValidInput() - 1;

        Job job = jobList.getJob(jobIndex);
        if (job != null) {
            Application application = new Application(this, job);
            System.out.println("You applied for: " + job.getTitle() + " at " + job.getCompanyName());
        } else {
            System.out.println("Invalid job number.");
        }
    }

    private int getValidInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
