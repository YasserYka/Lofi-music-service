CREATE TABLE users(
	name VARCHAR(128),
    username varchar_ignorecase(50) not null primary key,
	plan VARCHAR(128),
	image_url VARCHAR(128),
	email VARCHAR(128),
    password varchar_ignorecase(50) not null,
	phone_number VARCHAR(128),
	signup_date VARCHAR(128),
    enabled boolean not null,
    roles VARCHAR(128) not null
);

CREATE TABLE song (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(128) NOT NULL,
	artist_name VARCHAR(128) NOT NULL,
	audio_url VARCHAR(128) NOT NULL,
	image_url VARCHAR(128) NOT NULL
);