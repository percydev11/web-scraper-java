package com.webscraperjava.webscraper.controllers;

import com.webscraperjava.webscraper.entities.WebPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {

    @RequestMapping(value = "api/search", method = RequestMethod.GET)
    public List<WebPage> search() {
        List<WebPage> result = new ArrayList<>();
        WebPage myPage = new WebPage();
        myPage.setTitle("Test");
        myPage.setDescription("My test page");
        return result;
    }
}
