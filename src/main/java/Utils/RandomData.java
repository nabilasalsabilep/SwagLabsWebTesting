package Utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class RandomData {
    //generate random username for user registration page
    public String generateRandomUsername(){
        return "User_" + UUID.randomUUID().toString().substring(0, 8);
    }

    //generate random password for user registration page
    public String generateRandomPassword() {
        // Define character sets
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        // Combine all the character sets
        String allCharacters = uppercaseLetters + lowercaseLetters + digits;

        // Specify the length of the password (minimum 8 characters)
        int passwordLength = 8; // You can change this length

        // Use SecureRandom for better randomness
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure the password contains at least one uppercase letter, one lowercase letter, and one number
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));

        // Fill the rest of the password with random characters from all sets
        for (int i = 3; i < passwordLength; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password to randomize the order of characters
        return password.toString();
    }

    //generate random name
    public String generateRandomFirstName() {
        String[] firstWords = {"Johnny", "Jani", "Bobby", "First", "Michael", "Paul", "Morgan"};
        String[] lastWords = {"Smith", "Johnson", "Beam", "Don", "Willy", "Pil", "West"};

        Random random = new Random();
        String firstWord = firstWords[random.nextInt(firstWords.length)];
        String lastWord = lastWords[random.nextInt(lastWords.length)];

        return firstWord + " " + lastWord;
    }

    //generate random name
    public String generateRandomLastName() {
        String[] firstWords = {"Johnson", "Garcia" , "Patel"};
        String[] lastWords = {"Nguyen", "Brown", "Kim", "Rodriguez"};

        Random random = new Random();
        String firstWord = firstWords[random.nextInt(firstWords.length)];
        String lastWord = lastWords[random.nextInt(lastWords.length)];

        return firstWord + " " + lastWord;
    }

    //generate random postal code
    public String generateRandomPostalCode(){
        Random random = new Random();

        // Generate a 5-digit number for the postal code
        int postalCode = 10000 + random.nextInt(90000);  // Ensures it's a 5-digit number
        return String.valueOf(postalCode);
    }

}
