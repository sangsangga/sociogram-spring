CREATE table if not exists users(
    id serial primary key,
    username varchar(255),
    email varchar(255),
    password text,
    profile_picture_url text,
    bio text,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp
);

create unique index users_username_unique on users(username);
create unique index users_email_unique on users(email);