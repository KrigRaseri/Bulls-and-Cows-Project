package bullsandcows;


import java.util.Scanner;

public class Main extends Util {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        System.out.print("> ");
        int size = sc.nextInt();

        System.out.println("Input the number of possible symbols in the code:");
        System.out.print("> ");
        int nSymbols = sc.nextInt();



        while (size <= 0 || size >= 36) {
            System.out.println("Error: input incorrect.");
            size = sc.nextInt();
            System.out.println("> ");

        }

        String secretCode = randomCode(size, nSymbols);
        gameInit(secretCode, nSymbols);

    }
}
