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

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
