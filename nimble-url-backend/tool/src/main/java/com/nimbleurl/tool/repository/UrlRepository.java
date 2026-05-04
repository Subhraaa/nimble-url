package com.nimbleurl.tool.repository;

import com.nimbleurl.tool.entity.UrlMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMappingEntity, Long> {
    Optional<UrlMappingEntity> findByShortCode(String shortCode);
}
