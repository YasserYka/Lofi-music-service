INSERT INTO users (username, password, enabled)
	VALUES ('user', 'pass', true);
INSERT INTO authorities (username, authority)
  VALUES ('user', 'ROLE_USER');
INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Antidepresseur', 1, 1, 'Antidepresseur.mp3', '2c37f2dbc64b.jpeg');
INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Shikutomoto', 1, 1, 'Shikutomoto.mp3', '53457.jpg');
INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Ransom', 1, 1, 'Ransom.mp3', '275-1519562457.jpg');