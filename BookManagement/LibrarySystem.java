/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookManagement;

/**
 *
 * @author danya
 */
 import java.util.Scanner;

public class LibrarySystem {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Book> list = new SinglyLinkedList<>();

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Print All Books");
            System.out.println("3. Find Most Expensive Book");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Book newBook = new Book(id, title, price);
                    list.add(newBook);
                    System.out.println("Book added.");
                    break;

                case 2:
                    System.out.println("All Books:");
                    list.printList();
                    break;

                case 3:
                    findMostExpensiveBook(list);
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    removeBookById(list, removeId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void findMostExpensiveBook(SinglyLinkedList<Book> list) {
        Node<Book> current = list.getHead();
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }

        Book expensive = current.data;
        current = current.next;

        while (current != null) {
            if (current.data.getPrice() > expensive.getPrice()) {
                expensive = current.data;
            }
            current = current.next;
        }

        System.out.println("Most Expensive Book:");
        System.out.println(expensive);
    }

    private static void removeBookById(SinglyLinkedList<Book> list, int id) {
        Node<Book> current = list.getHead();
        while (current != null) {
            if (current.data.getId() == id) {
                list.remove(current.data);
                System.out.println("Book removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found.");
    }
}


