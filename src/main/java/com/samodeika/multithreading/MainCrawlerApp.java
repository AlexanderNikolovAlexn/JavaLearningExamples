package com.samodeika.multithreading;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainCrawlerApp {

    public static void main(String[] args) {
        String page = "https://softuni.bg";
        parsePage(page);
    }

    private static void parsePage(String page)
    {
//        if(db.size() >= Crawler.MAX)
//        {
//            return;
//        }

        try
        {
            Document doc = Jsoup.connect(page).get();
            doc = Jsoup.parse(doc.toString());
            String pageText = doc.html();

            String newPage;
            Elements links = doc.select("a[href]");
            for(int i = 0; i < links.size(); i++)
            {
                newPage = links.get(i).attr("href");
                if(!newPage.contains("http") && newPage.startsWith("/") && newPage.length() > 1) {
                    newPage = page + newPage;
                }
                if (newPage != null && !newPage.isEmpty() && newPage.startsWith("http")) {
                    System.out.println(newPage);
                }
            }
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
