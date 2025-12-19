import java.util.Scanner;

public class BasicMath {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Addition
        int add = a + b;
        System.out.println("Addition = " + add);

        // Subtraction
        int sub = a - b;
        System.out.println("Subtraction = " + sub);

        // Multiplication
        int mul = a * b;
        System.out.println("Multiplication = " + mul);

        // Division
        int div = a / b;
        System.out.println("Division = " + div);

        // Remainder
        int rem = a % b;
        System.out.println("Remainder = " + rem);

        // Square
        int square = a * a;
        System.out.println("Square of first number = " + square);

        // Cube
        int cube = a * a * a;
        System.out.println("Cube of first number = " + cube);

        // Absolute value
        int abs = Math.abs(a);
        System.out.println("Absolute value of first number = " + abs);
    }
}
