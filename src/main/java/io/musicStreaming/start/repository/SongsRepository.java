package io.musicStreaming.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.musicStreaming.start.model.Song;

public interface SongsRepository extends JpaRepository<Song, Long>{
	public List<Song> findByTitle(String title);
}
