import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    // ------------------ BOOK MANAGEMENT ------------------

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.println("\n--- BOOK LIST ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    public void deleteBook(int id) {
        Book b = searchBook(id);
        if (b == null) {
            System.out.println("Book not found!");
            return;
        }
        books.remove(b);
        System.out.println("Book deleted!");
    }

    public void issueBook(int bookId) {
        Book b = searchBook(bookId);
        if (b == null) {
            System.out.println("Book not found!");
            return;
        }
        if (b.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }
        b.issueBook();
        System.out.println("Book issued successfully!");
    }

    public void returnBook(int bookId) {
        Book b = searchBook(bookId);
        if (b == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!b.isIssued()) {
            System.out.println("Book is not issued!");
            return;
        }
        b.returnBook();
        System.out.println("Book returned successfully!");
    }

    // ------------------ STUDENT MANAGEMENT ------------------

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n--- STUDENT LIST ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id)
                return s;
        }
        return null;
    }
}
