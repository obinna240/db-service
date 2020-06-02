package com.brownbag.news.dbservice.repository;

import com.brownbag.news.dbservice.model.NewsNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsNetwork, Integer> {

    List<NewsNetwork> findByName(String name);
}
