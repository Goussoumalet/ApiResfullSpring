package com.blog.api.restfull.dao;

import com.blog.api.restfull.entity.TCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TCategoryRepository  extends JpaRepository<TCategory, Long> {
}
