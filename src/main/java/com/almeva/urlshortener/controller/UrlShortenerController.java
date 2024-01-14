package com.almeva.urlshortener.controller;

import com.almeva.urlshortener.models.UrlShortenerRequest;
import com.almeva.urlshortener.service.UrlShortenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("url/shortener")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/process")
    public String processURL(@RequestBody UrlShortenerRequest request){
        return urlShortenerService.getShortUrl(request.getLongURL());
    }
}
