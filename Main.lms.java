import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();

        System.out.println("==========================================");
        System.out.println("    LIBRARY MANAGEMENT SYSTEM - JAVA");
        System.out.println("    Owner: ABINESH R");
        System.out.println("    Phone: 9344040239");
        System.out.println("    Email: abineshr599@gmail.com");
        System.out.println("==========================================");

        // ----------- LOGIN -----------
        System.out.print("\nEnter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        User loggedIn = loginSystem.login(user, pass);

        if (loggedIn == null) {
            System.out.println("Invalid Login! Exiting...");
            System.exit(0);
        }

        System.out.println("\nLogin Successful! Logged in as: " + loggedIn.getRole());
        Library lib = new Library();

        // ----------- MENUS -----------
        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add Student");
            System.out.println("7. View Students");
            System.out.println("8. Logout");
            System.out.print("Choose option: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    if (!loggedIn.getRole().equals("admin")) {
                        System.out.println("Only admin can add books!");
                        break;
                    }
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int iid = sc.nextInt();
                    lib.issueBook(iid);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int rid = sc.nextInt();
                    lib.returnBook(rid);
                    break;

                case 5:
                    if (!loggedIn.getRole().equals("admin")) {
                        System.out.println("Only admin can delete books!");
                        break;
                    }
                    System.out.print("Enter Book ID to Delete: ");
                    int did = sc.nextInt();
                    lib.deleteBook(did);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    lib.addStudent(new Student(sid, sname, dept));
                    break;

                case 7:
                    lib.viewStudents();
                    break;

                case 8:
                    System.out.println("Logged Out. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
