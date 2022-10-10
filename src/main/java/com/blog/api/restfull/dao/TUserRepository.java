package com.blog.api.restfull.dao;

import com.blog.api.restfull.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserRepository extends JpaRepository<TUser, Long> {
}
