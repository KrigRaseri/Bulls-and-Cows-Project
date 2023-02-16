package bullsandcows;

import java.util.*;

public class Util {
    public static int sizeCheck(int size) {
        Scanner sc = new Scanner(System.in);
        int cSize = size;

        while (cSize <= 0 || cSize >= 36) {
            System.out.println("Error: input incorrect.");
            cSize = sc.nextInt();
            System.out.println("> ");
        }

        return cSize;
    }


    public static int symbolCheck(int nSymbol) {
        Scanner sc = new Scanner(System.in);
        int cSym = nSymbol;

        while (cSym <= 0 || cSym >= 36) {
            System.out.println("Error: input incorrect.");
            cSym = sc.nextInt();
            System.out.println("> ");
        }

        return cSym;
    }


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

        System.out.println(code);
        return code;
    }



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


            for (int i = 0; i < inp.length(); i++) {
                if (inp.charAt(i) == code.charAt(i)) {
                    bulls++;
                }

                if (inp.charAt(i) != code.charAt(i) && code.indexOf(inp.charAt(i)) >= 0) {
                    cows++;
                }
            }



            if (bulls == code.length()) {
                System.out.printf("Grade: %d bulls\n", bulls);
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            if (cows == 0 && bulls == 0) {
                System.out.println("Grade: None.");
            }

            else {
                System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
            }
        }
    }
}
