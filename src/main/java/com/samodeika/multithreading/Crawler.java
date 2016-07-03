package com.samodeika.multithreading;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Crawler {

    private Map<KeyFlag, String> sitePages;
    private String page;

    public Crawler() {
    }

    public Crawler(String page) {
        this.page = page;
        sitePages = new ConcurrentHashMap<>();
    }

    public Crawler(String page, Map<KeyFlag, String> sitePages) {
        this.page = page;
        this.sitePages = sitePages;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    private void parsePage()
    {
        try
        {
            Document doc = Jsoup.connect(page).get();
            doc = Jsoup.parse(doc.toString());

            String newPage;
            Elements links = doc.select("a[href]");
            for(int i = 0; i < links.size(); i++)
            {
                newPage = links.get(i).attr("href");
                if(!newPage.contains("http") && newPage.startsWith("/") && newPage.length() > 1) {
                    newPage = page + newPage;
                }
                if (newPage != null && !newPage.isEmpty() && newPage.startsWith("http")) {
                    addPage(newPage);
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

    private void addPage(String page) {
        sitePages.put(new KeyFlag(page), page);
    }
}
