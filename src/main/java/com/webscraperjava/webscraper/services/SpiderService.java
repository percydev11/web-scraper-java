package com.webscraperjava.webscraper.services;

import com.webscraperjava.webscraper.entities.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.logging.log4j.util.Strings.isBlank;


@Service
public class SpiderService {

    @Autowired
    private SearchService searchService;
    public String indexWebPage() {

        String url = ("https://www.bbc.com/");
        String content = getWebContent(url);
        if(isBlank(content)) { return "";}

        indexSaveWebPage(url, content);

        goToNextWebPage();


    }

    private void  goToNextWebPage(String content) {

    }

    private void indexSaveWebPage(String url, String content) {
        String title = getTittle(content);
        String description = getDescription(content);

        WebPage webPage = new WebPage();
        webPage.setDescription(description);
        webPage.setTitle(title);
        webPage.setUrl(url);
        searchService.save(webPage);

    }


    public List<String> getLinks(String content) {


        String[] aux = content.split("<title>");
        String [] aux2 =  aux[1].split("</title>");
        return aux2[0];

    }

    public String getTittle(String content) {

        String[] aux = content.split("<title>");
        String [] aux2 =  aux[1].split("</title>");
        return aux2[0];

    }

    public String getDescription(String content) {

        String[] aux = content.split("<meta name=\"description\" content=");
        String [] aux2 =  aux[1].split("\">");
        return aux2[0];

    }

     private  String getWebContent(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();

            Stream<String> lines = new BufferedReader(new InputStreamReader(input))
                    .lines();
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }


}
