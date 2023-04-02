package com.webscraperjava.webscraper.services;

import com.webscraperjava.webscraper.entities.WebPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

public List<WebPage> search(String textSearch) {
    List<WebPage> result = new ArrayList<>();
    WebPage page = new WebPage();
    page.setTitle("Test");
    page.setDescription("Test");
    result.add(page);
    return result;
}
}
