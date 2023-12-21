
import java.util.Random;
import java.util.Scanner;

public class ProductNameGenerator {

    private static final String CONSONANTS = "bcdfghjklmnprstvwxz";
    private static final String VOWELS = "aeiou";
    private static final int MAX_LENGTH = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of product names to create: ");
        int numNames = validateInput(scanner.nextLine());

        System.out.print("Enter the length of each product name: ");
        int nameLength = validateInput(scanner.nextLine());

        if (nameLength > MAX_LENGTH) {
            nameLength = MAX_LENGTH;
            System.out.println("Length too long. Setting length to " + MAX_LENGTH + " characters.");
        }

        for (int i = 0; i < numNames; i++) {
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < nameLength; j++) {
                if (j % 2 == 0) {

                    name.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
                } else {

                    name.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
                }
            }
            System.out.println(name.toString());
        }
    }

    private static int validateInput(String input) {
        int num = -1;
        while (num < 0) {
            try {
                num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.print("Invalid input. Please enter a positive integer: ");
                    input = new Scanner(System.in).nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a positive integer: ");
                input = new Scanner(System.in).nextLine();
            }
        }
        return num;
    }
}
