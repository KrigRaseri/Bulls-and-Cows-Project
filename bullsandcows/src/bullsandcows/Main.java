package bullsandcows;

public class Main extends Util {
    public static void main(String[] args) {

        //Sets and checks size and nSymbols.
        int size = setSize();
        int nSymbols = setSymbols();

        //Creates the secret code.
        String secretCode = randomCode(size, nSymbols);

        //Starts game.
        gameInit(secretCode, nSymbols);

    }
}
