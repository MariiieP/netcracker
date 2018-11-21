package Main;


import java.util.Scanner;

public class InputCorrect {

    static Scanner in = new Scanner(System.in);
    public boolean isCorrect(String line) {
        if (line.matches("^[a-z]+$")) {
            return true;
        }
        return false;
    }

    public String inputString(String message) {
        String name;
        do {
            System.out.println(message);
            assert false;
            name = in.nextLine();
        } while (!isCorrect(name.trim().toLowerCase()));
        return name;
    }

    public int inputInteger(String message, int leftSide, int rightSide) {
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

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
