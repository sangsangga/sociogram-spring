CREATE table if not exists posts(
    id serial primary key,
    user_id bigint UNSIGNED,
    FOREIGN KEY (user_id) REFERENCES users(id),
    image_url text,
    caption text,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp
);

create index idx_posts_user_id
    on posts(user_id);