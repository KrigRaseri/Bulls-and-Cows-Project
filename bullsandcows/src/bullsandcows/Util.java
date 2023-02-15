package bullsandcows;

import java.util.*;

public class Util {
    public static String randomCode() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        System.out.print("> ");
        int size = sc.nextInt();

        while (size <= 0 || size >= 11) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            size = sc.nextInt();
            System.out.println("> ");

        }

        String code = "";
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        while (set.size() < size) {
            if (set.isEmpty()) {
                set.add(((int) (Math.random()*(10 - 1)) + 1));
            }

            else {
                set.add(rand.nextInt(10));}
        }

        for (Integer integer : set) {
            code += integer.toString();
        }


        return code;
    }



    public static void gameInit() {
        Scanner sc = new Scanner(System.in);

        boolean win = false;
        String num = Util.randomCode();
        int turns = 1;
        System.out.println("Okay, let's start a game!");



        while (true) {
            System.out.println("Turn " + turns);
            System.out.print("> ");
            String inp = sc.nextLine();
            int cows = 0;
            int bulls = 0;
            turns++;


            for (int i = 0; i < inp.length(); i++) {
                if (inp.charAt(i) == num.charAt(i)) {
                    bulls++;
                }

                if (inp.charAt(i) != num.charAt(i) && num.indexOf(inp.charAt(i)) >= 0) {
                    cows++;
                }
            }



            if (bulls == num.length()) {
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
