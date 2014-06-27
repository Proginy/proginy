package com.proginy.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proginy.base.domain.User;

public interface UserRepository extends JpaRepository<User, Long>
{
}
