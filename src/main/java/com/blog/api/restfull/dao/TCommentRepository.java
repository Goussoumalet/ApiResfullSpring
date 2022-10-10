package com.blog.api.restfull.dao;

import com.blog.api.restfull.entity.TComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TCommentRepository extends JpaRepository<TComment, Long> {
}
