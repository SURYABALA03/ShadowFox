import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

public class ContactManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 0 -> System.out.println("Exiting Contact Manager. Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("==== Contact Management System ====");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        contactList.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            int index = 1;
            for (Contact c : contactList) {
                System.out.println("Contact #" + index++);
                c.display();
                System.out.println("----------------------");
            }
        }
    }

    static void updateContact() {
        viewContacts();
        if (contactList.isEmpty()) return;

        System.out.print("Enter contact number to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (index < 1 || index > contactList.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact c = contactList.get(index - 1);

        System.out.print("Enter new name (leave blank to keep '" + c.name + "'): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) c.name = name;

        System.out.print("Enter new phone (leave blank to keep '" + c.phone + "'): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) c.phone = phone;

        System.out.print("Enter new email (leave blank to keep '" + c.email + "'): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) c.email = email;

        System.out.println("Contact updated successfully!");
    }

    static void deleteContact() {
        viewContacts();
        if (contactList.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (index < 1 || index > contactList.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contactList.remove(index - 1);
        System.out.println("Contact deleted successfully!");
    }
}

