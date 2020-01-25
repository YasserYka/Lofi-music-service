package io.musicStreaming.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.musicStreaming.start.exception.SongNotFoundException;
import io.musicStreaming.start.model.Song;
import io.musicStreaming.start.repository.SongsRepository;

@Service
public class SongService {

	@Autowired
	private SongsRepository repository;
	
	public Page<Song> songsList(int size, int page){	
		return repository.findAll(PageRequest.of(page, size));
	}
	
	public Song findById(Long id) {
		return repository.findById(id).orElseThrow(() ->new SongNotFoundException(id));
	}

	public void saveSong(String title, String artistName, MultipartFile image, MultipartFile audio) {
		
		Song song = new Song();
		song.setTitle(title);
		song.setArtistName(artistName);
		song.setImageUrl("/images/"+ image.getOriginalFilename());
		song.setAudioUrl("/songs/"+ audio.getOriginalFilename());
		
		repository.save(song);
	}
}
