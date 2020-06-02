package com.brownbag.news.dbservice.controller;

import com.brownbag.news.dbservice.model.NewsNetwork;
import com.brownbag.news.dbservice.service.NewsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/db")
public class DbServiceController {

    private final NewsService newsService;

    public DbServiceController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/networks")
    public ResponseEntity<List<NewsNetwork>> getAllNews() {
        return new ResponseEntity<>(newsService.getNetworks(), HttpStatus.OK);
    }

    @GetMapping("/networks/{id}")
    public ResponseEntity<NewsNetwork> getNewsNetworkById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(newsService.getNewsServiceById(id), HttpStatus.OK);
    }

    @GetMapping("/networks/name/{name}")
    public ResponseEntity<NewsNetwork> getNewsNetworkByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(newsService.getNewsServiceByName(name), HttpStatus.OK);
    }

    @PostMapping("/networks")
    public ResponseEntity saveNews(@RequestBody NewsNetwork newsNetwork){
        NewsNetwork network= newsService.saveNetwork(newsNetwork);
        HttpHeaders headers = new HttpHeaders();

        headers.add("networkNewsResource", "api/v1/db/"+network.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

}

