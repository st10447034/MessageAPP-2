import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagingApp {
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        users.put("john", new User("john", "password123", "1234567890"));
        users.put("jane", new User("jane", "password456", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;

        System.out.println("Welcome to OpenChat");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        if (authenticate(username, password, phoneNumber)) {
            while (runAgain) {
                System.out.println("Messaging App");
                System.out.println("1. Send Message");
                System.out.println("2. View Messages");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (option) {
                    case 1:
                        sendMessage(scanner, username);
                        break;
                    case 2:
                        viewMessages(username);
                        break;
                    case 3:
                        runAgain = false;
                        System.out.println("Exiting app...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            }
        } else {
            System.out.println("Invalid username, password, or phone number.");
        }

        scanner.close();
    }

    public static boolean authenticate(String username, String password, String phoneNumber) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password) && user.getPhoneNumber().equals(phoneNumber);
    }

    public static void sendMessage(Scanner scanner, String sender) {
        System.out.print("Enter recipient's username: ");
        String recipient = scanner.nextLine();
        System.out.print("Enter your message (max 125 characters): ");
        String message = scanner.nextLine();

        assert message.length() <= 125 : "Message too long";

        if (message.length() <= 125) {
            System.out.println("Message sent to " + recipient);
        } else {
            System.out.println("Message too long. Please limit to 125 characters.");
        }
    }

    public static void viewMessages(String username) {
        // implementation
    }

    private static class User {
        private String username;
        private String password;
        private String phoneNumber;

        public User(String username, String password, String phoneNumber) {
            this.username = username;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

        public String getPassword() {
            return password;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
