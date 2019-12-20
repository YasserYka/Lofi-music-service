INSERT INTO song (title, artist_id, album_id, audio_url, image_url) 
	VALUES ('Antidepresseur', 1, 1, 'Antidepresseur.mp3', '2c37f2dbc64b.jpeg');
INSERT INTO authorities (username, authority)
  	values ('user', 'ROLE_USER');
INSERT INTO users (name, username, plan, image_url, email, password, phone_number, signup_date, session_token, enable)
	VALUES ('user1', 'user', 'plan', 'png', 'user1', 'password', '0505', '2001', '23423432', 'true');