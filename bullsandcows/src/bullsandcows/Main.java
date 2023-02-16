package bullsandcows;

/**
 * This program plays the bulls and cows game where you try to guess a secret code. First, enter desired length of code,
 * then how many characters on a range of 1-36 (0-9 and a-z) that the secret code may contain. The program will respond
 * the number of entries are in the right spot (a bull), and number of entries that are in the secret code but not in
 * the correct spot (a cow). Getting all bulls means you guessed the secret code and win.
 *
 * @author Krig Raseri (pen name).
 *
 * */
public class Main extends Util {
    public static void main(String[] args) {

        //Sets and checks size and nSymbols.
        int size = setSize();
        int nSymbols = setSymbols();

        //Checks size vs nSymbols.
        if (size > nSymbols) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d " +
                    "unique symbols.\n", size, nSymbols);

            System.exit(1);
        }

        //Creates the secret code.
        String secretCode = randomCode(size, nSymbols);

        //Starts game.
        gameInit(secretCode, nSymbols);

    }
}
