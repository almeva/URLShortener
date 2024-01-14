package com.almeva.urlshortener.service.impl;

import com.almeva.urlshortener.service.UrlShortenerService;
import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkRequest;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UrlShortenerImpl implements UrlShortenerService{

    @Value("${bitly_token}")
    private String bitlyToken;
    private Bitly client;

    @PostConstruct
    public void setup(){
        client = new Bitly(bitlyToken);
    }
    @Override
    public String getShortUrl(String longURL) {
        try{
            CreateBitlinkResponse response = client.bitlinks().shorten(longURL).get();
            return response.getLink();
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
