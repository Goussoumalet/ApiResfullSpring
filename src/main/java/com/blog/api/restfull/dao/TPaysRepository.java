package com.blog.api.restfull.dao;

import com.blog.api.restfull.entity.TPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPaysRepository extends JpaRepository<TPays, Long> {
}
