package com.nimbleurl.tool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "url_mapping")
public class UrlMappingEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String originalUrl;

        @Column(unique = true)
        private String shortCode;

        private LocalDateTime createdAt;

        // getters/setters

}
