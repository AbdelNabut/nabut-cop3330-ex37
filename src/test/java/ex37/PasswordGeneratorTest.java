package ex37;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test
    void generate() {
        int minLength = 8;
        int numSpecialCharacters = 2;
        int numNumbers = 3;
        String password = "";
        int choice = 0;
        int currentCharacters = 0;
        int currentSpecialCharacters = 0;
        int currentNumbers = 0;
        int largerCountSpecialCharactersOrNumbers = 0;
        char[] characters = {'a', 'c', 'd', 'z', 'q', 'm', 'h', 'g', 'p', 'w', 'x', 'b', 'n'};
        char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*', '-', '+', '=', '?', '|'};
        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        for(int i = 0; i < minLength; i++) {
            choice = (int) ((Math.random() * 3) + 1);
            if(currentCharacters < currentSpecialCharacters || currentCharacters < currentNumbers)
                choice = 1;
            if(choice == 2 && currentSpecialCharacters >= numSpecialCharacters)
                choice = 1;
            if(choice == 3 && currentNumbers >= numNumbers)
                choice = 1;
            if(choice == 1) {
                password += characters[(int) ((Math.random() * characters.length))];
                currentCharacters++;
            } else if(choice == 2) {
                password += specialCharacters[(int) ((Math.random() * specialCharacters.length))];
                currentSpecialCharacters++;
            } else {
                password += numbers[(int) ((Math.random() * numbers.length))];
                currentNumbers++;
            }
        }
        if(currentNumbers < numNumbers)
            for(int i = password.length(); currentSpecialCharacters < numSpecialCharacters; i++) {
                password += specialCharacters[(int) ((Math.random() * specialCharacters.length))];
                currentSpecialCharacters++;
            }
        if(currentNumbers < numNumbers)
            for(int i = password.length(); currentSpecialCharacters < numSpecialCharacters; i++) {
                password += numbers[(int) ((Math.random() * numbers.length))];
                currentNumbers++;
            }

        if(currentNumbers > currentSpecialCharacters)
            largerCountSpecialCharactersOrNumbers = currentNumbers;
        else
            largerCountSpecialCharactersOrNumbers = currentCharacters;

        if(currentCharacters < largerCountSpecialCharactersOrNumbers)
            for(int i = password.length(); currentCharacters < largerCountSpecialCharactersOrNumbers; i++) {
                password += characters[(int) ((Math.random() * characters.length))];
                currentCharacters++;
            }

        assertEquals(true, currentCharacters > largerCountSpecialCharactersOrNumbers);
    }
}