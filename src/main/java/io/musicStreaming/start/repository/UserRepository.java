package io.musicStreaming.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.musicStreaming.start.model.User;

public interface UserRepository extends JpaRepository<User, String>{}
