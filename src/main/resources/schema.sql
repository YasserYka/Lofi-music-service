CREATE TABLE song (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(128) NOT NULL,
	artist_id INTEGER NOT NULL,
	album_id INTEGER NOT NULL,
	audio_url VARCHAR(128) NOT NULL,
	image_url VARCHAR(128) NOT NULL
);

CREATE TABLE users (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	plan VARCHAR(128) NOT NULL,
	image_url VARCHAR(128) NOT NULL,
	email VARCHAR(128) NOT NULL,
	password VARCHAR(128) NOT NULL,
	phone_number VARCHAR(128) NOT NULL,
	signup_date VARCHAR(128) NOT NULL,
	session_token VARCHAR(128) NOT NULL,
	enable BOOLEAN NOT NULL
);

CREATE TABLE authorities (
      username VARCHAR(50) not null,
      authority VARCHAR(50) not null,
	  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE playlist (
	id INTEGER NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id),
	user_id INTEGER NOT NULL,
	title VARCHAR(128) NOT NULL
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);