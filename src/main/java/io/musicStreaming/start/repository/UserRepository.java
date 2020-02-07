package io.musicStreaming.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.musicStreaming.start.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	boolean existsByEmail(String email);
}
