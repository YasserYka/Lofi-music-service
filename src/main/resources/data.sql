INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Antidepresseur', 1, 1, 'Antidepresseur.mp3', '2c37f2dbc64b.jpeg');
INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Shikutomoto', 1, 1, 'Shikutomoto.mp3', '53457.jpg');
INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Ransom', 1, 1, 'Ransom.mp3', '275-1519562457.jpg');
INSERT INTO users (name, username, plan, image_url, email, password, phone_number, signup_date, session_token, enable)
	VALUES ('user1', 'user', 'plan', 'png', 'user1', 'user', '0505', '2001', '23423432', 'true');
INSERT INTO authorities (username, authority)
  VALUES ('user', 'ROLE_USER');
