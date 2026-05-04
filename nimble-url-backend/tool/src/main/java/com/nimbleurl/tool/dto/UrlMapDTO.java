package com.nimbleurl.tool.dto;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class UrlMapDTO {

    private Long id;

    private String originalUrl;


    private String shortCode;

    private LocalDateTime createdAt;
}
