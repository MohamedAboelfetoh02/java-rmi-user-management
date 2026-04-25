import java.rmi.Naming;
import java.util.*;
import java.time.LocalDate;

public class HelloClient {
    public static void main(String[] args) {
        int retries = 3;
        HelloInterface hi = null;
        while (retries-- > 0) {
            try {
                hi = (HelloInterface) Naming.lookup("//localhost:5001/Hello");
                break;
            } catch (Exception e) {
                System.out.println("Connection failed. Retrying...");
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
            }
        }
        if (hi == null) {
            System.out.println("Unable to connect to server.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:\n1. Add User\n2. Delete User\n3. Get User Details\n4. List All Users\n5. Modify User\n6. Shutdown Server\n7. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("First Name: "); String fn = sc.nextLine();
                        System.out.print("Last Name: "); String ln = sc.nextLine();
                        System.out.print("Birthdate (YYYY-MM-DD): "); LocalDate bd = LocalDate.parse(sc.nextLine());
                        System.out.print("Salary: "); double sal = sc.nextDouble(); sc.nextLine();
                        System.out.print("Gender (MALE/FEMALE/OTHER): "); Gender g = Gender.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Division: "); String div = sc.nextLine();
                        System.out.print("Position: "); String pos = sc.nextLine();
                        hi.addUser(new User(fn, ln, bd, sal, g, div, pos));
                        break;
                    case 2:
                        System.out.print("Name to delete: ");
                        System.out.println("Deleted: " + hi.deleteUser(sc.nextLine()));
                        break;
                    case 3:
                        System.out.print("Name to retrieve: ");
                        System.out.println(hi.getUserDetails(sc.nextLine()));
                        break;
                    case 4:
                        for (User u : hi.getAllUsers()) System.out.println(u);
                        break;
                    case 5:
                        System.out.print("Name to modify: ");
                        String name = sc.nextLine();
                        System.out.print("New First Name: "); fn = sc.nextLine();
                        System.out.print("New Last Name: "); ln = sc.nextLine();
                        System.out.print("New Birthdate (YYYY-MM-DD): "); bd = LocalDate.parse(sc.nextLine());
                        System.out.print("New Salary: "); sal = sc.nextDouble(); sc.nextLine();
                        System.out.print("New Gender: "); g = Gender.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("New Division: "); div = sc.nextLine();
                        System.out.print("New Position: "); pos = sc.nextLine();
                        System.out.println("Modified: " + hi.modifyUser(name, new User(fn, ln, bd, sal, g, div, pos)));
                        break;
                    case 6:
                        hi.shutdown();
                        return;
                    case 7:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}