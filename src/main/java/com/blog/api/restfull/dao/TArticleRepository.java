package com.blog.api.restfull.dao;

import com.blog.api.restfull.entity.TArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TArticleRepository extends JpaRepository<TArticle, Long> {
}
