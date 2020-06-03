package com.brownbag.news.dbservice.bootstrap;

import com.brownbag.news.dbservice.model.NewsNetwork;
import com.brownbag.news.dbservice.repository.NewsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prodmysql")
@Component
public class DbServiceRunner implements CommandLineRunner {

    private final NewsRepository newsRepository;

    public DbServiceRunner(NewsRepository newsRepository) {this.newsRepository = newsRepository;}

    private void loadNewsObjects(){

        if(newsRepository.count() == 0) {
            newsRepository.save(new NewsNetwork(1, "cnn", "CNN"));
            newsRepository.save(new NewsNetwork(2, "bbc-news", "BBC News"));
            newsRepository.save(new NewsNetwork(3, "abc-news", "ABC News"));
        }
    }

    @Override
    public void run(String... args) throws Exception {
        loadNewsObjects();
    }
}

