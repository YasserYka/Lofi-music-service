package io.musicStreaming.start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.musicStreaming.start.Model.Song;

public interface SongsRepository extends JpaRepository<Song, Long>{

}
