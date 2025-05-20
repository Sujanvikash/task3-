import java.util.Scanner;

interface Taxable {
    double salesTax = 0.07;
    double incomeTax = 0.105;

    double calcTax();
}

class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public double calcTax() {
        double yearlySalary = salary * 12;
        return yearlySalary * incomeTax;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + empId + ", Name: " + name + ", Monthly Salary: " + salary);
    }
}

class Product implements Taxable {
    private int productId;
    private double price;
    private int quantity;

    public Product(int productId, double price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public double calcTax() {
        return price * salesTax;
    }

    public void displayInfo() {
        System.out.println("Product ID: " + productId + ", Price: " + price + ", Quantity: " + quantity);
    }
}


public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Details:");
        System.out.print("ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empId, name, salary);
        employee.displayInfo();
        System.out.printf("Income Tax (Yearly): %.2f%n", employee.calcTax());

        // Input Product Details
        System.out.println("\nEnter Product Details:");
        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Unit Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(productId, price, quantity);
        product.displayInfo();
        System.out.printf("Sales Tax (Per Unit): %.2f%n", product.calcTax());

        scanner.close();
    }
}

