package Utils;

import java.security.SecureRandom;
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
}
