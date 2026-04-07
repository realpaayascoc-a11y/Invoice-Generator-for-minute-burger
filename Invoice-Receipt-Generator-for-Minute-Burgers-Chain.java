import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] burgers = {
            "Cheese Burger",
            "Hungarian Sandwich",
            "Black Pepper",
            "Chicken Burger",
            "Mushroom Burger",
            "Jumbo Burger"
        };

        int[] prices = {99, 98, 96, 95, 97, 120};

        while (true) {
            int[] quantities = new int[burgers.length];
            int total = 0;

            System.out.println("=== Minute Burger Menu ===");
            for (int i = 0; i < burgers.length; i++) {
                System.out.println((i + 1) + ". " + burgers[i] + ": " + prices[i] + " PHP");
            }

            
            while (true) {
                int choice;
                
                while (true) {
                    System.out.print("\nEnter burger number (1-6 only): ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= burgers.length) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please choose only from the menu (1-6).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number only!");
                        scanner.next();
                    }
                }

                
                int qty;
                while (true) {
                    System.out.print("Quantity: ");
                    if (scanner.hasNextInt()) {
                        qty = scanner.nextInt();
                        if (qty > 0) {
                            break;
                        } else {
                            System.out.println("Invalid input Quantity must be greater than 0!");
                        }
                    } else {
                        System.out.println("invalid input Please enter a number only!");
                        scanner.next();
                    }
                }

                quantities[choice - 1] += qty;
                total += prices[choice - 1] * qty;
                System.out.println("Added: " + qty + "x " + burgers[choice - 1]);

                
                String answer;
                while (true) {
                    System.out.print("Do you want to add another? (yes/no): ");
                    answer = scanner.next();
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.out.println("Please answer only 'yes' or 'no'.");
                    }
                }

                if (answer.equalsIgnoreCase("no")) {
                    break; 
                }
            }

            
            System.out.println("\n--- Invoice ---");
            for (int i = 0; i < burgers.length; i++) {
                if (quantities[i] > 0) {
                    int itemTotal = prices[i] * quantities[i];
                    System.out.println(quantities[i] + "x " + burgers[i] + " @ " + prices[i] + " PHP = " + itemTotal + " PHP");
                }
            }
            System.out.println("-----------------------------");
            System.out.println("Total Amount: " + total + " PHP");
            System.out.println("Thank you for ordering at Minute Burger!");

            
            String newOrder;
            while (true) {
                System.out.print("\nStart a new order? (yes/no): ");
                newOrder = scanner.next();
                if (newOrder.equalsIgnoreCase("yes") || newOrder.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Please answer only 'yes' or 'no'.");
                }
            }

            if (newOrder.equalsIgnoreCase("no")) {
                System.out.println("Thankyou Good Bye");
                break;
            }
        }

        scanner.close();
    }
}
