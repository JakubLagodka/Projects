import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //<span class="results-header__offer-count-text-number">3280</span>
        try {
            Document document = Jsoup.connect("https://www.pracuj.pl/praca/java%20developer;kw/borycz%20(pow.%20strzelecki);wp?rd=30").get();
            Elements elements = document.getElementsByClass("results-header__offer-count-text-number");
            System.out.println("Liczba ofert pracy w Javie to = " + elements.get(0).text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
