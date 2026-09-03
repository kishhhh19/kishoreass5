package com.billing;

import java.util.Scanner;

public class DataBillingSystem {
    public static double calculateBill(String planType, double dataConsumed) {
        double baseRate = 0;
        double dataLimit = 0;
        double extraRate = 0;

        switch (planType.toLowerCase()) {
            case "basic":
                baseRate = 30.0;
                dataLimit = 50.0;
                extraRate = 0.50;
                break;
            case "standard":
                baseRate = 50.0;
                dataLimit = 150.0;
                extraRate = 0.30;
                break;
            case "premium":
                baseRate = 80.0;
                dataLimit = 300.0;
                extraRate = 0.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan type");
        }

        double totalBill = baseRate;
        if (dataConsumed > dataLimit) {
            double extraData = dataConsumed - dataLimit;
            totalBill += extraData * extraRate;
        }
        return totalBill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Plan Type (Basic/Standard/Premium): ");
        String plan = scanner.next();
        System.out.print("Enter Data Consumed (in GB): ");
        double usage = scanner.nextDouble();

        double bill = calculateBill(plan, usage);
        System.out.println("\n--- Data Usage Bill ---");
        System.out.println("Customer: " + name);
        System.out.println("Plan: " + plan);
        System.out.println("Total Bill: $" + String.format("%.2f", bill));
        scanner.close();
    }
}
