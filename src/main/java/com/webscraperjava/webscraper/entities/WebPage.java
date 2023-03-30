package com.webscraperjava.webscraper.entities;

import jakarta.persistence.Entity;

@Entity
public class WebPage {
    private String url;
    private String title;
    private String description;
}

