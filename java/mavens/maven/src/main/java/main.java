import guru.springframework.norris.chuck.ChuckNorrisQuotes;

public class main {
    public static void main(String[] args) {
        ChuckNorrisQuotes jokes = new ChuckNorrisQuotes();
        System.out.println(jokes.getRandomQuote());
    }
}
