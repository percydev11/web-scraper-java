package com.webscraperjava.webscraper.services;

import com.webscraperjava.webscraper.entities.WebPage;
import com.webscraperjava.webscraper.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository repository;

    public List<WebPage> search(String textSearch) {
        return repository.search(textSearch);
    }
}
