package io.musicStreaming.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.musicStreaming.start.model.Song;

public interface SongsRepository extends JpaRepository<Song, Long>{}
