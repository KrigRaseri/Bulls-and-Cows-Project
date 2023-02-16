package bullsandcows;

import java.util.*;

public class Util {

    //Sets int size, then checks its validity.
    public static int setSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        System.out.print("> ");
        int size = 0;

        try {
            size = sc.nextInt();

            if (size <= 0 || size > 36) {
                System.out.println("Error: input incorrect, try again.");
                System.exit(1);
            }
        } catch (InputMismatchException e) {
            System.out.printf("Error: %s isn't a valid number.", size);
            System.exit(1);
        }

        return size;
    }


    //Sets int nSymbols, then checks its validity.
    public static int setSymbols() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of possible symbols in the code:");
        System.out.print("> ");
        int nSymbols = sc.nextInt();

        while (nSymbols <= 0 || nSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.out.print("> ");
            nSymbols = sc.nextInt();
        }

        return nSymbols;
    }


    /**
     * Prints out a blurred version of the code ***** and the number, as well as letters, used in the secret code.
     *
     * @param code represents the secret code already made.
     * @param nSymbols chosen amount of symbols to be used in secret code (based on a range of 10-36).
     * */
    public static String printInfo(String code, int nSymbols) {
        String range = "0123456789abcdefghijklmnopqrstuvwxyz";
        String stars = code.replaceAll("(?s).", "*");
        char letter;
        String section = "";

        if (nSymbols == 11) {
            section = "(0-9, a)";

        } else if (nSymbols > 11) {
            letter = range.charAt(nSymbols - 1);
            section = String.format("(0-9, a-%c)", letter);

        } else {
            section = "(0-9)";
        }

        return String.format("%s %s.", stars, section);


    }

    /**
     * Method to create the secret code that needs to be guessed.
     *
     * @param size length of the secret code.
     * @param nSymbols chosen amount of symbols to be used in secret code (based on a range of 10-36).
     * */
    public static String randomCode(int size, int nSymbols) {
        Random rand = new Random();
        String code = "";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        String range = "0123456789abcdefghijklmnopqrstuvwxyz";

        while (set.size() < size) {
            if (nSymbols <= 10) {
                String c = String.valueOf(rand.nextInt(10));
                set.add(c.charAt(0));

            } else {
                set.add(range.charAt(rand.nextInt(36)));

            }
        }

        for (Character c : set) {
            code += c.toString();
        }

        return code;
    }


    /**
     * Game initialize starts the game, and controls the win condition.
     *
     * @param code represents the already created secret code to be guessed.
     * @param nSymbol represents the chosen potential numbers and characters that can be in the secret code.
     * */
    public static void gameInit(String code, int nSymbol) {
        Scanner sc = new Scanner(System.in);
        int turns = 1;
        System.out.printf("The secret is prepared: %s\n", printInfo(code, nSymbol));
        System.out.println("Okay, let's start a game!");

        while (true) {
            System.out.println("Turn " + turns);
            System.out.print("> ");
            String inp = sc.nextLine();
            int cows = 0;
            int bulls = 0;
            turns++;

            //If symbol is in correct place +1 to bulls.
            for (int i = 0; i < inp.length(); i++) {
                if (inp.charAt(i) == code.charAt(i)) {
                    bulls++;
                }

                //If symbol is present, but not in the right place +1 to cows.
                if (inp.charAt(i) != code.charAt(i) && code.indexOf(inp.charAt(i)) >= 0) {
                    cows++;
                }
            }

            //Win condition.
            if (bulls == code.length()) {
                System.out.printf("Grade: %d bulls\n", bulls);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            //No cows or bulls found then none.
            if (cows == 0 && bulls == 0) {
                System.out.println("Grade: None.");
            }

            //Finally, display amount of bulls and cows.
            else {
                System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
            }
        }
    }
}
