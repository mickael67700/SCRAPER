import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;

public class Scraper {
    String[] numeros2019, numeros2020, numeros2018,numeros2017;

    public static void scraperLoto() {
        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("http://www.tirage-euromillions.net/loto/annee/tirages-2020/").get();
            Document doc1 = Jsoup.connect("http://www.tirage-euromillions.net/loto/annee/tirages-2019/").get();
            Document doc2 = Jsoup.connect("http://www.tirage-euromillions.net/loto/annee/tirages-2018/").get();
            Document doc3 = Jsoup.connect("https://www.google.com/search?client=ubuntu&channel=fs&q=actualités&ie=utf-8&oe=utf-8").get();

            // Get the list of repositories
            Elements doc2019 = doc1.getElementsByClass("blue_table");
            Elements doc2020 = doc.getElementsByClass("blue_table");
            Elements doc2018 = doc2.getElementsByClass("blue_table");
            Elements linksGoogle = doc3.getElementsByClass("g");

            String[] numeros2018 = new String[doc2018.size()];
            String[] numeros2019 = new String[doc2019.size()];
            String[] numeros2020 = new String[doc2020.size()];
            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc2.title());
            for (int i = 0, doc2018Size = doc2018.size(); i < doc2018Size; i++) {
                //Element repository = doc2019.get(i);
                //System.out.println(doc2019.get(i).getElementsByClass("game_point").text());
                numeros2018[i] = doc2018.get(i).getElementsByClass("game_point").text();
                System.out.println(numeros2018[i]);
            }

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc1.title());
            for (int i = 0, doc2019Size = doc2019.size(); i < doc2019Size; i++) {
                //Element repository = doc2019.get(i);
                //System.out.println(doc2019.get(i).getElementsByClass("game_point").text());
                numeros2019[i] = doc2019.get(i).getElementsByClass("game_point").text();
                System.out.println(numeros2019[i]);
            }

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc.title());
            for (int i = 0, doc2020Size = doc2020.size(); i < doc2020Size; i++) {
                //Element repository = doc2020.get(i);
                //System.out.println(doc2020.get(i).getElementsByClass("game_point").text());
                numeros2020[i] = doc2020.get(i).getElementsByClass("game_point").text();
                System.out.println(numeros2020[i]);
            }

            System.out.printf("Title: %s\n", doc3.title());
            for (org.jsoup.nodes.Element element : linksGoogle) {

                // System.out.println(linksGoogle.get(i).getElementsByClass("iUh30 bc tjvcx").text());
                System.out.println(element.getElementsByClass("TbwUpd").text() + "\n");
                System.out.println(element.getElementsByClass("r").text() + "\n");
                System.out.println(element.getElementsByClass("st").text());
                //  System.out.println(linksGoogle.get(i).getElementsByClass("LC20lb DKV0Md").text());


            }

            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
