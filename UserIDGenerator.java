import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserIDGenerator {
    private static ArrayList<String> generatedIDs = new ArrayList<>();
    private static Random random = new Random();

    public static String generateUserID(String firstName, String lastName, int year) {
        String baseID = firstName.substring(0, Math.min(3, firstName.length())).toUpperCase() +
                lastName.substring(0, Math.min(3, lastName.length())).toUpperCase() +
                year;

        String userID = baseID;

        while (generatedIDs.contains(userID)) {
            int randomNumber = random.nextInt(100);
            userID = baseID + randomNumber;
        }

        generatedIDs.add(userID);
        return userID;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== User ID Generator ===");

        while (true) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Birth Year (e.g., 1990): ");
            int year = scanner.nextInt();
            scanner.nextLine();
            String userID = generateUserID(firstName, lastName, year);
            System.out.println("Generated User ID: " + userID);
            System.out.print("Generate another ID? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                System.out.println("Exiting User ID Generator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
