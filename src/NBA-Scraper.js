import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NBADataScraper {
    private static final String URL = "https://www.basketball-reference.com/leagues/NBA_2024_totals.html";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Element table = doc.select("table.stats_table").first();
            Elements rows = table.select("tr");

            for (Element row : rows) {
                Elements cols = row.select("td");
                if (cols.size() > 0) {
                    String playerName = cols.get(1).text();
                    double pts = Double.parseDouble(cols.get(6).text());
                    double reb = Double.parseDouble(cols.get(7).text());
                    double ast = Double.parseDouble(cols.get(8).text());
                    double stl = Double.parseDouble(cols.get(10).text());
                    double blk = Double.parseDouble(cols.get(11).text());
                    double to = Double.parseDouble(cols.get(12).text());

                    double fantasyPoints = FantasyCalculator.calculateFantasyPoints(pts, reb, ast, stl, blk, to);
                    System.out.println("Player: " + playerName);
                    System.out.println("Fantasy Points: " + fantasyPoints);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
