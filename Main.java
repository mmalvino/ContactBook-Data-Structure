import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Contact Book!");

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "A":
                    addContact();
                    break;
                case "D":
                    deleteContact();
                    break;
                case "E":
                    searchByEmail();
                    break;
                case "P":
                    printContacts();
                    break;
                case "S":
                    searchContacts();
                    break;
                case "Q":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail search");
        System.out.println("(P)rint list");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.print("Please enter a command: ");
    }

    private static void addContact() {
        System.out.println("Add a contact:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, email, phoneNumber);
        contacts.add(contact);
    }

    private static void deleteContact() {
        System.out.println("Delete a contact:");
        System.out.print("Enter the index of the contact to delete: ");

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Contact contact = contacts.remove(index);
        System.out.println("Contact deleted: " + contact);
    }

    private static void searchByEmail() {
        System.out.println("Search for a contact by email:");
        System.out.print("Enter the email to search for: ");

        String email = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                System.out.println(contact);
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void searchContacts() {
        System.out.println("Search for a contact:");
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().contains(searchTerm) || contact.getEmail().contains(searchTerm) || contact.getPhoneNumber().contains(searchTerm)) {
                System.out.println(contact);
            }
        }
    }
}
