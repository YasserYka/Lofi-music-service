package io.musicStreaming.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.repository.SongsRepository;

@Service
public class SongService {

	@Autowired
	private SongsRepository repository;
	
	public Page<Song> songsList(int size, int page){	
		return repository.findAll(PageRequest.of(page, size));
	}
}
