package com.booking;

import java.util.Scanner;

public class TicketBookingSystem {
    public static double calculateTotalCost(String category, int tickets) {
        double pricePerTicket = 0;

        switch (category.toLowerCase()) {
            case "regular":
                pricePerTicket = 20.0;
                break;
            case "premium":
                pricePerTicket = 50.0;
                break;
            case "vip":
                pricePerTicket = 100.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid ticket category");
        }

        double totalCost = pricePerTicket * tickets;
        
        // Apply 10% discount if tickets exceed 5
        if (tickets > 5) {
            totalCost *= 0.90; 
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.*out*.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.*out*.print("Enter Category (Regular/Premium/VIP): ");
        String category = scanner.next();
        System.*out*.print("Enter Number of Tickets: ");
        int tickets = scanner.nextInt();

        double cost = calculateTotalCost(category, tickets);
        System.out.println("\n--- Booking Details ---");
        System.out.println("Customer: " + name);
        System.out.println("Category: " + category);
        System.out.println("Tickets: " + tickets);
        System.out.println("Total Amount (After Discount if applicable): $" + String.format("%.2f", cost));
        scanner.close();
    }
}
