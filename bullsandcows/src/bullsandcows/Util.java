package bullsandcows;

import java.util.*;

public class Util {
    public static String randomCode() {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

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
}
