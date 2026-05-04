package com.nimbleurl.tool.service;

import com.nimbleurl.tool.dto.UrlMapDTO;
import com.nimbleurl.tool.entity.UrlMappingEntity;
import com.nimbleurl.tool.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;

    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        UrlMappingEntity url = new UrlMappingEntity();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        url.setCreatedAt(LocalDateTime.now());

        repository.save(url);

        return "http://localhost:8080/" + shortCode;
    }

    private String generateShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * chars.length());
            code.append(chars.charAt(index));
        }

        return code.toString();
    }

    public UrlMapDTO getOriginalUrl(String shortCode) {
        UrlMappingEntity fetchurl =  repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        ObjectMapper map = new ObjectMapper();
        return map.convertValue(fetchurl,UrlMapDTO.class);

    }
}
