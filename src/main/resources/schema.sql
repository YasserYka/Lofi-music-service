CREATE TABLE users(
	name VARCHAR(128),
    username varchar_ignorecase(50) not null primary key,
	plan VARCHAR(128),
	image_url VARCHAR(128),
	email VARCHAR(128),
    password varchar_ignorecase(50) not null,
	phone_number VARCHAR(128),
	signup_date VARCHAR(128),
    enabled boolean not null
);

CREATE TABLE song (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(128) NOT NULL,
	artist_id INTEGER NOT NULL,
	album_id INTEGER NOT NULL,
	audio_url VARCHAR(128) NOT NULL,
	image_url VARCHAR(128) NOT NULL
);

CREATE TABLE playlist (
	id INTEGER NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id),
	user_id INTEGER NOT NULL,
	title VARCHAR(128) NOT NULL
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
