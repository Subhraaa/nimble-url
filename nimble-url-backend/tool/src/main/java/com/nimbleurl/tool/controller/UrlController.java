package com.nimbleurl.tool.controller;

import com.nimbleurl.tool.dto.UrlMapDTO;
import com.nimbleurl.tool.entity.UrlMappingEntity;
import com.nimbleurl.tool.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class UrlController {
    @Autowired
    UrlService urlService;

    @PostMapping("/shorten")
    public Map<String, String> shorten(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        String shortUrl = urlService.shortenUrl(originalUrl);

        return Map.of("shortUrl", shortUrl);
    }

    @GetMapping("/{shortCode:[a-zA-Z0-9]+}")
    public void redirect(@PathVariable String shortCode, HttpServletResponse response) throws IOException {

        UrlMapDTO url = urlService.getOriginalUrl(shortCode);
        response.sendRedirect(url.getOriginalUrl());
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}
