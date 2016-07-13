package com.samodeika.multithreading;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Crawler {

    private Queue<String> sitePages;
    private Set<String> visitedPages;
    private Map<String, String> exceptionPages;
    private String basePage;
    private int cpuCores;
    private ExecutorService executorService;

    public Crawler() {
    }

    public Crawler(String basePage) {
        this.basePage = basePage;
        sitePages = new ConcurrentLinkedQueue<>();
        visitedPages = Collections.synchronizedSet(new HashSet<String>());
        exceptionPages = Collections.synchronizedMap(new HashMap<>());
        cpuCores = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(cpuCores);
    }

    public Crawler(String basePage, Queue<String> sitePages) {
        this.basePage = basePage;
        this.sitePages = sitePages;
    }

    public String getBasePage() {
        return basePage;
    }

    public void setBasePage(String basePage) {
        this.basePage = basePage;
    }

    public void printFoundPages() {
        for (String page: visitedPages) {
            System.out.println(page);
        }
    }

    public void printFailedPages() {
        for (String page: exceptionPages.keySet()) {
            System.out.println(page);
        }
    }

    public void start() {
        parsePage(basePage);

        int cntTimeout = 0;

        while (true) {
            if(!sitePages.isEmpty()) {
                cntTimeout = 0;
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        parsePage(getPage());
                    }
                });
            }
            else {
                cntTimeout++;
                if(cntTimeout > 2) {
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getPage(){
        String result = null;
        synchronized (this) {
            if (!sitePages.isEmpty()) {
                result = sitePages.poll();
            }
        }
        return result;
    }

    private void parsePage(String page)
    {
        try
        {
            // System.out.println(page);
            Document doc = null;
            try {
                doc = Jsoup.connect(page).get();
            }
            catch (HttpStatusException | IllegalArgumentException | UnsupportedMimeTypeException ex) {
                exceptionPages.put(page, ex.getMessage());
                return;
            }
            doc = Jsoup.parse(doc.toString());

            String newPage;
            Elements links = doc.select("a[href]");
            for(int i = 0; i < links.size(); i++)
            {
                newPage = links.get(i).attr("href");
                if(!newPage.contains("http") && newPage.startsWith("/") && newPage.length() > 1) {
                    newPage = page + newPage;
                }
                if (newPage != null && !newPage.isEmpty() && newPage.startsWith("http")
                        && newPage.startsWith(basePage)
                        && !visitedPages.contains(newPage)) {
                    addVisitedPage(newPage);
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
        sitePages.add(page);
    }

    private void addVisitedPage(String page) {
        visitedPages.add(page);
    }
}
