import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import entities.employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        employee em = new employee();
        Scanner read = new Scanner(System.in);

        System.out.print("Name: \n");
        em.name = read.nextLine();

        System.out.print("Gross Salary: \n");
        em.grossSalary = read.nextDouble();

        System.out.println("Tax: \n");

        System.out.println("Employee: " + em);

        double percentage = read.nextDouble();
        System.out.println("Which percentage to increase salary?" + percentage);
    }
}
