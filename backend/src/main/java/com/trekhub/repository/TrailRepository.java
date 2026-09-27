package com.trekhub.repository;

import com.trekhub.entity.Trail;
import com.trekhub.enums.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {
    Optional<Trail> findBySlug(String slug);
    Page<Trail> findByRegion(Region region, Pageable pageable);
}
