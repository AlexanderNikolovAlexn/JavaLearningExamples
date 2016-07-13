package com.samodeika.multithreading;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainCrawlerApp {

    public static void main(String[] args) {
        String page = "https://blog.docker.com/2016/05/docker-net-core-clr-rc2/";
        Crawler crawler = new Crawler(page);

        System.out.println("Program started!");
        System.out.println("----------------------------------------");

        long startTime = System.currentTimeMillis();

        crawler.start();
        crawler.stop();

        long stopTime = System.currentTimeMillis();

        crawler.printFoundPages();

        System.out.println("----------------------------------------");
        System.out.println("Program ended!");
        System.out.println("Total time: " + getTotalTime(startTime, stopTime) + " s");
    }

    private static String getTotalTime(double startTime, double endTime) {
        DecimalFormat df = new DecimalFormat("#.##");
        double f = ((endTime - startTime) / 1000);
        return df.format(f);
    }

}
