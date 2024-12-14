package com.jobportal.accounts;

import com.jobportal.jobs.*;
import com.jobportal.utils.Utils;
import java.util.Scanner;

public class Employer extends User {
    private Scanner scanner = new Scanner(System.in);

    public Employer(String name, String email, String password) {
        super(name, email, password);
    }

    public void performActions(JobList jobList) {
        while (true) {
            Utils.delay(500);
            Utils.clearScreen();
            Utils.headerDesign();

            System.out.println("\n=== EMPLOYER MENU ===");
            System.out.println("\n[1] Post a Job");
            System.out.println("[2] View Posted Jobs");
            System.out.println("[3] Log Out");
            System.out.print("\nChoose an option: ");

            int choice = getValidInput();
            switch (choice) {
                case 1:
                    postJob(jobList);
                    break;
                case 2:
                    jobList.displayJobs();
                    break;
                case 3:
                    System.out.println("\nLogging out...");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void postJob(JobList jobList) {
        Utils.delay(500);
        Utils.clearScreen();
        Utils.headerDesign();

        System.out.println("\n=== POST A JOB ===");
        System.out.print("\nEnter job title: ");
        String title = scanner.nextLine();
        System.out.print("Enter industry: ");
        String industry = scanner.nextLine();
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();

        double salary = 0;
        while (salary <= 0) {
            try {
                System.out.print("Enter salary: ");
                salary = Double.parseDouble(scanner.nextLine());
                if (salary <= 0) throw new Exception("Salary must be greater than 0.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nChoose Job Type:");
        System.out.println("1. Full-Time Job");
        System.out.println("2. Part-Time Job");
        System.out.print("Enter your choice: ");
        int jobTypeChoice = getValidInput();

        Job job;
        if (jobTypeChoice == 1) {
            job = new FullTimeJob(title, industry, companyName, salary);
        } else if (jobTypeChoice == 2) {
            job = new PartTimeJob(title, industry, companyName, salary);
        } else {
            System.out.println("Invalid choice. Defaulting to Full-Time Job.");
            job = new FullTimeJob(title, industry, companyName, salary);
        }

        jobList.addJob(job);
        System.out.println("Job posted successfully!");
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
