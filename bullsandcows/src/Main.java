import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean win = false;
        String num = "1234";


        while (!win) {
            System.out.print("> ");
            String inp = sc.nextLine();
            int cows = 0;
            int bulls = 0;

            for (int i = 0; i < inp.length(); i++) {
                if (inp.charAt(i) == num.charAt(i)) {
                    bulls++;
                }

                if (inp.charAt(i) != num.charAt(i) && num.indexOf(inp.charAt(i)) >= 0) {
                    cows++;
                }
            }

            if (bulls == 4) {
                win = true;
                cows = 0;
            }

            if (cows == 0 && bulls == 0) {
                System.out.printf("Grade: None. The secret code is %s.\n", num);
            }

            else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n", bulls, cows, num);
            }

        }



    }
}
