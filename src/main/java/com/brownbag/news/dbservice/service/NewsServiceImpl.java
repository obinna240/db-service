package com.brownbag.news.dbservice.service;

import com.brownbag.news.dbservice.model.NewsNetwork;
import com.brownbag.news.dbservice.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public NewsNetwork getNewsServiceById(Integer serialId) {
        return newsRepository.findById(serialId).orElse(new NewsNetwork(13000, "Non existent", "Non existent"));
    }

    @Override
    public NewsNetwork getNewsServiceByName(String name) {
        List<NewsNetwork> names = newsRepository.findByName(name);
        return names.stream().findFirst().orElse(new NewsNetwork(13000, "Non existent", "Non existent"));
    }

    @Override
    public List<NewsNetwork> getNetworks() {
        return newsRepository.findAll();
    }

    @Override
    public NewsNetwork saveNetwork(NewsNetwork newsNetwork) {
        return newsRepository.save(newsNetwork);
    }
}
