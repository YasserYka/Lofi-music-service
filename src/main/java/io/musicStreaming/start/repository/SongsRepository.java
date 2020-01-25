package io.musicStreaming.start.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.musicStreaming.start.model.Song;

@Repository
public interface SongsRepository extends PagingAndSortingRepository<Song, Long>{
	public List<Song> findByTitle(String title);
}
