package com.webscraperjava.webscraper.repositories;

import com.webscraperjava.webscraper.entities.WebPage;

import java.util.List;

public interface SearchRepository {

     List<WebPage> search(String textSearch);

    void save(WebPage webPage);
}
