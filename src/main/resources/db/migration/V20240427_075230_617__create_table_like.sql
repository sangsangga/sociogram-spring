CREATE table if not exists likes(
    id serial primary key,
    user_id bigint UNSIGNED,
    FOREIGN KEY (user_id) REFERENCES users(id),
    post_id bigint unsigned,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at timestamp
);

create index idx_likes_user_id
    on likes(user_id);

create index idx_likes_post_id
    on likes(post_id);