package Main;

import java.util.Scanner;

/**
 * InputCorrect - class help correct input message from user
 */
class InputCorrect {

    /**
     * inpputCorrect - object help validate imput
     */
    static Scanner in = new Scanner(System.in);

    /**
     * @param line - input user str
     * @return boolean
     */
    private boolean isCorrect(String line) {
        return line.matches("^[a-z]+$");
    }

    /**
     * helper input str message
     * @param message - input user str
     * @return string
     */
    String inputString(String message) {
        String name;
        do {
            System.out.println(message);
            assert false;
            name = in.nextLine();
        } while (!isCorrect(name.trim().toLowerCase()));
        return name;
    }

    /**
     * helper input imt message
     * @param message   - input user str
     * @param leftSide  - left side for input
     * @param rightSide - right side for input
     * @return int
     */
    int inputInteger(String message, int leftSide, int rightSide) {
        String gender;
        int selectGender;
        do {
            System.out.println(message);
            assert false;
            gender = in.nextLine().trim();
            selectGender = tryParse(gender);
        } while (selectGender < leftSide || selectGender > rightSide);
        return selectGender;
    }

    /**
     * try to cast the entered message to the type of int
     * @param text input user text
     * @return int or exception
     */
    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
