import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Registration umber: ");
        String registrationNumber = input.nextLine();

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        System.out.print("Enter Student Age: ");
        int age = input.nextInt();

        System.out.print("Enter Mark 1: ");
        double mark1 = input.nextDouble();

        System.out.print("Enter Mark 2: ");
        double mark2 = input.nextDouble();

        System.out.print("Enter Mark 3: ");
        double mark3 = input.nextDouble();
        Student student = new Student(
            registrationNumber,
            name,
            age,
            mark1,
            mark2,
            mark3
        );
        student.displayInformation();

        input.close();
    }
}