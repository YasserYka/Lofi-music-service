package io.musicStreaming.start.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private final String mediaPath = "src/main/resources/static";
	
	//Takes file and save it in given directory path
	public void uploadFileOfKind(MultipartFile file, String name) {
		try {
			Files.copy(file.getInputStream(), Paths.get(pathOf(name) +"/"+ file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {/*TODO:LOG IT*/e.printStackTrace();}
	}
	
	public String pathOf(String name) {return name.equals("image") ? (mediaPath + "/images") : (mediaPath + "/songs");}
}
