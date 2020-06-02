package com.brownbag.news.dbservice.service;

import com.brownbag.news.dbservice.model.NewsNetwork;

import java.util.List;

public interface NewsService {

    NewsNetwork getNewsServiceById(Integer serialId);
    NewsNetwork getNewsServiceByName(String name);
    List<NewsNetwork> getNetworks();
    NewsNetwork saveNetwork(NewsNetwork newsNetwork);
}

