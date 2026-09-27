package com.trekhub.repository;

import com.trekhub.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    @EntityGraph(attributePaths = {"author", "taggedTrail"})
    @Query("SELECT p FROM Post p WHERE p.deleted = false ORDER BY p.createdAt DESC")
    Page<Post> findFeedPosts(Pageable pageable);

    @EntityGraph(attributePaths = {"author", "taggedTrail"})
    @Query("SELECT p FROM Post p WHERE p.author.id = :authorId AND p.deleted = false ORDER BY p.createdAt DESC")
    Page<Post> findByAuthorId(@Param("authorId") UUID authorId, Pageable pageable);

    @EntityGraph(attributePaths = {"author", "taggedTrail"})
    @Query("SELECT p FROM Post p WHERE p.taggedTrail.id = :trailId AND p.deleted = false ORDER BY p.createdAt DESC")
    Page<Post> findByTaggedTrailId(@Param("trailId") Long trailId, Pageable pageable);

    @EntityGraph(attributePaths = {"author", "taggedTrail"})
    Optional<Post> findByIdAndDeletedFalse(UUID id);
}
