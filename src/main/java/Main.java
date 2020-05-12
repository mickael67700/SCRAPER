import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Votre choix : \n1. Exemple récupération tirages loto.\n2. Récupération href d'après url.");
        int choix = new Scanner(System.in).nextInt();
        if (choix ==1){
            Scraper.scraperLoto();
        }
        if(choix ==2){
            ListLinks.listesHref();
        }

    }
}
