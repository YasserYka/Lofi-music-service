package io.musicStreaming.start.controller;

import io.musicStreaming.start.Repository.SongsRepository;
import io.musicStreaming.start.Model.Song;
import io.musicStreaming.start.Exception.SongNotFoundException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/songs")
public class SongController {

	private final SongsRepository repository;
	private static final String SONGS_PATH = "src/main/resource/songs/";
	
	public SongController(SongsRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Song> getSongs() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public void getSong(HttpServletResponse response, @PathVariable Long id) {
		Song song = repository.findById(id).orElseThrow(() ->new SongNotFoundException(id));
		File audio = new File(SONGS_PATH + song.getId());
		addLengthAndNameToResponse((int) audio.length(), song.getTitle(), response);
		writeAudioStreamOnResponse(response, audio);	
	}
	
	private void addLengthAndNameToResponse(int lengthOfFile, String fileName, HttpServletResponse response) {
		  response.setContentType("audio/mpeg"); 
		  response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
		  response.setContentLength(lengthOfFile);
	}
	
	private void writeAudioStreamOnResponse(HttpServletResponse response, File file) {
		ServletOutputStream stream = null;
		BufferedInputStream buffer = null;
		try {
			stream = response.getOutputStream();
			buffer = new BufferedInputStream(new FileInputStream(file));
			int bytes;
			while((bytes = buffer.read()) != -1)
				stream.write(bytes);
			}catch(IOException error) {
				//log it
		}
		makeSureItClosed(stream, buffer);
	}
	
	private void makeSureItClosed(ServletOutputStream stream, BufferedInputStream buffer) {
		try { 
			if(stream != null)
				stream.close();
			if(buffer != null)
				buffer.close();
			}catch(IOException error) {
				//log it
			}
		}
	
}
