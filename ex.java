import java.util.Scanner;

public class ex {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String name = input.nextLine();

        System.out.print("Enter Your Age: ");
        int age = input.nextInt();

        System.out.print("What is The Price of The Meal: ");
        double price = input.nextDouble();

        System.out.print("Enter The Number of Drinks: ");
        int orders = input.nextInt();

        System.out.print("Are You a Student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Enter Service Rating (1-5): ");
        int serviceRating = input.nextInt();

      
        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error! Rating must be between 1 and 5.");
            return;
        }

    
        double drinkPrice = 15.50;
        double drinkCost = drinkPrice * orders;

      
        double subtotal = price + drinkCost;

       
        double discount = 0;

        if (isStudent) {
            discount = subtotal * 0.10;
        } 
        else if (age >= 60) {
            discount = subtotal * 0.05;
        }

       
        double discountedTotal = subtotal - discount;

        
        double tip = 0;

        if (serviceRating >= 4) {
            tip = discountedTotal * 0.10;
        }

    
        double finalBill = discountedTotal + tip;

        int wholeAmount = (int) finalBill;

       
        System.out.println("\n===== SMART RESTAURANT =====");

        System.out.println("Customer: " + name);
        System.out.println("Meal Cost: $" + price);
        System.out.println("Drinks Cost: $" + drinkCost);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Tip: $" + tip);
        System.out.println("Final Bill: $" + finalBill);
        System.out.println("Whole Amount: $" + wholeAmount);

        System.out.println("============================");

        input.close();
    }
}